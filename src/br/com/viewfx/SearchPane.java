package br.com.viewfx;

import br.com.control.DeleteControl;
import br.com.control.SelectControl;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.tbee.javafx.scene.layout.MigPane;

public class SearchPane implements EventHandler<MouseEvent> {
    

    MigPane[] pane;
    MigPane[] pane2;
    public ScrollPane selectClient(){
        searchPane = new MigPane("wrap", "[]push[center][center][center]push[]");
        searchPane.setId("selectDressPane");
 
        sc.listClient();        

        pane = new MigPane[sc.getClientSize()];
        
        clientScrollPane = new ScrollPane();
        clientScrollPane.setPrefSize(500, 500);
        clientScrollPane.setContent(searchPane);
        clientScrollPane.setFitToWidth(true);
        
        
        for (int i = 0; i < sc.getClientSize(); i++) {

            pane[i] = new MigPane("", "[300] [300] [25]");
            
            labelArray(pane, "Nome: ", sc.getNome().get(i), "cell 0 0", i);
            labelArray(pane, "CPF: ", sc.getCpf().get(i).toString(), "cell 1 0", i);
            labelArray(pane, "Telefone: ", sc.getTelefone().get(i), "cell 0 1", i);
            labelArray(pane, "Celular: ", sc.getCelular().get(i), "cell 1 1", i);
            labelArray(pane, "Endereco: ", sc.getEndereco().get(i),"cell 0 3, span 2", i);
            
            imageViewArray(pane, "br/com/image/delete.png", "delete"+String.valueOf(sc.getCpf().get(i)), i);
            imageViewArray(pane, "br/com/image/edit.png", "alter"+String.valueOf(sc.getCpf().get(i)), i);
            
            pane[i].setStyle("-fx-border-color:lightgray;");
            
            searchPane.add(pane[i], "cell 2 "+i+"");
        }
        
        searchPane.add(clientScrollPane);
        clientScrollPane.setVisible(false);
        
        return clientScrollPane;
    }
    public ScrollPane selectClientCom(){
        searchPane = new MigPane("wrap", "[]push[center][center][center]push[]");
        searchPane.setId("selectDressPane");

        sc.listClient2(TopPane.getTfdSearch());
        
        pane = new MigPane[sc.getClientSize()];
        
        clientScrollPane = new ScrollPane();
        clientScrollPane.setPrefSize(500, 500);
        clientScrollPane.setContent(searchPane);
        clientScrollPane.setFitToWidth(true);
        
        
        for (int i = 0; i < sc.getClientSize(); i++) {

            pane[i] = new MigPane("", "[300] [300] [25]");
            
            labelArray(pane, "Nome: ", sc.getNome().get(i), "cell 0 0", i);
            labelArray(pane, "CPF: ", sc.getCpf().get(i).toString(), "cell 1 0", i);
            labelArray(pane, "Telefone: ", sc.getTelefone().get(i), "cell 0 1", i);
            labelArray(pane, "Celular: ", sc.getCelular().get(i), "cell 1 1", i);
            labelArray(pane, "Endereco: ", sc.getEndereco().get(i),"cell 0 3, span 2", i);
            
            imageViewArray(pane, "br/com/image/delete.png", "delete"+String.valueOf(sc.getCpf().get(i)), i);
            imageViewArray(pane, "br/com/image/edit.png", "alter"+String.valueOf(sc.getCpf().get(i)), i);
            
            pane[i].setStyle("-fx-border-color:lightgray;");
            
            searchPane.add(pane[i], "cell 2 "+i+"");
        }
        
        searchPane.add(clientScrollPane);
        clientScrollPane.setVisible(false);
        
        return clientScrollPane;
    }
    
    public ScrollPane selectEmployee(){
        searchPane2 = new MigPane("wrap", "[]push[center][center][center]push[]");
        searchPane2.setId("selectDressPane");

        sc.listEmployeeData();
        sc.listEmployeeValue();
        System.out.println(sc.getEmployeeSize());
        pane2 = new MigPane[sc.getEmployeeSize()];
        
        
        clientScrollPane2 = new ScrollPane();
        clientScrollPane2.setPrefSize(500, 500);
        clientScrollPane2.setContent(searchPane2);
        clientScrollPane2.setFitToWidth(true);
        
        for (int i = 0; i < sc.getEmployeeSize(); i++) {
            pane2[i] = new MigPane("", "[300] [300] [25]");
            
            labelArray2(pane2, "Nome: ", sc.getNome2().get(i), "cell 0 0", i);
            labelArray2(pane2, "CPF: ", sc.getCpf2().get(i).toString(), "cell 1 0", i);
            labelArray2(pane2, "Telefone: ", sc.getTelefone2().get(i), "cell 0 1", i);
            labelArray2(pane2, "Celular: ", sc.getCelular2().get(i), "cell 1 1", i);
            labelArray2(pane2, "Endereco: ", sc.getEndereco2().get(i),"cell 0 3, span 2", i);
            
            imageViewArray2(pane2, "br/com/image/delete.png", "delete2"+String.valueOf(sc.getCpf2().get(i)), i);
            imageViewArray2(pane2, "br/com/image/edit.png", "alter2"+String.valueOf(sc.getCpf2().get(i)), i);
            
            pane2[i].setStyle("-fx-border-color:lightgray;");
            
            searchPane2.add(pane2[i], "cell 2 "+i+"");
        }
        
        searchPane2.add(clientScrollPane2);
        clientScrollPane2.setVisible(false);
        
        return clientScrollPane2;
        
    }
    
