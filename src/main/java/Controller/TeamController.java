/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Team;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author danida
 */
public class TeamController implements Initializable {

    private ObservableList<Team> teams = FXCollections.observableArrayList();

    @FXML
    private TableView<Team> teamTable;
    @FXML
    private TableColumn<Team, String> name;

    @FXML
    private WebView picture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(celldata -> 
             celldata.getValue().getNameSingleStringProp()
        );
        picture.getEngine().load("https://upload.wikimedia.org/wikipedia/en/5/53/FC_Cologne_logo.svg");
    }

}
