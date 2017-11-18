/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author danida
 */
public class BetController implements Initializable {

    @FXML
    private Button bet;
    @FXML
    private ChoiceBox<?> bet_type;
    @FXML
    private Button home_team_info;
    @FXML
    private Button away_team_info;
    @FXML
    private TextField odds;
    @FXML
    private CheckBox win;
    @FXML
    private Button home_team_select;
    @FXML
    private Button away_team_select;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
