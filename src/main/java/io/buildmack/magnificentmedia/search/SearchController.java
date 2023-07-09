package io.buildmack.magnificentmedia.search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Controller
public class SearchController {

    private  final WebClient webClient;

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
            model.addAttribute("searchResult", result);
        return "search";

    }
    
}
