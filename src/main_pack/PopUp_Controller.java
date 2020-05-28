package main_pack;

import database.DbConnector;
import game.PlatformGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Klasa obslugujace menu konca gry - powrot do menu, zapisz wynik, sprobuj jeszcze raz
 */
public class PopUp_Controller implements Initializable {
    public Label hello_user;
    public Label user_score;
    String USER;
    String HERO;
    int SCORE;
    Stage game_stage;
    PlatformGame moja_gra;

    /**
     * Metoda ustawiajaca parametr gry
     * @param game
     */
    public void myPlatformGame(PlatformGame game){
        moja_gra = game;
    }
    /**
     * Metoda ustawiajaca parametr bohatera
     *
     */
    public void set_hero(String herosik){
        HERO = herosik;
    }

    /**
     * Metoda ustawiajaca parametr sceny
     * @param stage
     */
    public void set_stage(Stage stage){
        game_stage = stage;
    }

    /**
     * Metoda ustawiajaca parametr nazwy gracza i wynik
     * @param user
     * @param wynik
     */
    public void user_and_score(String user , int wynik){
        hello_user.setText(user);
        user_score.setText(String.valueOf(wynik));
        USER = user;
        SCORE = wynik;
    }

    /**
     * Metoda zapisujaca wynik w bazie danych - laczy sie przez DbConnector, nastepnie cofa do menu glownego
     * @param actionEvent
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public void save_score(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        DbConnector db = new DbConnector();
        db.add_score(USER,SCORE);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/menu_layout.fxml"));
        Parent nextRoot = loader.load();
        menu_Controller menu = loader.getController();
        menu.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();

    }

    /**
     * Metoda cofajaca do menu glownego
     * @param actionEvent
     * @throws IOException
     */
    public void go_to_menu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/menu_layout.fxml"));
        Parent nextRoot = loader.load();
        menu_Controller menu = loader.getController();
        menu.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    /**
     * Metoda ktora zaczyna rozgrywke singleplayer jeszcze raz
     * @param actionEvent
     * @throws Exception
     */
    public void try_again(ActionEvent actionEvent) throws Exception {
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        PlatformGame platformGame = new PlatformGame();
        platformGame.setUser(USER);
        platformGame.setHero(HERO);
        platformGame.getStage(window);
        platformGame.start(window);

        /*Stage window2 = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window2.close();*/

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
