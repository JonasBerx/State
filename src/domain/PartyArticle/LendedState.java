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
    public double Lend() {
        System.out.println("je bent het boek al aan het lenen");
        return 0;
    }

    @Override
    public double Return(Boolean beschadigd) {
        if (beschadigd) {
            partyArticle.setState(partyArticle.getDamagedState());
        } else {
            partyArticle.setState(partyArticle.getLendableState());
        }

        return 0;
    }

    @Override
    public void Repair() {
        System.out.println("boek kan nog niet gerepareed worden want het is nog niet binnengebracht");
    }
}
