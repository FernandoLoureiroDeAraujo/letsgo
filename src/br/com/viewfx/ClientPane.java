package br.com.viewfx;

import br.com.control.InsertControl;
import br.com.control.UpdateControl;
import br.com.model.Data;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.tbee.javafx.scene.layout.MigPane;

public class ClientPane implements EventHandler<javafx.event.ActionEvent>{

    
    public MigPane clientPane(){
        clientPane.setId("clientPanel");
        
        s.topBar(clientPane, "CLIENTE");
        
        clientPane.add(clientPanelData(),"cell 1 1, growx, pushx");
        clientPane.add(clientPanelContact(),"cell 1 2, growx, pushx");
        clientPane.add(clientPanelAddress(),"cell 1 3, growx, pushx");
        
        clientPane.setVisible(false);
        
        return clientPane;
    }
    
    private MigPane clientPanelData(){
        MigPane pane = new MigPane("gapy 15", "[100] [400] [100] [400]");

        
        
        pane.add(tfdnome = new TextField(),"cell 1 0, span, growx, pushx");
        pane.add(tfdRg = new TextField(),"cell 1 1");
        pane.add(tfdCpf = new TextField(),"cell 3 1, growx, pushx");
        pane.add(tfdDatanascimento = new TextField(),"cell 1 2");
        pane.add(cbSexo = new ChoiceBox(),"cell 3 2, growx, pushx, h 48px!");
        
        cbSexo.getItems().addAll("Sexo", "Feminino", "Masculino");
        cbSexo.getSelectionModel().selectFirst();
        
        s.formatterCPF(tfdCpf);
        MaskFieldUtil.dateField(tfdDatanascimento);
        MaskFieldUtil.numericField(tfdRg);
        
        s.promptText(tfdnome, "Nome*: ");
        s.promptText(tfdRg, "RG: ");
        s.promptText(tfdCpf, "CPF*: ");
        s.promptText(tfdDatanascimento, "Data de nascimento: ");
        
        return pane;
    }
    
    private MigPane clientPanelContact(){
        MigPane pane = new MigPane("gapy 15", "[100] [400] [100] [400]");
        
        pane.add(tfdTelefone = new TextField(),"cell 1 0");
        pane.add(tfdCelular = new TextField(),"cell 3 0");
        pane.add(tfdEmail = new TextField(), "cell 1 1, spanx4, growx, pushx");
                        
        s.promptText(tfdTelefone, "Telefone: ");
        s.promptText(tfdCelular, "Celular*: ");
        s.promptText(tfdEmail, "Email: ");
        
        MaskFieldUtil.cellPhoneField(tfdTelefone);
        MaskFieldUtil.cellPhoneField(tfdCelular);
        
        return pane;
    }
    
