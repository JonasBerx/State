package domain.PartyArticle;

public class LendedState implements IState {
    private PartyArticle partyArticle;

        public LendedState(PartyArticle partyArticle) {
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
