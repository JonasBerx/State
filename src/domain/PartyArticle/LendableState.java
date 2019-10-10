package domain.PartyArticle;

public class LendableState implements IState {
    private PartyArticle partyArticle;

    public LendableState(PartyArticle partyArticle) {
        this.partyArticle = partyArticle;
    }

    @Override
    public void delete() {
        partyArticle.setState(partyArticle.getDeletedState());
    }

    @Override
    public double lend() {
        partyArticle.setState(partyArticle.getLentState());
        return partyArticle.getPrice();
    }
}
