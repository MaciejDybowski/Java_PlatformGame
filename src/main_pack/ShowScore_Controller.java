package main_pack;

import database.DbConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Klasa obslugujace wyswietlanie menu z tabela wynikow graczy
 */
public class ShowScore_Controller {
    public Label hello_user;
    public Label table_score;
    public String USER;
    public String TOP_10;

    /**
     * Metoda do wyswietlania nazwy zalogowanego uzytkownika
     * @param unsername
     */
    public void hello_user(String unsername){
        hello_user.setText("Login as: "+unsername);
        USER = unsername;
    }

    /**
     * Metoda do wyswietlania 10 najlepszych wynikow graczy
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void set_10_top_players() throws SQLException, ClassNotFoundException {
        DbConnector db = new DbConnector();
        TOP_10 = db.get_top_10();
        table_score.setText(TOP_10);
    }
    /**
     * Metoda powolujaca menu gry multiplayer
     * @param actionEvent
     * @throws IOException
     */
    public void multi(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/multi_1_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_1_Controller multi = loader.getController();
        multi.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    /**
     * Pusta metoda - juz jestesmy w menu wyswietlania najlepszych wynikow
     * @param actionEvent
     */
    public void show_score(ActionEvent actionEvent) {
    }

    public void show_hero(ActionEvent actionEvent) {
    }
    /**
     * Metoda powolujaca okno gry singleplayer
     * @param actionEvent
     * @throws IOException
     */
    public void go_single(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/single_layout.fxml"));
        Parent nextRoot = loader.load();
        single_Controller single_controller = loader.getController();
        single_controller.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
}
