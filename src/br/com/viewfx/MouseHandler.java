package br.com.viewfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseHandler implements EventHandler<MouseEvent>{

//    // Não esta funcionando :P //
//    @Override
//    public void handle(ActionEvent event) {
//        TopPane top = new TopPane();
//        if(event.getSource() == top.getTglSearch()){
//            if(top.getTglSearch().isVisible()) top.getTglSearch().setVisible(false);
//            else top.getTglSearch().setVisible(true);
//        }
//    }
    
    private final int index;

    public MouseHandler(int index) {
        this.index = index;
    }

    @Override
    public void handle(MouseEvent event) {
        if(index == 1)
        System.out.println("l"+index);
    }
}

