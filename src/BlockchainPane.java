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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class BlockchainPane extends StackPane{

    public BlockchainPane(){
        Button connect = new Button("Connect");
        connect.setMinWidth(120);
        Button disConnect = new Button("Disconnect");
        disConnect.setMinWidth(120);
        Button block1Valid = new Button("Is Block Valid?");
        Button block2Valid = new Button("Is Block Valid?");
        Button block3Valid = new Button("Is Block Valid?");
        Button block4Valid = new Button("Is Block Valid?");
        Button chainValid = new Button("Is Blockchain valid?");
        chainValid.setMinWidth(120);


        TextArea block1Data = new TextArea("");
        TextArea block2Data = new TextArea("");
        TextArea block3Data = new TextArea("");
        TextArea block4Data = new TextArea("");
        TextArea clientsList = new TextArea("");
        clientsList.setMaxWidth(150);
        clientsList.setMinHeight(250);
        clientsList.setEditable(false);

        Label connectSpace = new Label(" ");
        Label disconnectSpace = new Label(" ");
        Label validSpace = new Label(" ");
        Label clients = new Label("Connected Clients:");
        Label numClients = new Label("");
        Label isChainValid = new Label("");
        Label timeStamp = new Label("TimeStamp: ");
        Label hash = new Label("Hash: ");
        Label prevHash = new Label("Prev Hash: ");
        Label nonce = new Label("Nonce: ");
        Label records = new Label("Trades: ");
        Label timeStamp2 = new Label("TimeStamp: ");
        Label hash2 = new Label("Hash: ");
        Label prevHash2 = new Label("Prev Hash: ");
        Label nonce2 = new Label("Nonce: ");
        Label records2 = new Label("Trades: ");
        Label timeStamp3 = new Label("TimeStamp: ");
        Label hash3 = new Label("Hash: ");
        Label prevHash3 = new Label("Prev Hash: ");
        Label nonce3 = new Label("Nonce: ");
        Label records3 = new Label("Trades: ");
        Label timeStamp4 = new Label("TimeStamp: ");
        Label hash4 = new Label("Hash: ");
        Label prevHash4 = new Label("Prev Hash: ");
        Label nonce4 = new Label("Nonce: ");
        Label records4 = new Label("Trades: ");

        records.setPadding(new Insets(15, 10, 0, 10));
        records2.setPadding(new Insets(15, 10, 0, 10));
        records3.setPadding(new Insets(15, 10, 0, 10));
        records4.setPadding(new Insets(15, 10, 0, 10));

        Label block1Label = new Label("BLOCK 1 ");
        block1Label.setFont(Font.font(null, FontWeight.BOLD, 20));
        block1Label.setPadding(new Insets(30, 0, 20, 0));
        Label block2Label = new Label("BLOCK 2 ");
        block2Label.setFont(Font.font(null, FontWeight.BOLD, 20));
        block2Label.setPadding(new Insets(30, 0, 20, 0));
        Label block3Label = new Label("BLOCK 3 ");
        block3Label.setFont(Font.font(null, FontWeight.BOLD, 20));
        block3Label.setPadding(new Insets(30, 0, 20, 0));
        Label block4Label = new Label("BLOCK 4");
        block4Label.setFont(Font.font(null, FontWeight.BOLD, 20));
        block4Label.setPadding(new Insets(30, 0, 20, 0));

        //Add nodes to pane
        VBox sideBar = new VBox();
        sideBar.setPadding(new Insets(50, 10, 10, 30));
        sideBar.getChildren().addAll(connect, connectSpace, disConnect, disconnectSpace, chainValid, validSpace, isChainValid, clients, numClients, clientsList);

        String css = "-fx-border-color: grey;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n";
        VBox blockBox1 = new VBox();
        blockBox1.setStyle(css);
        blockBox1.setPadding(new Insets(10, 10, 10, 10));
        blockBox1.getChildren().addAll(block1Label, timeStamp, hash, prevHash, nonce, records, block1Data, block1Valid);

        VBox blockBox2 = new VBox();
        blockBox2.setStyle(css);
        blockBox2.setPadding(new Insets(10, 10, 10, 10));
        blockBox2.getChildren().addAll(block2Label, timeStamp2, hash2, prevHash2, nonce2, records2, block2Data, block2Valid);

        VBox blockBox3 = new VBox();
        blockBox3.setStyle(css);
        blockBox3.setPadding(new Insets(10, 10, 10, 10));
        blockBox3.getChildren().addAll(block3Label, timeStamp3, hash3, prevHash3, nonce3, records3, block3Data, block3Valid);

        VBox blockBox4 = new VBox();
        blockBox4.setStyle(css);
        blockBox4.setPadding(new Insets(10, 10, 10, 10));
        blockBox4.getChildren().addAll(block4Label, timeStamp4, hash4, prevHash4, nonce4, records4, block4Data, block4Valid);


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
