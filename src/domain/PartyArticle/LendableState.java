package domain.PartyArticle;

public class LendableState implements IState {
    private PartyArticle partyArticle;

    public LendableState(PartyArticle partyArticle) {
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
