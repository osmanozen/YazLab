package yazlab6;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NodeMidImage extends Cell{
    
    public NodeMidImage(String id) {
        super(id);

        Image image = new Image("2.png");
        Label aa = new Label(id);
        ImageView view = new ImageView();
        view.setImage(image);
        view.setFitWidth(64);
        view.setFitHeight(64);
        aa.setGraphic(view);
        setView(aa);
    }  
}
