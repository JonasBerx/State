package domain.PartyArticle;

public class DeletedState implements IState {

    private PartyArticle partyArticle;

    public DeletedState(PartyArticle partyArticle) {
        this.partyArticle = partyArticle;
    }
    @Override
    public void Delete() {
        System.out.println("je kan niets verwijderen dat al verwijdert is");
    }

    @Override
    public double Lend() {
        System.out.println("het is verwijdert dus je kan het niet lenen");
        return 0;
    }

    @Override
    public double Return(Boolean b) {
        System.out.println("je kan iets verwijdert niet terugbrengen");
        return 0;
    }

    @Override
    public void Repair() {
        System.out.println("je kan iets verwijdert niet repareren");
    }
}
