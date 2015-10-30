package br.com.viewfx;

import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import org.tbee.javafx.scene.layout.MigPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainScreen {
    
    static Stage window;
    static Scene scene;

    public void mainScreen(Boolean bool){
        window = new Stage();
        window.setTitle("GARAGEM DAS NOIVAS");
        window.setWidth(1024);
        window.setHeight(800);
    
        MigPane layout = new MigPane("ins 0, gap 0"); 

        layout.add(tp.topPane(bool),"cell 0 0, wrap, pushx, growx, h 100!");
        layout.add(lp.leftPane(),"cell 0 1, pushy, growy, w 240!, hidemode 3");
        layout.add(mp.mainPane(),"cell 0 1, push, grow, gap 0"); 
        layout.getStylesheets().add("/br/com/viewfx/style.css");

        scene = new Scene(layout); 
        
        //window.setFullScreen(true);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        window.setScene(scene);
        window.show();
    }

    // Instancias //    
    TopPane tp = new TopPane();
    LeftPane lp = new LeftPane();
    MainPane mp = new MainPane();
    
    private ToggleButton toggleButton;
    
    private Image img;
    private Image img2;
    private ImageView imgView;
}
