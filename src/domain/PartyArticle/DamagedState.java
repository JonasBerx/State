package domain.PartyArticle;

public class DamagedState implements IState {
    private PartyArticle partyArticle;

    public DamagedState(PartyArticle partyArticle) {
        this.partyArticle = partyArticle;
    }

    @Override
    public void Delete() {
        System.out.println("je verwijdert je product");
        partyArticle.setState(partyArticle.getDeletedState());
    }

    @Override
    public double Lend() {
        System.out.println("je kan het niet lenen wanneer het beschadigd is");
        return 0;
    }

    @Override
    public double Return(Boolean b) {
        System.out.println("je kan niet terugbrengen want het is al terug");
        return 0;
    }

    @Override
    public void Repair() {
        System.out.println("je repareert");
        partyArticle.setState(partyArticle.getLendableState());
    }
}
