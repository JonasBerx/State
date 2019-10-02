package domain.PartyArticle;

public class DeletedState implements IState {

    private PartyArticle partyArticle;

    public DeletedState(PartyArticle partyArticle) {
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
