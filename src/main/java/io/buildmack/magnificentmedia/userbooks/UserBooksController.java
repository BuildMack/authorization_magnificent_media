package io.buildmack.magnificentmedia.userbooks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserBooksController {

    @Autowired UserBooksRepository userBooksRepository;
    @Autowired UserBooksRepository booksRepository;

    @PostMapping("/addUserBook")
    public ModelAndView addBookForUser(
        @RequestBody MultiValueMap<String, String> formData,
        @AuthenticationPrincipal OAuth2User principal)
    {

        UserBooks userBooks = new UserBooks();
        UserBooksPrimaryKey key = new UserBooksPrimaryKey();

        key.setUserId(null);
        userBooks.setKey(key);
        key.setUserId(principal.getAttribute("login"));
        String bookId = formData.getFirst("bookId");
        key.setBookId(bookId);
        


        if(principal == null || principal.getAttribute("login") == null){
            return null;        
        }
        
        userBooks.setStartDate(LocalDate.parse(formData.getFirst("startDate")));
        userBooks.setEndDate(LocalDate.parse(formData.getFirst("endDate")));
        //userBooks.setRating(Integer.parseInt(formData.getFirst("endDate")));
        userBooks.setReadingStatus(formData.getFirst("readingStatus"));
        
        userBooksRepository.save(userBooks);

        return new ModelAndView("redirect:/books/" + bookId);
    }
    
}
