package domain.PartyArticle;

public class DamagedState implements IState {
    private PartyArticle partyArticle;

    public DamagedState(PartyArticle partyArticle) {
        this.partyArticle = partyArticle;
    }

    @Override
    public void Delete() {

    }

    @Override
    public void Lend() {

    }

    @Override
    public void Return() {

    }

    @Override
    public void Repair() {

    }
}
