package domain.PartyArticle;

import domain.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunForRent {
    private List<PartyArticle> articles;

    public FunForRent() {
        this.articles = new ArrayList<>();
    }

    public void add(PartyArticle article) {
        articles.add(article);
    }

    public void remove(PartyArticle article) {
        articles.remove(article);
    }

    public List<PartyArticle> getLendable() {
        return articles.stream().filter(a -> a.getState() instanceof LendableState).collect(Collectors.toList());
    }

    private PartyArticle get(String name) {
        return articles.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
    }

    public List<PartyArticle> getAll() {
        return articles;
    }
}
