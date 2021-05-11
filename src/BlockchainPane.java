import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BlockchainPane extends StackPane{

    public BlockchainPane(){
        Button connect = new Button("Connect");
        Button disConnect = new Button("Disconnect");
        Button block1Valid = new Button("Is Block Valid?");
        Button block2Valid = new Button("Is Block Valid?");
        Button block3Valid = new Button("Is Block Valid?");
        Button block4Valid = new Button("Is Block Valid?");
        Button chainValid = new Button("Is Blockchain valid?");


        TextArea block1Data = new TextArea("");
        block1Data.setEditable(false);
        TextArea block2Data = new TextArea("");
        block2Data.setEditable(false);
        TextArea block3Data = new TextArea("");
        block3Data.setEditable(false);
        TextArea block4Data = new TextArea("");
        block4Data.setEditable(false);


        Label clients = new Label("Clients: ");
        Label numClients = new Label("");
        Label isChainValid = new Label("");
        Label timeStamp = new Label("TimeStamp: ");
        Label hash = new Label("Hash: ");
        Label prevHash = new Label("Prev Hash: ");
        Label nonce = new Label("Nonce: ");
        Label records = new Label("Trades: ");
        records.setPadding(new Insets(15, 10, 0, 10));
        Label block1Label = new Label("BLOCK 1 ");
        Label block2Label = new Label("BLOCK 2 ");
        Label block3Label = new Label("BLOCK 3 ");
        Label block4Label = new Label("BLOCK 4");

        //Add nodes to pane
        VBox sideBar = new VBox();
        sideBar.setPadding(new Insets(50, 10, 10, 30));
        sideBar.getChildren().addAll(connect, disConnect, chainValid, isChainValid, clients, numClients);

        VBox blockBox1 = new VBox();
        blockBox1.getChildren().addAll(timeStamp, hash, prevHash, nonce, block1Data, block1Valid);

        VBox blockBox2 = new VBox();
        blockBox2.getChildren().addAll(timeStamp, hash, prevHash, nonce, block1Data, block1Valid);

        VBox blockBox3 = new VBox();
        blockBox3.getChildren().addAll(timeStamp, hash, prevHash, nonce, block1Data, block1Valid);

        VBox blockBox4 = new VBox();
        blockBox4.getChildren().addAll(timeStamp, hash, prevHash, nonce, block1Data, block1Valid);


        VBox leftBlocks = new VBox();
        leftBlocks.setPadding(new Insets(10, 10, 10, 30));
        leftBlocks.getChildren().addAll(blockBox1, blockBox3);

        VBox rightBlocks = new VBox();
        rightBlocks.setPadding(new Insets(10, 10, 5, 30));
        rightBlocks.getChildren().addAll(blockBox2, blockBox4);


        HBox design = new HBox();
        design.getChildren().addAll(sideBar, leftBlocks, rightBlocks);

        BorderPane body = new BorderPane();
        body.setCenter(design);

        //Set the root node of the Scene
        getChildren().clear();
        getChildren().addAll(body);
    }

}
