package yazlab6;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class Graph {

    private Model model;
    private Group canvas;
    private ZoomableScrollPane scrollPane;
    MouseGestures mouseGestures;
    CellLayer cellLayer;
    
    public Graph(){

        this.model = new Model();
        canvas = new Group();
        cellLayer = new CellLayer();
        canvas.getChildren().add(cellLayer);
        mouseGestures = new MouseGestures(this);
        scrollPane = new ZoomableScrollPane(canvas);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
    }

    public ScrollPane getScrollPane(){
        
        return this.scrollPane;
    }

    public Pane getCellLayer(){
        
        return this.cellLayer;
    }

    public Model getModel() {
        
        return model;
    }

    public void beginUpdate(){}

    public void endUpdate(){

        getCellLayer().getChildren().addAll(model.getAddedEdges());
        getCellLayer().getChildren().addAll(model.getAddedCells());
        getCellLayer().getChildren().removeAll(model.getRemovedCells());
        getCellLayer().getChildren().removeAll(model.getRemovedEdges());

        for (Cell cell : model.getAddedCells()) {
            mouseGestures.makeDraggable(cell);
        }

        getModel().attachOrphansToGraphParent(model.getAddedCells());
        getModel().disconnectFromGraphParent(model.getRemovedCells());
        getModel().merge();
    }

    public double getScale() {
        return this.scrollPane.getScaleValue();
    }
}