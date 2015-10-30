package br.com.viewfx;

import br.com.control.SelectControl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import org.tbee.javafx.scene.layout.MigPane;

public class TopPane implements EventHandler<ActionEvent>{
   MigPane topPane = new MigPane("ins 6", "[] [] [grow, center] [] [] [] [] []");
    public MigPane topPane(Boolean bool){
        
        StackPane stack = new StackPane();

        topPane.add(programImage = new ImageView(), "span 2 3, align center");
        if(bool){
            ToggleButton tglTest = new ToggleButton();
            stack.getChildren().add(tglTest);
            tglTest.setId("tglTest");
            stack.getChildren().add(tfdSearch = new TextField());
            tfdSearch.setVisible(false);
            tfdSearch.setFocusTraversable(false);
            tfdSearch.setPromptText("Pesquisar");
            tfdSearch.promptTextProperty();
            tfdSearch.setId("tfdSearch"); 
            stack.getChildren().add(cbSearch = new ChoiceBox());
            cbSearch.setVisible(false);
            cbSearch.getItems().addAll("CLIENTE", "FUNCIONÁRIO");
            cbSearch.getSelectionModel().selectFirst();
            cbSearch.setStyle("-fx-text-fill: white;");
            topPane.add(stack);
            topPane.add(tglSearch = new ToggleButton());
            tglSearch.setId("tglSearch");
            tglSearch.setOnAction(this);
            cbSearch.setId("cbSearch");
            stack.setAlignment(tfdSearch, Pos.CENTER);
            stack.setAlignment(cbSearch, Pos.CENTER_RIGHT);
            
            tfdSearch.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    switch(cbSearch.getSelectionModel().getSelectedIndex()){
                        case 0: // Cliente
                            if(tfdSearch.getText().equals("")){
                                SearchPane.getClientScrollPane().setContent(null);
                                MainPane.getMainPane().remove(SearchPane.getClientScrollPane());
                                
                                MainPane.getMainPane().add(sp.selectClient(), "cell 1 0, hidemode 3, grow, push");
                            }else{
                                System.out.println("entrou2");
                                SearchPane.getClientScrollPane().setContent(null);
                                MainPane.getMainPane().remove(SearchPane.getClientScrollPane());
                                
                                MainPane.getMainPane().add(sp.selectClientCom(), "cell 1 0, hidemode 3, grow, push");
                            }
                                dp.getInsertDressPane().setVisible(false);
                                cp.getClientPane().setVisible(false);
                                ep.getEmployeePane().setVisible(false);
                                dp.getScrollPane().setVisible(false);
                                SearchPane.getClientScrollPane().setVisible(true);
                                SearchPane.getClientScrollPane2().setVisible(false);
                            break;                           
                        case 1: // Funcionario
                            SearchPane.getClientScrollPane2().setContent(null);
                            MainPane.getMainPane().remove(SearchPane.getClientScrollPane2());
                            MainPane.getMainPane().add(sp.selectEmployee(), "cell 1 0, hidemode 3, grow, push");
                            
                            dp.getInsertDressPane().setVisible(false);
                            cp.getClientPane().setVisible(false);
                            ep.getEmployeePane().setVisible(false);
                            dp.getScrollPane().setVisible(false);
                            SearchPane.getClientScrollPane2().setVisible(true);
                            SearchPane.getClientScrollPane().setVisible(false);
                            
                            break;
                    }
                
                }
            }
        });            
            
        }
        
        topPane.add(tglStore = new ToggleButton(),"cell 5 0");
        
        if(bool){
            topPane.add(tglShow = new ToggleButton());
            tglShow.setId("tglShow"); 
            tglShow.setOnAction(this);
        }
        
        topPane.add(tglNotification = new ToggleButton());
        topPane.add(tglImg = new ToggleButton());
        programImage.setImage(new Image("/br/com/image/garagemDasNoivas.png", 160, 85, false, true));
        tglNotification.setGraphic( new ImageView( new Image("/br/com/image/notification.png")));
        topPane.setId("topPanel");
        programImage.setId("programImage"); 
        tglStore.setId("tglStore");
        tglImg.setId("tglImg"); 
        tglImg.setGraphic( new ImageView( new Image("File:"+SelectControl.getUserFoto(), 48, 48, false, false)));
        tglImg.setText(SelectControl.getUserName());
        tglImg.setOnAction(this);
        eventHandler();
        
        return topPane;
    }
    
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == tglSearch){
            if(tfdSearch.isVisible()){
                tfdSearch.setVisible(false);
                cbSearch.setVisible(false);
            } else {
                tfdSearch.setVisible(true);
                cbSearch.setVisible(true);
            }
        }
        
        if(event.getSource() == tglShow){
            if(lp.getLeftPanel().isVisible()) lp.getLeftPanel().setVisible(false);
            else lp.getLeftPanel().setVisible(true);
        }
        
        if(event.getSource() == tglImg){
            LoginPane.setLogin();
            LoginPane.setSenha();
            
            MainScreen.window.close();
            LoginPane.window.show();
        }
    }
    
    private void eventHandler(){
        tglStore.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DressPane.getScrollPane().setContent(null);
                MainPane.getMainPane().remove(DressPane.getScrollPane());
                MainPane.getMainPane().add(dp.selectDressPane(), "cell 1 0, hidemode 3, grow, push");
                
                if(dp.getScrollPane().isVisible()){
                    dp.getInsertDressPane().setVisible(false);
                    cp.getClientPane().setVisible(false);
                    ep.getEmployeePane().setVisible(false);
                    dp.getScrollPane().setVisible(true);
                    dp.getBuyPane().setVisible(false);
                    SearchPane.getClientScrollPane().setVisible(false);
                }
            }
        });
    }

    public static ToggleButton getTglSearch() {
        return tglSearch;
    }

    public static String getTfdSearch() {
        return tfdSearch.getText();
    }
    
    // Instancia //
    //MouseHandler mh = new MouseHandler();
    Setting s = new Setting();
    LeftPane lp = new LeftPane();
    SearchPane sp = new SearchPane();
    ClientPane cp = new ClientPane();
    EmployeePane ep = new EmployeePane();
    DressPane dp = new DressPane();
    SelectControl sc = new SelectControl();
    
    // Declaração //
    private ImageView programImage;

    private static TextField tfdSearch;
    
    private static ToggleButton tglNotification;
    private static ToggleButton tglStore;
    private static ToggleButton tglSearch;
    private ChoiceBox cbSearch;
    private ToggleButton tglShow;
    private ToggleButton tglImg;



}
