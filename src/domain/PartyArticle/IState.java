package domain.PartyArticle;

public interface IState {
    void Delete();
    double Lend();

    double Return(Boolean beschadigd);
    void Repair();
}
