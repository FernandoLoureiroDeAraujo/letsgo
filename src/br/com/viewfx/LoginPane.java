package br.com.viewfx;

import br.com.control.SelectControl;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.tbee.javafx.scene.layout.MigPane;

public class LoginPane implements EventHandler<javafx.event.ActionEvent>{
    
    static Stage window;
    static Scene scene;

    public void inicia() {
        window = new Stage();
        
        window.setTitle("LET'S GO");
        window.setWidth(400);
        window.setHeight(600);
        
        MigPane layout = new MigPane("ins 0, gap 0");  
        layout.add(loginPane()); 
        layout.getStylesheets().add("/br/com/viewfx/style.css");
        
        scene = new Scene(layout); 

        window.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setFullScreen(true);
        window.setScene(scene);
        window.show();
    }

    public MigPane topPaneLogin(){
        MigPane topPane = new MigPane("", "[grow, center] [ center]");
        
        topPane.add(lblNameProgram = new Label("LET'S GO"), "gapy 0");
        topPane.add(btnEnter = new Button("ENTRAR"),"align center, gapy 15");
        btnEnter.setStyle("-fx-text-fill: white;");
        
        btnEnter.setOnAction(this);
        
        topPane.setId("topPanel");
        lblNameProgram.setId("lblNameProgram"); 
        
        return topPane;
    }
    
    public MigPane loginPane(){        
        loginPane.add(topPaneLogin(),"wrap, w 399!");
        
        loginPaneinside.add(programImage = new ImageView(), "cell 1 0, align center");
        programImage.setImage(new Image("/br/com/image/lgLogo.png", 200, 200, false, true));
        loginPaneinside.add(tfdLogin = new TextField(),"gapy 70, cell 1 1, w 350!, gapx 25");
        loginPaneinside.add(tfdSenha = new PasswordField(),"gapy 15, cell 1 2, w 350!, gapx 25");
        
        tfdLogin.setId("tfdLogin");
        tfdSenha.setId("tfdSenha");
        
        s.formatterCPF(tfdLogin);
                
        tfdSenha.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    
                    
            String id = tfdLogin.getText();
             String cpf = "";
             char[] numbers  = id.toCharArray();
                 for (char number : numbers) {
                     if(Character.isDigit(number)) {
                         cpf += number;
                     }
                 }
                    
                    if(sc.loginAuthentication(cpf, tfdSenha.getText()) == true){
                        tfdLogin.setText(cpf);
                        if(SelectControl.getUserNivel()==1){
                            window.close();

                            if(m==0){
                                mp.mainScreen(true);
                                System.out.println("1");
                                m=10;
                            }
                            else{
                                MainScreen.window.show();
                            }
                            
                        }else{
                            window.close();
 
                            if(m==0){
                                mp.mainScreen(false);
                                System.out.println("1");
                                m=10;
                            }
                            else{
                                MainScreen.window.show();
                            }
                            LeftPane.getLeftPanel().setVisible(false);
                            
                        }
                    } else {
                        s.setAlert(AlertType.ERROR, "Error", "Usuario ou senha incorreto");
                    } 
                }
            }
        }); 
        
        s.promptText(tfdLogin, "Login:");
        s.promptText(tfdSenha, "Senha:");
        
        loginPane.add(loginPaneinside,"gapy 45px");
        loginPane.setVisible(true);
        
        return loginPane;
    }

    
    @Override
    public void handle(javafx.event.ActionEvent event) {
        if(event.getSource() == btnEnter){
            
                                
            String id = tfdLogin.getText();
             String cpf = "";
             char[] numbers  = id.toCharArray();
                 for (char number : numbers) {
                     if(Character.isDigit(number)) {
                         cpf += number;
                     }
                 }
            
            if(sc.loginAuthentication(cpf, tfdSenha.getText()) == true){
                tfdLogin.setText(cpf);
                if(SelectControl.getUserNivel()==1){
                    window.close();

                    if(m==0){
                        mp.mainScreen(true);
                        System.out.println("1");
                        m=10;
                    }
                    else{
                        MainScreen.window.show();
                        System.out.println("2");
                    }

                }else{
                    window.close();

                    if(m==0){
                        mp.mainScreen(false);
                        System.out.println("1");
                        m=10;
                    }
                    else{
                        MainScreen.window.show();
                    }
                    
                    LeftPane.getLeftPanel().setVisible(false);

                }
            } else {
                s.setAlert(AlertType.ERROR, "Error", "Usuario ou senha incorreto");
            }
        }
    }
    
    public static void setLogin(){
        tfdLogin.setText("");
        tfdLogin.setFocusTraversable(false);
        tfdLogin.requestFocus();
    }
    
    
    public static void setSenha(){
        tfdSenha.setText("");
        tfdLogin.setFocusTraversable(false);
    }
    
    public static String getTfdLogin() {
        return tfdLogin.getText();
    }

    public static void setTfdLogin(TextField tfdLogin) {
        LoginPane.tfdLogin = tfdLogin;
    }

    public PasswordField getTfdSenha() {
        return tfdSenha;
    }

    public void setTfdSenha(PasswordField tfdSenha) {
        this.tfdSenha = tfdSenha;
    }
    
    
    
    // Instancia //
    Setting s = new Setting();
    SelectControl sc = new SelectControl();
    MainScreen mp = new MainScreen();
    TopPane tp = new TopPane();
    
    // Declaração //
    private static final MigPane loginPane = new MigPane("wrap, ins 0");
    private static final MigPane loginPaneinside = new MigPane("ins 0, wrap", "[]push[center]push[]");

    private Label lblNameProgram;
    private static TextField tfdLogin;
    private static PasswordField tfdSenha;

    private ImageView programImage;
    
    private Button btnEnter;
    
    static Integer m = 0;
}