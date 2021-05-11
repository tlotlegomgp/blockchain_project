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
        Scene scene = new Scene(layout, 1550, 900);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        // write your code here
        Blockchain blockChain = new Blockchain(3);

        blockChain.addBlock(blockChain.newBlock(new String[]{"Apple = $120.000", "Google - $140,000"}));
        blockChain.addBlock(blockChain.newBlock(new String[]{"Amazon = $120.000", "Facebook - $140,000"}));
        blockChain.addBlock(blockChain.newBlock(new String[]{"Netflix = $120.000", "Microsoft - $140,000"}));

        System.out.println("Is Blockchain valid?: " + blockChain.isBlockChainValid());

        System.out.println(blockChain);

        launch(args);


    }
}