package domain.PartyArticle;

public class LentState implements IState {
    private PartyArticle partyArticle;

    public LentState(PartyArticle partyArticle) {
        this.partyArticle = partyArticle;
    }

    @Override
    public double bringBack(Boolean damaged) {
        if (damaged) {
            partyArticle.setState(partyArticle.getDamagedState());
            return partyArticle.getDamageCompensationPrice();
        }

        partyArticle.setState(partyArticle.getLendableState());
        return 0;
    }
}
