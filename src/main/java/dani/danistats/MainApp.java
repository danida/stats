package dani.danistats;

import Model.Match;
import dao.MatchDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


public class MainApp  {

  /*  @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
       
       
        
        
    }
 */
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Match match1 = new Match("Chelsea", "ASD", true, 2.2, new Date(2017,07,11,20,0,0));
        Match match2 = new Match("Chelsea", "Manu", true, 2.2, new Date(2017,07,11,20,0,0));
        MatchDao dao = new MatchDao();
        dao.insert(match1);
        dao.insert(match2);    }

}
