package domain.PartyArticle;

import domain.PartyArticle.LendableState;
import domain.PartyArticle.PartyArticle;

import java.util.ArrayList;
import java.util.List;

public class FunForRent {

    private List<PartyArticle> products;

    public FunForRent() {
        this.products = new ArrayList<>();
    }

    public void voegToe(String naam, double prijs) {
        products.add(new PartyArticle(prijs, naam));
    }

    public void verwijder(String name) {
        get(name).getDamagedState();
    }

    public double leenUit(String name) {
        return get(name).getLendableState().Lend();
    }

    public double brengTerug(String name, boolean damage) {
        return get(name).getLendedState().Return(damage);
    }

    public void repareer(String name) {
        get(name).getDamagedState().Repair();
    }

    public String toonBeschikbaar() {
        String res = "";
        for (PartyArticle product : products) {
            if (product.getState() instanceof LendableState) {
                res += product.getNaam() + "\n";
            }
        }
        return res;
    }

    private PartyArticle get(String name) {
        for (PartyArticle p : products) {
            if (p.getNaam().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
