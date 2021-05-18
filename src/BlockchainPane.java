import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.StringTokenizer;


public class BlockchainPane extends StackPane{
    private static boolean isBlockchainValid = true;

    public BlockchainPane(){
        Button connect = new Button("Connect");
        connect.setMinWidth(120);
        Button validate = new Button("Validate Blocks");
        validate.setMinWidth(120);
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
        TextArea clientsList = new TextArea("MGP-22343");
        clientsList.setMaxWidth(150);
        clientsList.setMinHeight(250);
        clientsList.setEditable(false);

        Label connectSpace = new Label(" ");
        Label disconnectSpace = new Label(" ");
        Label validSpace = new Label(" ");
        Label clients = new Label("Connected Clients:");
        Label numClients = new Label("");
        Label isChainValid = new Label("");
        Label block1Info = new Label("");
        Label block2Info = new Label("");
        Label block3Info = new Label("");
        Label block4Info = new Label("");

        block1Info.setPadding(new Insets(0, 10, 15, 10));
        block2Info.setPadding(new Insets(0, 10, 15, 10));
        block3Info.setPadding(new Insets(0, 10, 15, 10));
        block4Info.setPadding(new Insets(0, 10, 15, 10));

        Label block1Label = new Label("BLOCK 1 ");
        block1Label.setFont(Font.font(null, FontWeight.BOLD, 20));
        block1Label.setPadding(new Insets(10, 0, 10, 0));
        Label block2Label = new Label("BLOCK 2 ");
        block2Label.setFont(Font.font(null, FontWeight.BOLD, 20));
        block2Label.setPadding(new Insets(10, 0, 10, 0));
        Label block3Label = new Label("BLOCK 3 ");
        block3Label.setFont(Font.font(null, FontWeight.BOLD, 20));
        block3Label.setPadding(new Insets(10, 0, 10, 0));
        Label block4Label = new Label("BLOCK 4");
        block4Label.setFont(Font.font(null, FontWeight.BOLD, 20));
        block4Label.setPadding(new Insets(10, 0, 10, 0));

        //Add nodes to pane
        VBox sideBar = new VBox();
        sideBar.setPadding(new Insets(50, 10, 10, 30));
        sideBar.getChildren().addAll(connect, connectSpace, validate, disconnectSpace, chainValid, validSpace, isChainValid, clients, numClients, clientsList);

        String css = "-fx-border-color: grey;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n";
        VBox blockBox1 = new VBox();
        blockBox1.setStyle(css);
        blockBox1.setPadding(new Insets(10, 10, 10, 10));
        blockBox1.getChildren().addAll(block1Label, block1Info, block1Data, block1Valid);

        VBox blockBox2 = new VBox();
        blockBox2.setStyle(css);
        blockBox2.setPadding(new Insets(10, 10, 10, 10));
        blockBox2.getChildren().addAll(block2Label, block2Info, block2Data, block2Valid);

        VBox blockBox3 = new VBox();
        blockBox3.setStyle(css);
        blockBox3.setPadding(new Insets(10, 10, 10, 10));
        blockBox3.getChildren().addAll(block3Label, block3Info, block3Data, block3Valid);

        VBox blockBox4 = new VBox();
        blockBox4.setStyle(css);
        blockBox4.setPadding(new Insets(10, 10, 10, 10));
        blockBox4.getChildren().addAll(block4Label, block4Info, block4Data, block4Valid);


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

        //Button actions
        connect.setOnAction((ActionEvent e) -> {

        });

        String blocksDataInfo = Client.processData("B-5");
        System.out.println(blocksDataInfo);
        StringTokenizer blocksTokens = new StringTokenizer(blocksDataInfo, "@");
        System.out.println(blocksTokens.countTokens());
        block1Info.setText(blocksTokens.nextToken());
        block1Data.appendText(blocksTokens.nextToken());
        block2Info.setText(blocksTokens.nextToken());
        block2Data.appendText(blocksTokens.nextToken());
        block3Info.setText(blocksTokens.nextToken());
        block3Data.appendText(blocksTokens.nextToken());
        block4Info.setText(blocksTokens.nextToken());
        block4Data.appendText(blocksTokens.nextToken());

        validate.setOnAction((ActionEvent e) -> {
            String result = Client.processData("B-6");
        });

        chainValid.setOnAction((ActionEvent e) -> {
            String result = Client.processData("B-0");
            if (isBlockchainValid == false)
                isChainValid.setText("false");
            else
                isChainValid.setText(result);
        });

        block1Valid.setOnAction((ActionEvent e) -> {
            String result = Client.processData("B-1");
            String result2 = Client.processData(block1Data.getText());
            if (result.trim().equals("true") && result2.trim().equals("true")){
                isBlockchainValid = true;
                blockBox1.setBackground(new Background(new BackgroundFill(Color.rgb(174, 217, 167), CornerRadii.EMPTY, Insets.EMPTY)));

            }
            else{
                blockBox1.setBackground(new Background(new BackgroundFill(Color.rgb(254, 132, 132), CornerRadii.EMPTY, Insets.EMPTY)));
                isBlockchainValid = false;
            }

        });

        block2Valid.setOnAction((ActionEvent e) -> {
            String result = Client.processData("B-2");
            String result2 = Client.processData(block2Data.getText());
            if (result.trim().equals("true") && result2.trim().equals("true")){
                blockBox2.setBackground(new Background(new BackgroundFill(Color.rgb(174, 217, 167), CornerRadii.EMPTY, Insets.EMPTY)));
                isBlockchainValid =  true;
            }
            else{
                blockBox2.setBackground(new Background(new BackgroundFill(Color.rgb(254, 132, 132), CornerRadii.EMPTY, Insets.EMPTY)));
                isBlockchainValid = false;
            }
        });

        block3Valid.setOnAction((ActionEvent e) -> {
            String result = Client.processData("B-3");
            String result2 = Client.processData(block3Data.getText());
            if (result.trim().equals("true") && result2.trim().equals("true")){
                isBlockchainValid = true;
                blockBox3.setBackground(new Background(new BackgroundFill(Color.rgb(174, 217, 167), CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else{
                blockBox3.setBackground(new Background(new BackgroundFill(Color.rgb(254, 132, 132), CornerRadii.EMPTY, Insets.EMPTY)));
                isBlockchainValid = false;
            }
        });

        block4Valid.setOnAction((ActionEvent e) -> {
            String result = Client.processData("B-4");
            String result2 = Client.processData(block4Data.getText());
            if (result.trim().equals("true") && result2.trim().equals("true")){
                isBlockchainValid = true;
                blockBox4.setBackground(new Background(new BackgroundFill(Color.rgb(174, 217, 167), CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else{
                blockBox4.setBackground(new Background(new BackgroundFill(Color.rgb(254, 132, 132), CornerRadii.EMPTY, Insets.EMPTY)));
                isBlockchainValid = false;
            }
        });

        //Set the root node of the Scene
        getChildren().clear();
        getChildren().addAll(body);
    }

}
