package main_pack;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
/**
 * Klasa obslugujaca menu wyboru 2 postaci, pozwala ustawic odpowiednie,
 * wybrane wartosci wszystkich parametrow podczas uruchamiania gry multiplayer, dla drugiego gracza
 */
public class multi_2_Controller implements Initializable {

    public Label hello_user;
    String USER;
    String HERO_1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    /**
     * Metoda ustawiajaca odpowiednia nazwe gracza w menu
     * @param unsername
     */
    public void hello_user(String unsername){
        hello_user.setText("Login as: "+unsername);
        USER = unsername;
    }
    /**
     * Metoda ustawiajaca odpowiedni parametr - wybrana postac przez 1 gracza
     * @param my_hero
     */
    public void player_1_hero(String my_hero){
        HERO_1 = my_hero;
    }
    /**
     * Metoda pozwalajaca wlaczyc menu z ktorego zaczniemy gre singleplayer - tak jak w poprzednim menu
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
     * Metoda pozwalajaca cofnac sie o krok w menu - z powrotem do wyboru 1 postaci
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
     * Metoda pozwalajaca wyswietlic tabele wynikow - tak jak w poprzednim menu
     * @param actionEvent
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
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
    /**
     * Metoda do wylogowywania uzytkownika i przejscia do pierwszego menu
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
     * Metoda ustawiajaca parametry zgodne z wyborami - typ postaci i nazwy gracza, powoluje tez obiekt klasy multi_3_controller - menu zapraszajace do rozpoczecia gry multiplayer
     * @param mouseEvent
     * @throws IOException
     */
    public void JennySelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/multi_3_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_3_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.players_hero(HERO_1, "Jenny");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
    /**
     * Metoda ustawiajaca parametry zgodne z wyborami - typ postaci i nazwy gracza, powoluje tez obiekt klasy multi_3_controller - menu zapraszajace do rozpoczecia gry multiplayer
     * @param mouseEvent
     * @throws IOException
     */
    public void AmySelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/multi_3_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_3_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.players_hero(HERO_1, "Amy");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
    /**
     * Metoda ustawiajaca parametry zgodne z wyborami - typ postaci i nazwy gracza, powoluje tez obiekt klasy multi_3_controller - menu zapraszajace do rozpoczecia gry multiplayer
     * @param mouseEvent
     * @throws IOException
     */
    public void JonnySelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/multi_3_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_3_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.players_hero(HERO_1, "Jonny");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
    /**
     * Metoda ustawiajaca parametry zgodne z wyborami - typ postaci i nazwy gracza, powoluje tez obiekt klasy multi_3_controller - menu zapraszajace do rozpoczecia gry multiplayer
     * @param mouseEvent
     * @throws IOException
     */
    public void BobSelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/multi_3_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_3_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.players_hero(HERO_1, "Bob");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
    /**
     * Metoda ustawiajaca parametry zgodne z wyborami - typ postaci i nazwy gracza, powoluje tez obiekt klasy multi_3_controller - menu zapraszajace do rozpoczecia gry multiplayer
     * @param mouseEvent
     * @throws IOException
     */
    public void ZuluSelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/multi_3_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_3_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.players_hero(HERO_1, "Zulu");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
    /**
     * Metoda ustawiajaca parametry zgodne z wyborami - typ postaci i nazwy gracza, powoluje tez obiekt klasy multi_3_controller - menu zapraszajace do rozpoczecia gry multiplayer
     * @param mouseEvent
     * @throws IOException
     */
    public void FredSelected(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/multi_3_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_3_Controller multi = loader.getController();
        multi.hello_user(USER);
        multi.players_hero(HERO_1, "Fred");

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }
}
