package yazlab6;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class YazLab6 extends Application {
    
    Graph graphx = new Graph();
    
    int nodeSize=0, maxFlow=0;
    int[][] graph;
    Scene scene;
    BorderPane background;
    TilePane navigation;
    ChoiceBox cb1,cb2;
    Button cb4 = new Button(">>");
    Button createGraph = new Button("CREATE GRAPH");;
    Button viewGraph = new Button("VIEW GRAPH");
    TextField cb3, nodeCount, nodeStart, nodeFinish;
    
    @Override
    public void start(Stage stage) {
       
        background = new BorderPane();
        scene = new Scene(background, 850, 600);
        
        navigation = new TilePane();
        navigation.setPrefColumns(2);
        navigation.setPrefWidth(250);
        navigation.setPadding(new Insets(5));
        navigation.setVgap(5.0);
        navigation.setBackground(new Background(new BackgroundFill(Color.web("#fff"), CornerRadii.EMPTY, Insets.EMPTY)));

        nodeCount = new TextField();
        nodeCount.setPrefWidth(120);
        nodeStart = new TextField();
        nodeStart.setPrefWidth(120);
        nodeFinish = new TextField();
        nodeFinish.setPrefWidth(120);
        createGraph.setPrefWidth(120);
        navigation.getChildren().addAll(new Label("Node Size:"),nodeCount, 
                    new Label("Start Node:"),nodeStart,
                    new Label("Finish Node:"),nodeFinish,
                    new Text(""),createGraph,
                    new Separator(),new Separator());
        
        createGraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                nodeSize = Integer.parseInt(nodeCount.getText());
                graph = new int[nodeSize+1][nodeSize+1];
                
                ArrayList<Integer> choice = new ArrayList();
                for(int i=1; i<nodeSize+1;i++){
                    choice.add(i);
                }
                
                cb1 = new ChoiceBox(FXCollections.observableArrayList(choice));
                cb2 = new ChoiceBox(FXCollections.observableArrayList(choice));
                cb3 = new TextField();
                cb3.setMaxWidth(50);
                
                HBox hbox = new HBox(cb1, cb2);
                hbox.setSpacing(20);
                
                HBox hbox2 = new HBox(cb3, cb4);
                hbox2.setSpacing(20);
                
                viewGraph.setPrefWidth(120);
                navigation.getChildren().addAll(hbox,hbox2,
                                                new Label(),viewGraph);
            }
        });
        
        cb4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                graph[(int) cb1.getValue()][(int) cb2.getValue()]=Integer.parseInt(cb3.getText());
                for (int i = 0; i < nodeSize+1; i++) {
                    for (int j = 0; j < nodeSize+1; j++) {
                        System.out.print(graph[i][j]+" ");
                    }
                    System.out.println("");
                }
            }
        });
        
        viewGraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                graphx = new Graph();
                background.setCenter(graphx.getScrollPane());
                addGraphComponents();
                MaxFlowMinCut maxFlowMinCut = new MaxFlowMinCut(nodeSize);
                maxFlow = maxFlowMinCut.maxFlowMinCut(graph, Integer.parseInt(nodeStart.getText()), Integer.parseInt(nodeFinish.getText()));
                navigation.getChildren().addAll(new Separator(), new Separator(),
                                                new Label("Max Flow:"),new Label(Integer.toString(maxFlow)),
                                                new Label("Min Cut:"),new Label(maxFlowMinCut.printCutSet()));
                Layout layout = new RandomLayout(graphx);
                layout.execute();
            }
        });

        background.setLeft(navigation);
        stage.setScene(scene);
        stage.show();
    }

    private void addGraphComponents() {

        Model model = graphx.getModel();
        graphx.beginUpdate();
        
        for (int i = 1; i < nodeSize+1; i++) {
            
            if(i==Integer.parseInt(nodeStart.getText())){
                
                model.addCell(Integer.toString(i), CellType.NODE_START);
            }else if(i==Integer.parseInt(nodeFinish.getText())){
                
                model.addCell(Integer.toString(i), CellType.NODE_FINISH);
            }else{
                model.addCell(Integer.toString(i), CellType.NODE_MID);
            }
        }
        
        for (int i = 0; i < nodeSize+1; i++) {
            for (int j = 0; j < nodeSize+1; j++) {
                if(graph[i][j]!=0){
                    model.addEdge(Integer.toString(i), Integer.toString(j));
                }
            }
        }
        graphx.endUpdate();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
