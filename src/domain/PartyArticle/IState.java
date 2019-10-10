package domain.PartyArticle;

import domain.IllegalPaState;

public interface IState {
    default String getErrTemplate() {
        return String.format("cannot %%s a %s article", getName());
    }
    default String getName() { return this.getClass().getSimpleName().toLowerCase().replace("state", ""); };

    default void delete() throws IllegalPaState {
        throw new IllegalPaState(String.format(getErrTemplate(), "delete"));
    };
    default double lend() throws IllegalPaState {
        throw new IllegalPaState(String.format(getErrTemplate(), "lend"));
    };
    default double bringBack(Boolean damaged) throws IllegalPaState {
        throw new IllegalPaState(String.format(getErrTemplate(), "return"));
    };
    default void repair() throws IllegalPaState {
        throw new IllegalPaState(String.format(getErrTemplate(), "repair"));
    };
}
