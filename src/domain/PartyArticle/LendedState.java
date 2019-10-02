package domain.PartyArticle;

public class LendedState implements IState {
    private PartyArticle partyArticle;

    public LendedState(PartyArticle partyArticle) {
        this.partyArticle = partyArticle;
    }

    @Override
    public void Delete() {
        System.out.println("kan niet deleten wanneer uitgeleend");
    }

    @Override
    public void Lend() {
        System.out.println("je bent het boek al aan het lenen");
    }

    @Override
    public void Return(Boolean beschadigd) {
        if (beschadigd) {
            partyArticle.setState(partyArticle.getDamagedState());
        } else {
            partyArticle.setState(partyArticle.getLendableState());
        }

    }

    @Override
    public void Repair() {
        System.out.println("boek kan nog niet gerepareed worden want het is nog niet binnengebracht");
    }
}
