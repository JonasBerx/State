package db;

import domain.PartyArticle.PartyArticle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PartyArticleDb {
    Map<String, PartyArticle> partyArticles = new HashMap<String, PartyArticle>();

    public boolean exists(String name) {
        return partyArticles.containsKey(name);
    }

    public void add(String name, PartyArticle article) {
        this.partyArticles.put(name, article);
    }

    public void remove(String name) {
        this.partyArticles.remove(name);
    }

    public PartyArticle get(String name) {
        return this.partyArticles.get(name);
    }
}
