package domain.PartyArticle;

public class DamagedState implements IState {
    private PartyArticle partyArticle;

    public DamagedState(PartyArticle partyArticle) {
        this.partyArticle = partyArticle;
    }

    @Override
    public void delete() {
        partyArticle.setState(partyArticle.getDeletedState());
    }

    @Override
    public void repair() {
        partyArticle.setState(partyArticle.getLendableState());
    }
}
