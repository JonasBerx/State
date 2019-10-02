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
    public void Lend() {
        System.out.println("het is verwijdert dus je kan het niet lenen");
    }

    @Override
    public void Return(Boolean b) {
        System.out.println("je kan iets verwijdert niet terugbrengen");
    }

    @Override
    public void Repair() {
        System.out.println("je kan iets verwijdert niet repareren");
    }
}