    private void labelArray(MigPane[] pane, String text, String text2, String setting, int i) {
        labelsName = new Label[sc.getClientSize()];
        pane[i].add(labelsName[i] = new Label(), setting);
        labelsName[i].setText(text + text2);
    }

    private void imageViewArray(MigPane[] pane, String image, String id, int i){
        imageViews = new ImageView[sc.getClientSize()];
        imageViews[i] = new ImageView();
        imageViews[i].setImage(new Image(image));
        imageViews[i].setId(id);
        
        imageViews[i].setOnMouseClicked((EventHandler<? super MouseEvent>) this);
        
        pane[i].add(imageViews[i]);
    }
    private void labelArray2(MigPane[] pane, String text, String text2, String setting, int i) {
        labelsName = new Label[sc.getEmployeeSize()];
        pane[i].add(labelsName[i] = new Label(), setting);
        labelsName[i].setText(text + text2);
    }

    private void imageViewArray2(MigPane[] pane, String image, String id, int i){
        imageViews = new ImageView[sc.getEmployeeSize()];
        imageViews[i] = new ImageView();
        imageViews[i].setImage(new Image(image));
        imageViews[i].setId(id);
        
        imageViews[i].setOnMouseClicked((EventHandler<? super MouseEvent>) this);
        
        pane[i].add(imageViews[i]);
    }
    
    @Override
    public void handle(MouseEvent event) {
        
        // Pega o ID e retira o cpf passado.
        String id = event.getSource().toString();
        String cpf = "";
        char[] numbers  = id.toCharArray();
            for (char number : numbers) {
                if(Character.isDigit(number)) {
                    cpf += number;
                }
            }
        System.out.println(cpf);
        ImageView imageView = (ImageView)event.getSource();
        if(imageView.getId().equals("delete"+Long.valueOf(cpf))){
            dc.clientDelete(String.valueOf(cpf));
            s.setAlert(Alert.AlertType.INFORMATION, "Aviso", "O registro foi deletado com sucesso");
        }

        if(imageView.getId().equals("alter"+Long.valueOf(cpf))){
            clientScrollPane.setVisible(false);
            ClientPane.getClientPane().setVisible(true);
            
            for(int i = 0; i < sc.getClientSize(); i ++){ 
                if(sc.getCpf().get(i).equals(Long.valueOf(cpf))){
                    cpfFromId = cpf;
                    cp.setText(sc.getNome().get(i), String.valueOf(sc.getRg().get(i)), String.valueOf(sc.getCpf().get(i)), sc.getDataNascimento().get(i),
                               sc.getTelefone().get(i),sc.getCelular().get(i),sc.getEmail().get(i),
                               sc.getCep().get(i),sc.getEndereco().get(i),sc.getBairro().get(i),sc.getComplemento().get(i),
                               sc.getSexo().get(i),sc.getUf().get(i));

                    ClientPane.getBtnEnviar().setText("ALTERAR");
                    break;    
                }  
            }
                    //ClientPane.getBtnEnviar().setText("CADASTRAR");
        }
        if(imageView.getId().equals("delete2"+Long.valueOf(cpf))){
            dc.employeeDelete(String.valueOf(cpf));
            s.setAlert(Alert.AlertType.INFORMATION, "Aviso", "O registro foi deletado com sucesso");
        }

        if(imageView.getId().equals("alter2"+Long.valueOf(cpf))){
            clientScrollPane2.setVisible(false);
            EmployeePane.getEmployeePane().setVisible(true);
            
            for(int i = 0; i < sc.getEmployeeSize(); i ++){ 
                if(sc.getCpf2().get(i).equals(Long.valueOf(cpf))){
                    cpfFromId = cpf;
                    ep.setText(sc.getNome2().get(i), String.valueOf(sc.getRg2().get(i)), String.valueOf(sc.getCpf2().get(i)), sc.getDataNascimento2().get(i),
                               sc.getTelefone2().get(i),sc.getCelular2().get(i),sc.getEmail2().get(i),
                               sc.getCep2().get(i),sc.getEndereco2().get(i),sc.getBairro2().get(i),sc.getComplemento2().get(i),
                               sc.getSexo2().get(i),sc.getUf2().get(i));

                           
                    EmployeePane.getBtnEnviar().setText("ALTERAR");
                    break;    
                }  
            }
                    //ClientPane.getBtnEnviar().setText("CADASTRAR");
        }
    }
    
    public static ScrollPane getClientScrollPane() {
        return clientScrollPane;
    }
    public static ScrollPane getClientScrollPane2() {
        return clientScrollPane2;
    }
    
    // Instancia //
    Setting s = new Setting();
    SelectControl sc = new SelectControl();
    DeleteControl dc = new DeleteControl();
    ClientPane cp = new ClientPane();
    EmployeePane ep = new EmployeePane();
    
    // Declaração //
    private static ScrollPane clientScrollPane;
    private static ScrollPane clientScrollPane2;
    private MigPane searchPane;
    private MigPane searchPane2;
    
    private Label[] labelsName;
    private ImageView[] imageViews;
    private static String cpfFromId;
    
    public static String getCpfFromId() {
        return cpfFromId;
    }

    public static void setCpfFromId(String cpfFromId) {
        SearchPane.cpfFromId = cpfFromId;
    }
}

