package domain.PartyArticle;

public interface IState {
    void Delete();
    void Lend();

    void Return(Boolean beschadigd);
    void Repair();
}
