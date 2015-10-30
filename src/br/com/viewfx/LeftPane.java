package br.com.viewfx;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.tbee.javafx.scene.layout.MigPane;

public class LeftPane {

    public MigPane leftPane(){
        leftPane.add(txtInsert = new Label("INSERIR"),"gapx 10");
        leftPane.add(txtDress1 = new Label("Vestido"),"growx, pushx, gapx 10");
        leftPane.add(txtClient = new Label("Cliente"),"growx, pushx, gapx 10");
        leftPane.add(txtEmployee = new Label("Funcionario"),"growx, pushx, gapx 10");
        //leftPane.add(txtFinancial = new Label("FINANCEIRO"),"gapx 10");
        //leftPane.add(txtDress2 = new Label("Vestido"),"growx, pushx, gapx 10");
        
        leftPane.setId("leftPanel");
        txtDress1.setId("txtDress1");
        txtClient.setId("txtClient");
        txtEmployee.setId("txtEmployee");
        //txtFinancial.setId("txtFinancial");
        //txtDress2.setId("txtDress2");
        
        mouseHandler();
        
        return leftPane;
    }
    
    private void mouseHandler(){
        txtDress1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!dp.getInsertDressPane().isVisible()){
                    dp.getInsertDressPane().setVisible(true);
                    cp.getClientPane().setVisible(false);
                    ep.getEmployeePane().setVisible(false);
                    dp.getScrollPane().setVisible(false);
                    dp.getBuyPane().setVisible(false);
                    SearchPane.getClientScrollPane2().setVisible(false);
                    SearchPane.getClientScrollPane().setVisible(false);
                }
            }
        });
        txtClient.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!cp.getClientPane().isVisible()){
                    dp.getInsertDressPane().setVisible(false);
                    cp.getClientPane().setVisible(true);
                    ep.getEmployeePane().setVisible(false);
                    dp.getScrollPane().setVisible(false);
                    dp.getBuyPane().setVisible(false);
                    SearchPane.getClientScrollPane2().setVisible(false);
                    SearchPane.getClientScrollPane().setVisible(false);
                }
            }
        });
        txtEmployee.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!ep.getEmployeePane().isVisible()){
                    dp.getInsertDressPane().setVisible(false);
                    cp.getClientPane().setVisible(false);
                    ep.getEmployeePane().setVisible(true);
                    dp.getScrollPane().setVisible(false);
                    dp.getBuyPane().setVisible(false);
                    SearchPane.getClientScrollPane2().setVisible(false);
                    SearchPane.getClientScrollPane().setVisible(false);
                }
            }
        });
    }
    
    // Settings JLabel //
    // Algumas configurações para JLabel //
    public Label settingsJLabel(Label label, String cor) {
        label.setStyle("-fx-background-color: "+cor+";");
        
        return label;
    }
    
    public static final MigPane getLeftPanel() {
        return leftPane;
    }
    
    // Instancia //
    //MainPane mp = new MainPane();
    ClientPane cp = new ClientPane();
    EmployeePane ep = new EmployeePane();
    DressPane dp = new DressPane();
    SearchPane sp = new SearchPane();
    
    //private MigPane leftPanel;
    private static final MigPane leftPane = new MigPane("wrap, ins 5 0 5 0");
    
    private Label txtLeftBackground;
    private Label txtInsert;
    private Label txtClient;
    private Label txtEmployee;
    //private Label txtFinancial;
    private Label txtDress1;
    //private Label txtDress2;
}
