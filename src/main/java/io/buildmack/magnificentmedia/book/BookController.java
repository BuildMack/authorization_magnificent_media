package io.buildmack.magnificentmedia.book;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.buildmack.magnificentmedia.userbooks.UserBooks;
import io.buildmack.magnificentmedia.userbooks.UserBooksPrimaryKey;
import io.buildmack.magnificentmedia.userbooks.UserBooksRepository;

@Controller
public class BookController {

    private final String COVER_IMAGE_ROOT = "https://covers.openlibrary.org/b/id/";

    @Autowired BookRepository bookRepository;
    @Autowired UserBooksRepository userBooksRepository;

    @GetMapping(value = "/books/{bookId}")
    public String getBook(@PathVariable String bookId, Model model, @AuthenticationPrincipal OAuth2User principal){
        Optional<Book> optionalBook = bookRepository.findById(bookId); 

        if (optionalBook.isPresent()){
            Book book = optionalBook.get();
            String coverImageUrl = "noimage.png";   
            if(book.getCoverIds() != null & book.getCoverIds().size() > 0){
                coverImageUrl = COVER_IMAGE_ROOT + book.getCoverIds().get(0) + "-L.jpg";
            } 
            model.addAttribute("coverImage", coverImageUrl);
            model.addAttribute("book", book);

            if(principal != null && principal.getAttribute("login") != null){
                String userId = principal.getAttribute("login");
                model.addAttribute("login", userId);
                UserBooksPrimaryKey key = new UserBooksPrimaryKey();
                key.setBookId(bookId);
                key.setUserId(userId);
                Optional<UserBooks> userBooks = userBooksRepository.findById(key);
                if (userBooks.isPresent()){
                    model.addAttribute("userBooks", userBooks.get());
                }else {
                    model.addAttribute("userBooks", new UserBooks());

                }
            }

            return "book";

        } 
        return "book-not-found";
    }
}
