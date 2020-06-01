package yazlab6;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NodeFinishImage extends Cell{
    
    public NodeFinishImage(String id) {
        super(id);

        Image image = new Image("3.png");
        Label aa = new Label(id);
        ImageView view = new ImageView();
        view.setImage(image);
        view.setFitWidth(410);
        view.setFitHeight(235);
        aa.setGraphic(view);
        setView(aa);
    }  
}
