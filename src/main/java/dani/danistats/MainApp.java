package dani.danistats;

import Model.Match;
import Model.Team;
import dao.FootballTeamDao;
import dao.MatchDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class MainApp extends Application {

      @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Team.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
       
       
        
        
    }
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*   FootballTeamDao teamdao = new FootballTeamDao();
        Team t1 = teamdao.findTeamByName("Chelsea");
        Team t2 = teamdao.findTeamByName("Manchester United");
        Match match1 = new Match(t1, t2, true, 2.2, new Date(2017, 07, 11, 20, 0, 0));
        MatchDao dao = new MatchDao();
        dao.insert(match1);
       ˛*/ 
        launch(args);
    }

}
