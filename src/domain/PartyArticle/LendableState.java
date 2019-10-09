package domain.PartyArticle;

public class LendableState implements IState {
    private PartyArticle partyArticle;

    public LendableState(PartyArticle partyArticle) {
        this.partyArticle = partyArticle;
    }

    @Override
    public void Delete() {
        System.out.println("je wil het boek dus verwijderen");
        partyArticle.setState(partyArticle.getDeletedState());
    }

    @Override
    public double Lend() {
        System.out.println("je wilt het boek uitlenen");
        partyArticle.setState(partyArticle.getLendedState());
        return 0;
    }

    @Override
    public double Return(Boolean beschadigd) {
        System.out.println("je kan geen artikel terugbrengen dat je nog niet geleend hebt!");
        return 0;
    }

    @Override
    public void Repair() {
        System.out.println("Je kan geen artikel repareren als je het nog niet geleend hebt!!");
    }
}
