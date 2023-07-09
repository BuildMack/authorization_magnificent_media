package io.buildmack.magnificentmedia.search;

import java.util.List;

public class SearchResult {

    private int numFound;
    private List<SearchResultBook> docs;

    public int getNumFound() {
        return this.numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }


    public List<SearchResultBook> getDocs() {
        return this.docs;
    }

    public void setDocs(List<SearchResultBook> docs) {
        this.docs = docs;
    }
    
}
