package main_pack;

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
 * Klasa odpowiadajaca za menu po zalogowaniu
 */
public class menu_Controller implements Initializable {
    public Label hello_user;
    public String USER;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Metoda do wyswietlania nazwy zalogowanego uzytkownika
     * @param unsername
     */
    public void hello_user(String unsername){
        hello_user.setText("Login as: "+unsername);
        USER = unsername;
    }

    /**
     * Metoda cofajaca menu jedno wstecz - wylogowanie
     * @param actionEvent
     * @throws IOException
     */
    public void logout(ActionEvent actionEvent) throws IOException {
        USER = null;
        Parent nextRoot = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    /**
     * Metoda powolujaca menu gry singleplayer
     * @param actionEvent
     * @throws IOException
     */
    public void single(ActionEvent actionEvent) throws IOException {
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
     * Metoda powolujaca okno tabeli wynikow
     * @param actionEvent
     * @throws IOException
     */
    public void show_score(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/ShowScore_layout.fxml"));
        Parent nextRoot = loader.load();
        ShowScore_Controller temp = loader.getController();
        temp.hello_user(USER);
        temp.set_10_top_players();
        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    /**
     * Metoda powolujaca okno z prezentacja postaci
     * @param actionEvent
     */
    public void show_hero(ActionEvent actionEvent) {
    }
}
