import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    ArrayList<Block> blockchain = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Present scene to stage
        primaryStage.setTitle("MGP-Blockchain");
        BlockchainPane layout = new BlockchainPane();
        Scene scene = new Scene(layout, 1300, 850);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        // write your code here


        launch(args);


    }
}