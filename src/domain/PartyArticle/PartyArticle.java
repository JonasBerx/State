package domain.PartyArticle;

public class PartyArticle {
    private IState DamagedState;
    private IState DeletedState;
    private IState LendableState;
    private IState LendedState;

    //  price??
    private double price;
    private String naam;    //current state
    private IState state;
    //int count = 0;


    public PartyArticle(double prijs, String naam) {
        DamagedState = new DamagedState(this);
        DeletedState = new DeletedState(this);
        LendableState = new LendableState(this);
        LendedState = new LendedState(this);
        this.state = LendableState;
        this.price = prijs;
        this.naam = naam;
    }

    public double getPrice() {
        return price;
    }

    public String getNaam() {
        return naam;
    }

    //   moet nog ergens een return voor de boete prijs
    public void setState(IState state) {
        this.state = state;
    }

    public IState getDamagedState() {
        return DamagedState;
    }

    public IState getDeletedState() {
        return DeletedState;
    }

    public IState getLendableState() {
        return LendableState;
    }

    public IState getLendedState() {
        return LendedState;
    }

    public IState getState() {
        return state;
    }

}
