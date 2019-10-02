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
    public void Lend() {
        System.out.println("je kan het niet lenen wanneer het beschadigd is");
    }

    @Override
    public void Return(Boolean b) {
        System.out.println("je kan niet terugbrengen want het is al terug");
    }

    @Override
    public void Repair() {
        System.out.println("je repareert");
        partyArticle.setState(partyArticle.getLendableState());
    }
}
