package domain.PartyArticle;

import domain.DomainException;
import domain.IllegalPaState;

public class PartyArticle {
    private IState DamagedState;
    private IState DeletedState;
    private IState LendableState;
    private IState LentState;

    private double price;
    private String name;
    private IState state;


    public PartyArticle(String name, double price) throws DomainException {
        DamagedState = new DamagedState(this);
        DeletedState = new DeletedState();
        LendableState = new LendableState(this);
        LentState = new LentState(this);
        this.state = LendableState;
        this.setName(name);
        this.setPrice(price);
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) throws DomainException {
        if (!(price > 0.00))
            throw new DomainException("<price> must be greater than 0.00");

        this.price = price;
    }

    public double getDamageCompensationPrice() {
        return getPrice() / 3;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws DomainException {
        if (name == null)
            throw new DomainException("<name> must not be null");

        name = name.trim();

        if (name.isEmpty())
            throw new DomainException("<name> must not be empty");

        this.name = name;
    }

    public String getStateName() {
        return this.getState().getName();
    }

    public void delete() throws IllegalPaState {
        this.getState().delete();
    }

    public double lend() throws IllegalPaState {
        return this.getState().lend();
    }

    public double bringBack(Boolean damaged) throws IllegalPaState {
        return this.getState().bringBack(damaged);
    }

    public void repair() throws IllegalPaState {
        this.getState().repair();
    }

    void setState(IState state) {
        this.state = state;
    }

    IState getDamagedState() {
        return DamagedState;
    }

    IState getDeletedState() {
        return DeletedState;
    }

    IState getLendableState() {
        return LendableState;
    }

    IState getLentState() {
        return LentState;
    }

    IState getState() {
        return state;
    }

}