    private MigPane clientPanelAddress(){
        MigPane pane = new MigPane("gapy 15", "[100] [400] [100] [400]");
        
        pane.add(tfdCep = new TextField(),"cell 1 0");
        pane.add(cbUf = new ChoiceBox(),"cell 3 0, growx, pushx, h 48px!");
        pane.add(tfdEndereco = new TextField(), "cell 1 1, spanx4, growx, growx, pushx");
        pane.add(tfdBairro = new TextField(),"cell 1 2, growx, pushx");
        pane.add(tfdComplemento = new TextField(), "wrap, cell 3 2, growx, pushx");
        pane.add(btnEnviar = new Button("CADASTRAR"), "cell 3 3, growx, pushx");        
        btnEnviar.setStyle("-fx-text-fill: white;");
        
        cbUf.getItems().addAll("UF", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT",
                               "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO");
        cbUf.getSelectionModel().selectFirst();
                     
        MaskFieldUtil.cepField(tfdCep);
        
        s.promptText(tfdCep, "CEP*: ");
        s.promptText(tfdEndereco, "Endereço*: ");
        s.promptText(tfdBairro, "Bairro*: ");
        s.promptText(tfdComplemento, "Complemento: ");
        
        btnEnviar.setOnAction(this);  
        
        tfdCep.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                String CEP = tfdCep.getText();
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    if(CEP.length() >= 8){
                        BuscaCEP bc = new BuscaCEP();
                        tfdEndereco.setText(bc.getEndereco(CEP));
                        tfdBairro.setText(bc.getBairro(CEP));
                        cbUf.getSelectionModel().select(bc.getUF(CEP));
                    }
                
                }
            }
        });            
        
        return pane;
    }

    @Override
    public void handle(javafx.event.ActionEvent event) {
        if(event.getSource() == btnEnviar){
            if(tfdnome.getText().equals("") ||
                tfdCpf.getText().equals("")||
                tfdCelular.getText().equals("")||
                tfdCep.getText().equals("")||
                tfdEndereco.getText().equals("")||
                tfdBairro.getText().equals("")){
                
                if(tfdnome.getText().equals("")){
                    tfdnome.setStyle("-fx-border-color: red;");
                }
                if(tfdCpf.getText().equals("")){
                     tfdCpf.setStyle("-fx-border-color: red;");
                }

                if(tfdCelular.getText().equals("")){
                     tfdCelular.setStyle("-fx-border-color: red;");
                }

                if(tfdCep.getText().equals("")){
                     tfdCep.setStyle("-fx-border-color: red;");
                }
                if(tfdEndereco.getText().equals("")){
                     tfdEndereco.setStyle("-fx-border-color: red;");
                }
                if(tfdBairro.getText().equals("")){
                     tfdBairro.setStyle("-fx-border-color: red;");
                }
                return;            
            }
            
            if(btnEnviar.getText().equals("CADASTRAR")){
                if(tfdDatanascimento.getText().equals("")){
                    tfdDatanascimento.setText("NULL");
                    s.promptText(tfdDatanascimento, "Data de nascimento: ");
                }
                if(tfdRg.getText().equals("")){
                    tfdRg.setText("0");
                    s.promptText(tfdRg, "RG: ");
                }
                if(tfdTelefone.getText().equals("")){
                    tfdTelefone.setText("NULL");
                    s.promptText(tfdTelefone, "Telefone: ");
                }
                if(tfdEmail.getText().equals("")){
                    tfdEmail.setText("NULL");
                    s.promptText(tfdEmail, "Email: ");
                }
                if(tfdComplemento.getText().equals("")){
                    tfdComplemento.setText("NULL");
                    s.promptText(tfdComplemento, "Complemento: ");
                }
                
                    String id = tfdCpf.getText();
                     String cpf = "";
                     char[] numbers  = id.toCharArray();
                         for (char number : numbers) {
                             if(Character.isDigit(number)) {
                                 cpf += number;
                             }
                         }
                
                Data data = new Data(Long.valueOf(cpf), tfdnome.getText(), Integer.valueOf(tfdRg.getText()), tfdDatanascimento.getText(), (String)cbSexo.getValue(), 
                         tfdTelefone.getText(), tfdCelular.getText(), tfdEmail.getText(),
                         tfdCep.getText(), tfdEndereco.getText(), tfdBairro.getText(), tfdComplemento.getText(), (String)cbUf.getValue(), 1);
                ic.insertClient(data);
                s.setAlert(Alert.AlertType.INFORMATION, "Aviso", "Cliente cadastrado com sucesso");
            }
            if(btnEnviar.getText().equals("ALTERAR")){
                
                    String id = tfdCpf.getText();
                     String cpf = "";
                     char[] numbers  = id.toCharArray();
                         for (char number : numbers) {
                             if(Character.isDigit(number)) {
                                 cpf += number;
                             }
                         }
                
                Data data = new Data(Long.valueOf(cpf), tfdnome.getText(), Integer.valueOf(tfdRg.getText()), tfdDatanascimento.getText(), (String)cbSexo.getValue(), 
                         tfdTelefone.getText(), tfdCelular.getText(), tfdEmail.getText(),
                         tfdCep.getText(), tfdEndereco.getText(), tfdBairro.getText(), tfdComplemento.getText(), (String)cbUf.getValue(), 1);
                uc.clientUpdate(SearchPane.getCpfFromId(), data);
                s.setAlert(Alert.AlertType.INFORMATION, "Aviso", "Alteração realizada com sucesso");
                btnEnviar.setText("CADASTRAR");
            }
            
            setText("", "", "", "", "", "", "", "", "", "", "", "Sexo", "UF");
            setText();
            
            tfdnome.setStyle("-fx-border-color: none;");
            tfdCpf.setStyle("-fx-border-color: none;");
            tfdCelular.setStyle("-fx-border-color: none;");
            tfdCep.setStyle("-fx-border-color: none;");
            tfdEndereco.setStyle("-fx-border-color: none;");
            tfdBairro.setStyle("-fx-border-color: none;");
         }
    }
    
    public void setText(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13){
        tfdnome.setText(string);
        tfdRg.setText(string2);
        tfdCpf.setText(string3);
        tfdDatanascimento.setText(string4);

        tfdTelefone.setText(string5);
        tfdCelular.setText(string6);
        tfdEmail.setText(string7);

        tfdCep.setText(string8);
        tfdEndereco.setText(string9);
        tfdBairro.setText(string10);
        tfdComplemento.setText(string11);

        cbSexo.getSelectionModel().select(string12);    
        cbUf.getSelectionModel().select(string13);
    }
    
    public void setText(){
        s.promptText(tfdnome, "Nome*: ");
        s.promptText(tfdRg, "RG: ");
        s.promptText(tfdCpf, "CPF*: ");
        s.promptText(tfdDatanascimento, "Data de nascimento: ");
        
        s.promptText(tfdTelefone, "Telefone: ");
        s.promptText(tfdCelular, "Celular*: ");
        s.promptText(tfdEmail, "Email: ");
        
        s.promptText(tfdCep, "CEP*: ");
        s.promptText(tfdEndereco, "Endereço*: ");
        s.promptText(tfdBairro, "Bairro*: ");
        s.promptText(tfdComplemento, "Complemento: ");
        
    }
    
    public static MigPane getClientPane() {
        return clientPane;
    }

    public static TextField getTfnome() {
        return tfdnome;
    }

    public static TextField getTfrg() {
        return tfdRg;
    }

    public static TextField getTfcpf() {
        return tfdCpf;
    }

    public static TextField getTfdatanascimento() {
        return tfdDatanascimento;
    }

    public static TextField getTftelefone() {
        return tfdTelefone;
    }

    public static TextField getTfcelular() {
        return tfdCelular;
    }

    public static TextField getTfemail() {
        return tfdEmail;
    }

    public static TextField getTfcep() {
        return tfdCep;
    }

    public static TextField getTfendereco() {
        return tfdEndereco;
    }

    public static TextField getTfbairro() {
        return tfdBairro;
    }

    public static TextField getTfcomplemento() {
        return tfdComplemento;
    }

    public static ChoiceBox getCbsexo() {
        return cbSexo;
    }

    public static ChoiceBox getCbuf() {
        return cbUf;
    }

    public static Button getBtnEnviar() {
        return btnEnviar;
    }
    
    // Declaração //
    private static final MigPane clientPane = new MigPane("wrap, gap 10, ins 0", "[]push[center][center][center]push[]");
    
    // Instancia //
    Setting s = new Setting();
    InsertControl ic = new InsertControl();
    UpdateControl uc = new UpdateControl();

    // Declaração textfield //
    private static TextField tfdnome;
    private static TextField tfdRg;
    private static TextField tfdCpf;
    private static TextField tfdDatanascimento;

    private static TextField tfdTelefone;
    private static TextField tfdCelular;
    private static TextField tfdEmail;

    private static TextField tfdCep;
    private static TextField tfdEndereco;
    private static TextField tfdBairro;
    private static TextField tfdComplemento;
    
    // Declaração choicebox // 
    private static ChoiceBox cbSexo;    
    private static ChoiceBox  cbUf;

    // Declaração button //
    private static Button btnEnviar;

}
