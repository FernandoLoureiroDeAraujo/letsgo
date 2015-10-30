package br.com.viewfx;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.F1;
import static javafx.scene.input.KeyCode.F10;
import static javafx.scene.input.KeyCode.F11;
import static javafx.scene.input.KeyCode.F12;
import static javafx.scene.input.KeyCode.F2;
import static javafx.scene.input.KeyCode.F3;
import static javafx.scene.input.KeyCode.F4;
import static javafx.scene.input.KeyCode.F5;
import static javafx.scene.input.KeyCode.F6;
import static javafx.scene.input.KeyCode.F7;
import static javafx.scene.input.KeyCode.F8;
import static javafx.scene.input.KeyCode.F9;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.PopupWindow;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeListener;
import org.tbee.javafx.scene.layout.MigPane;

public class Setting {
            
    // Mostrar texto no TextField //
    public void promptText(TextField tfd, String string){
        tfd.setPromptText(string);
        tfd.promptTextProperty();
    }
    
    // Adiciona image a um ImageView //
    public void addImage(ImageView imageView){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        selectedFile = fileChooser.showOpenDialog(popupWindow);
        if (selectedFile != null) {
            imageView.setImage(new Image("File:"+selectedFile, 200, 170, false, true));
        }
    }
    
        
    public Image selectImage(byte[] byteImage, int width, int height) {
        Image image = null;
        try {
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(byteImage));
            BufferedImage aux = new BufferedImage(width, height, img.getType()); // Cria um buffer auxiliar com o tamanho desejado //
            Graphics2D g = aux.createGraphics(); // Pega a classe graphics do aux para edicao //
            AffineTransform at = AffineTransform.getScaleInstance((double) width / img.getWidth(), (double) height / img.getHeight()); // Cria a transformacao //
            g.drawRenderedImage(img, at); // Pinta e transforma a imagem real no auxiliar //
            image = SwingFXUtils.toFXImage(aux, null);
        } catch (IOException ex) {
            Logger.getLogger(DressPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }
    public Image selectImage(byte[] byteImage) {
        return selectImage(byteImage, 220, 170);
    }
      
    
    // Converter pra byte //
    public byte[] convertImageToByte() {
        byte[] bytes = null;
        try {
            // Converte a imagem em bytes para guardar no banco //
            ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
            BufferedImage imagemBuffer = ImageIO.read(selectedFile);
            ImageIO.write((BufferedImage)imagemBuffer, "jpg", bytesImg); // Seta a imagem para bytesImg //
            bytesImg.flush();// Limpa a variável //
            bytes = bytesImg.toByteArray(); // Converte ByteArrayOutputStream para byte[] //
            bytesImg.close(); // Fecha a conversão //
        } catch (IOException ex) {
            Logger.getLogger(DressPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bytes;
    }
    
    public File getSelectedFile() {
        return selectedFile;
    }
    
       
    public Alert setAlert(AlertType aviso, String text, String text2){
        //aviso = aviso.INFORMATION;
        Alert alert = new Alert(aviso);
        alert.setTitle(text);
        alert.setHeaderText(null);
        alert.setContentText(text2);
        alert.showAndWait();
        
        return alert;
    }
    
    public MigPane topBar(MigPane pane, String text){
        MigPane topBar = new MigPane("ins 0","push[][center][]push","push[][center][]push");
        Label label = new Label(text);
        topBar.add(label);
        pane.add(topBar, "cell 0 0, growx, pushx, span, h 70!");
        
        topBar.setId("topBar");
        
        return pane;
                
    }
    
    public static void formatterCPF(final TextField t) {
        t.textProperty().addListener((ObservableValue<? extends String> ov, String antigo, String novo) -> {
            //checkCPF(t);
            if (!novo.isEmpty() && novo.length() > antigo.length()) {
                try {

                    switch (novo.length()) {
                        case 3:
                            t.setText(novo + ".");
                            Platform.runLater(() -> {
                                t.end();
                            });

                            break;
                        case 7:
                            t.setText(novo + ".");
                            Platform.runLater(() -> {
                                t.end();
                            });

                            break;
                        case 11:
                            t.setText(novo + "-");
                            Platform.runLater(() -> {
                                t.end();
                            });

                            break;
                        case 15:
                            t.setText(antigo);
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("mask cpf"+e);

                }
            }
        });
    }
    
    public static void formatterCellPhone(final TextField t) {
        t.textProperty().addListener((ObservableValue<? extends String> ov, String antigo, String novo) -> {
            //checkCPF(t);
            if (!novo.isEmpty() && novo.length() > antigo.length()) {
                try {

                    switch (novo.length()) {
                        case 0:
                            t.setText(novo + "(");
                            Platform.runLater(() -> {
                                t.end();
                            });

                            break;
                        case 3:
                            t.setText(novo + ")");
                            Platform.runLater(() -> {
                                t.end();
                            });

                            break;
                        case 9:
                            t.setText(novo + "-");
                            Platform.runLater(() -> {
                                t.end();
                            });

                            break;
                        case 15:
                            t.setText(antigo);
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("mask cpf"+e);

                }
            }
        });
    }

    
    private final PopupWindow popupWindow = new PopupWindow() {};     
    private File selectedFile;


}
