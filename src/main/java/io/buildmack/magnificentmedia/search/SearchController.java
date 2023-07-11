package io.buildmack.magnificentmedia.search;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.util.internal.StringUtil;
import reactor.core.publisher.Mono;

@Controller
public class SearchController {

    private  final WebClient webClient;
    private final String COVER_IMAGE_ROOT = "https://covers.openlibrary.org/b/id/";

    public SearchController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.exchangeStrategies(ExchangeStrategies.builder()
        .codecs(configurer-> configurer
                .defaultCodecs()
                .maxInMemorySize(16*1024*1024))
            .build()).baseUrl("http://openlibrary.org/search.json").build();
    }

    @GetMapping(value = "/search")
    public String getSearchResults(@RequestParam String query, Model model) {
       Mono<SearchResult> resultsMono =  this.webClient.get()
            .uri("?q={query}", query)
            .retrieve().bodyToMono(SearchResult.class);
            SearchResult result = resultsMono.block(); // This is the full response payload
            List<SearchResultBook> books = result.getDocs()
                .stream()
                .limit(10)
                .map(bookResult -> {
                    bookResult.setKey(bookResult.getKey().replace("/works/", ""));
                    String coverID = bookResult.getCover_i();
                    if (StringUtils.hasText(coverID)){

                        coverID = COVER_IMAGE_ROOT + coverID + "-M.jpg";
                    }else{

                        coverID = "noimage.png";
                    }
                    bookResult.setCover_i(coverID);
                    return bookResult;
                })
                .collect(Collectors.toList());
            model.addAttribute("searchResult", books);
        return "search";

    }
    
}
