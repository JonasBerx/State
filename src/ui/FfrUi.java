package ui;

import domain.DomainException;
import domain.IllegalPaState;
import domain.PartyArticle.FunForRent;
import domain.PartyArticle.PartyArticle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.LinkedList;

public class FfrUi extends Application {
    private FunForRent ffr = new FunForRent();
    private Stage stage = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        mainMenu();
    }

    private void mainMenu() {
        var root = jfxHelpers.root(stage::close);
        var rootChildren = root.getChildren();

        rootChildren.add(jfxHelpers.title("Main menu"));

        rootChildren.add(new Label("Party item..."));
        HBox actionsCont = new HBox();
        actionsCont.setSpacing(5);
        var actionsContChildren = actionsCont.getChildren();

        actionsContChildren.add(jfxHelpers.button("Add new", actionEvent -> this.addNew()));
        actionsContChildren.add(jfxHelpers.button("Edit existing", actionEvent -> this.editExisting()));

        rootChildren.add(actionsCont);

        rootChildren.add(jfxHelpers.button("Exit", actionEvent -> stage.close()));

        this.showRegion(root);
    }

    private void addNew() {
        var root = jfxHelpers.root(this::mainMenu);
        var rootChildren = root.getChildren();
        rootChildren.add(jfxHelpers.title("New party item"));

        rootChildren.add(new Label("Name..."));
        var nameInput = new TextField("");
        var priceInput = new Spinner<Double>();
        rootChildren.add(nameInput);
        rootChildren.add(priceInput);

        priceInput.setEditable(true);
        var valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, Double.MAX_VALUE, 0.00, 0.01);
        priceInput.setValueFactory(valueFactory);
        EventHandler<ActionEvent> addEvent = a -> {
            PartyArticle article = null;
            try {
                article = new PartyArticle(nameInput.getCharacters().toString(), priceInput.getValue());
            } catch (DomainException ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Bad input");
                alert.setContentText("Bad input: " + ex.getMessage());
                alert.showAndWait();
            }
            if (article != null) {
                ffr.add(article);
                mainMenu();
            }
        };
        nameInput.setOnAction(addEvent);
        priceInput.getEditor().setOnAction(addEvent);

        HBox actionsCont = new HBox();
        actionsCont.setSpacing(5);
        var actionsContChildren = actionsCont.getChildren();
        actionsContChildren.add(jfxHelpers.button("Add", addEvent));
        actionsContChildren.add(jfxHelpers.button("Cancel", actionEvent -> this.mainMenu()));

        rootChildren.add(actionsCont);

        this.showRegion(root);
    }

    private static void illegalPaStateExceptionHandler(IllegalPaState ex) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Article state exception");
        alert.setHeaderText("Illegal state change requested");
        var msg = ex.getMessage();
        alert.setContentText(msg.substring(0, 1).toUpperCase() + msg.substring(1));
        alert.showAndWait();
    }

    private void editExisting() {
        var root = jfxHelpers.root(this::mainMenu);
        var rootChildren = root.getChildren();
        rootChildren.add(jfxHelpers.title("Edit articles"));

        var articles = FXCollections.observableList(ffr.getAll());
        var articlesCombo = new ComboBox<>(articles);
        articlesCombo.setConverter(new StringConverter<>() {
            @Override
            public String toString(PartyArticle partyArticle) {
                return partyArticle == null ? "" : partyArticle.getName();
            }

            @Override
            public PartyArticle fromString(String s) {
                return null;
            }
        });
        rootChildren.add(articlesCombo);

        var actionBtns = new LinkedList<Button>();

        HBox articleStateCont = new HBox();
        Label articleStateLabel = new Label("Current state: ");
        articleStateCont.getChildren().add(articleStateLabel);
        Label articleStateValueLabel = new Label("unknown");
        articleStateValueLabel.setStyle("-fx-font-weight: bold");
        articleStateCont.getChildren().add(articleStateValueLabel);
        Runnable updateArticleStateLabel = () -> {
            var article = articlesCombo.getValue();
            String newText = article == null ? "none selected" : article.getStateName();
            actionBtns.forEach(button -> button.setDisable(article == null));
            articleStateValueLabel.setText(newText);
        };
        articlesCombo.valueProperty().addListener((value, oldVal, newVal) -> updateArticleStateLabel.run());
        rootChildren.add(articleStateCont);

        HBox actionsCont = new HBox();
        actionsCont.setSpacing(5);
        actionBtns.add(jfxHelpers.button("Remove", actionEvent -> {
            var article = articlesCombo.getValue();
            articles.remove(article);
            ffr.remove(article);
            updateArticleStateLabel.run();
        }));
        actionBtns.add(jfxHelpers.button("Delete", actionEvent -> {
            var article = articlesCombo.getValue();
            try {
                article.delete();
            } catch (IllegalPaState ex) {
                illegalPaStateExceptionHandler(ex);
            }
            updateArticleStateLabel.run();
        }));
        actionBtns.add(jfxHelpers.button("Lend", actionEvent -> {
            var article = articlesCombo.getValue();
            try {
                double price = article.lend();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Product price");
                alert.setHeaderText("Price to lend product");
                alert.setContentText(String.format("Price: €%f", price));
                alert.showAndWait();
            } catch (IllegalPaState ex) {
                illegalPaStateExceptionHandler(ex);
            }
            updateArticleStateLabel.run();
        }));
        actionBtns.add(jfxHelpers.button("Return", actionEvent -> {
            var article = articlesCombo.getValue();
            try {
                article.bringBack(false);
            } catch (IllegalPaState ex) {
                illegalPaStateExceptionHandler(ex);
            }
            updateArticleStateLabel.run();
        }));
        actionBtns.add(jfxHelpers.button("Return damaged", actionEvent -> {
            var article = articlesCombo.getValue();
            try {
                double damageCompensationPrice = article.bringBack(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Damage compensation price");
                alert.setHeaderText("Compensation price for damaged product");
                alert.setContentText(String.format("Price: €%f", damageCompensationPrice));
                alert.showAndWait();
            } catch (IllegalPaState ex) {
                illegalPaStateExceptionHandler(ex);
            }
            updateArticleStateLabel.run();
        }));
        actionBtns.add(jfxHelpers.button("Repair", actionEvent -> {
            var article = articlesCombo.getValue();
            try {
                article.repair();
            } catch (IllegalPaState ex) {
                illegalPaStateExceptionHandler(ex);
            }
            updateArticleStateLabel.run();
        }));
        actionsCont.getChildren().addAll(actionBtns);
        rootChildren.add(actionsCont);

        updateArticleStateLabel.run();

        rootChildren.add(jfxHelpers.button("Back", actionEvent -> this.mainMenu()));

        this.showRegion(root);
    }

    private void showRegion(Region parent) {
        jfxHelpers.showRegion(this.stage, parent);
    }
}
