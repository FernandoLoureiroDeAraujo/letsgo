package br.com.viewfx;

import br.com.control.InsertControl;
import br.com.model.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.tbee.javafx.scene.layout.MigPane;

public class EmployeePane implements EventHandler<javafx.event.ActionEvent>{
    
    public MigPane employeePane(){        
        employeePane.setId("employeePanel");
        
        employeePane.add(employeePanelData(),"grow, pushx");
        employeePane.add(employeePanelContact(),"grow, pushx");
        employeePane.add(employeePanelAddress(),"grow, pushx");
        employeePane.add(employeePanelInformation(),"grow, pushx");
        
        mouseHandler();
        
        employeePane.setVisible(false);
        
        return employeePane;
    }
    Image image = new Image("File:userFotos/userWithoutImage.png", 200, 170, false, true);
    private MigPane employeePanelData(){
        MigPane panel = new MigPane("gapy 15", "[50] [400] [50] [400] [50] [400] [50]");
        
        s.topBar(employeePane, "FUNCIONÁRIO");
        
        panel.add(employeeImage = new ImageView(), "span 2 3, align center");
        panel.add(tfdNome = new TextField(),"cell 3 0, growx, pushx, spanx3");
        panel.add(tfdRg = new TextField(),"cell 3 1, growx, pushx");
        panel.add(tfdCpf = new TextField(),"cell 5 1, growx, pushx");
        panel.add(tfdDatanascimento = new TextField(),"cell 3 2, growx, pushx");
        panel.add(cbSexo = new ChoiceBox(), "cell 5 2, growx, pushx, h 48px!");
        
        employeeImage.setImage(image);
        cbSexo.getItems().addAll("Sexo", "Feminino", "Masculino");
        cbSexo.getSelectionModel().selectFirst();
                
        s.formatterCPF(tfdCpf);
        MaskFieldUtil.dateField(tfdDatanascimento);
        MaskFieldUtil.numericField(tfdRg);
        
        s.promptText(tfdNome, "Nome*: ");
        s.promptText(tfdRg, "RG: ");
        s.promptText(tfdCpf, "CPF*: ");
        s.promptText(tfdDatanascimento, "Data de nascimento: ");
        
        return panel;
    }
    
    private MigPane employeePanelContact(){
        MigPane panel = new MigPane("gapy 15", "[50] [400] [50] [400] [50] [400] [50]");
        
        panel.add(tfdTelefone = new TextField(), "cell 1 0");
        panel.add(tfdCelular = new TextField(), "cell 3 0, growx, pushx");
        panel.add(tfdEmail = new TextField(), "cell 5 0, growx, pushx");
                        
        s.promptText(tfdTelefone, "Telefone: ");
        s.promptText(tfdCelular, "Celular*: ");
        s.promptText(tfdEmail, "Email: ");
        
        MaskFieldUtil.cellPhoneField(tfdTelefone);
        MaskFieldUtil.cellPhoneField(tfdCelular);
        
        return panel;
    }
    
    private MigPane employeePanelAddress(){
        MigPane panel = new MigPane("gapy 15", "[50] [400] [50] [400] [50] [400] [50]");
        
        panel.add(tfdCep = new TextField(), "cell 1 0");
        panel.add(tfdEndereco = new TextField(), "cell 3 0, spanx3, growx, wrap");
        panel.add(tfdBairro = new TextField(),"cell 1 1");
        panel.add(tfdComplemento = new TextField(),"cell 3 1, growx, pushx");
        panel.add(cbUf = new ChoiceBox(), "cell 5 1, growx, pushx, h 48px!");
        
        cbUf.getItems().addAll("UF", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT",
                                 "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO");
        
        cbUf.getSelectionModel().selectFirst();
             
        MaskFieldUtil.cepField(tfdCep);
        
        s.promptText(tfdCep, "CEP*: ");
        s.promptText(tfdEndereco, "Endereço*: ");
        s.promptText(tfdBairro, "Bairro*: ");
        s.promptText(tfdComplemento, "Complemento: ");
        
        tfdCep.setOnKeyPressed(new EventHandler<KeyEvent>() {
        public void handle(KeyEvent keyEvent) {
            String CEP = tfdCep.getText();
            if (keyEvent.getCode() == KeyCode.ENTER) {
                if(CEP.length() >= 8){
                    System.out.println(tfdCpf.getText());
                    System.out.println(tfdSalario.getText());
                    BuscaCEP bc = new BuscaCEP();
                    tfdEndereco.setText(bc.getEndereco(CEP));
                    tfdBairro.setText(bc.getBairro(CEP));
                    cbUf.getSelectionModel().select(bc.getUF(CEP));
                    
                }

            }
        }
        });  
        
        return panel;
    }
    
    private MigPane employeePanelInformation(){
        MigPane panel = new MigPane("gapy 15", "[50] [400] [50] [400] [50] [400] [50]");
        
        panel.add(tfdCargo = new TextField(),"cell 1 0");
        panel.add(tfdSalario = new TextField(),"cell 1 1");
        panel.add(tfdSenha = new PasswordField(),"cell 3 0, growx, pushx");
        panel.add(tfdDataadmissao = new TextField(),"cell 3 1, growx, pushx");
        panel.add(tfdDatademissao = new TextField(),"cell 5 1, growx, pushx");
        panel.add(cbNivel = new ChoiceBox(),"cell 5 0, growx, pushx, h 48px!");
        
        panel.add(btnEnviar = new Button("CADASTRAR"), "cell 5 2, growx, pushx");
        btnEnviar.setStyle("-fx-text-fill: white;");
        
        btnEnviar.setOnAction(this);
        tfdDatademissao.setVisible(false);
        
        s.promptText(tfdCargo, "Cargo funcionário*: ");
        s.promptText(tfdSalario, "Salário*: ");
        s.promptText(tfdSenha, "Senha*: ");
        s.promptText(tfdDataadmissao, "Data Admissão*: ");
        s.promptText(tfdDatademissao, "Data Demissão: ");
        
        MaskFieldUtil.monetaryField(tfdSalario);
        MaskFieldUtil.dateField(tfdDataadmissao);
        MaskFieldUtil.dateField(tfdDatademissao);
        
        cbNivel.getItems().addAll("Funcionario", "Gerente");
        cbNivel.getSelectionModel().selectFirst();
        
        return panel;
    }

    
    // Evento do mouse //
    private void mouseHandler(){
        employeeImage.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                s.addImage(employeeImage);
            }
        });
    }
    
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == btnEnviar){
            if(tfdNome.getText().equals("") ||
                tfdCpf.getText().equals("")||
                tfdCelular.getText().equals("")||
                tfdCep.getText().equals("")||
                tfdEndereco.getText().equals("")||
                tfdBairro.getText().equals("")||
                tfdCargo.getText().equals("")||
                tfdSenha.getText().equals("")||
                tfdSalario.getText().equals("")||
                tfdDataadmissao.getText().equals("")||
                cbSexo.getSelectionModel().equals("Sexo")||
                cbUf.getSelectionModel().equals("UF")){
                
                if(tfdNome.getText().equals("")){
                    tfdNome.setStyle("-fx-border-color: red;");
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
                if(tfdCargo.getText().equals("")){
                     tfdCargo.setStyle("-fx-border-color: red;");
                }
                if(tfdSenha.getText().equals("")){
                     tfdSenha.setStyle("-fx-border-color: red;");
                }
                if(tfdSalario.getText().equals("")){
                     tfdSalario.setStyle("-fx-border-color: red;");
                }
                if(tfdDataadmissao.getText().equals("")){
                     tfdDataadmissao.setStyle("-fx-border-color: red;");
                }
                if(cbSexo.getSelectionModel().equals("Sexo")){
                    System.out.println("45465454656455");
                }
                if(cbUf.getSelectionModel().equals("UF")){
                    System.out.println("5465456");
                }
                return;            
            }
        
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
                         
                     String v = tfdSalario.getText();
                     String salario = "";
                     char[] numb  = v.toCharArray();
                         for (char numbe : numb) {
                             if(Character.isDigit(numbe)) {
                                 salario += numbe;
                             }
                         }
                         System.out.println(salario);
                
            Employee employee = new Employee(Long.valueOf(cpf), s.getSelectedFile().toString(), tfdNome.getText(), Integer.valueOf(tfdRg.getText()), tfdDatanascimento.getText(), (String)cbSexo.getValue(),
                    tfdTelefone.getText(), tfdCelular.getText(), tfdEmail.getText(),
                    tfdCep.getText(), tfdEndereco.getText(), tfdBairro.getText(), tfdComplemento.getText(), (String)cbUf.getValue(), cbNivel.getSelectionModel().getSelectedIndex(), 1,
                    tfdCargo.getText(), Double.valueOf(salario), tfdDataadmissao.getText(), " ", tfdSenha.getText());
            ic.insertEmployeeData(employee);
            ic.insertEmployeeAdm(employee);
            
                        
            setText("", "Sexo", "UF");
            setText();
            
            tfdNome.setStyle("-fx-border-color: none;");
            tfdCpf.setStyle("-fx-border-color: none;");
            tfdCelular.setStyle("-fx-border-color: none;");
            tfdCep.setStyle("-fx-border-color: none;");
            tfdEndereco.setStyle("-fx-border-color: none;");
            tfdBairro.setStyle("-fx-border-color: none;");
        }
    }
    
        
    public void setText(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13){
        tfdNome.setText(string);
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
    
    public void setText(String string, String string2, String string3){
        tfdNome.setText(string);
        tfdRg.setText(string);
        tfdCpf.setText(string);
        tfdDatanascimento.setText(string);

        tfdTelefone.setText(string);
        tfdCelular.setText(string);
        tfdEmail.setText(string);

        tfdCep.setText(string);
        tfdEndereco.setText(string);
        tfdBairro.setText(string);
        tfdComplemento.setText(string);

        cbSexo.getSelectionModel().select(string2);    
        cbUf.getSelectionModel().select(string3);
        cbNivel.getSelectionModel().select("Funcionario");
        
        tfdCargo.setText(string);
        tfdSalario.setText(string);
        tfdDataadmissao.setText(string);
        tfdSenha.setText(string);
        
        employeeImage.setImage(image);
    }
    
    public void setText(){
        s.promptText(tfdNome, "Nome*: ");
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
        
        s.promptText(tfdCargo, "Cargo funcionário*: ");
        s.promptText(tfdSalario, "Salário*: ");
        s.promptText(tfdSenha, "Senha*: ");
        s.promptText(tfdDataadmissao, "Data Admissão*: ");
        s.promptText(tfdDatademissao, "Data Demissão: ");
        
    }
    
    public static MigPane getEmployeePane() {
        return employeePane;
    }

    public static Button getBtnEnviar() {
        return btnEnviar;
    }

    public static void setBtnEnviar(Button btnEnviar) {
        EmployeePane.btnEnviar = btnEnviar;
    }
    
    // Instancia //
    MaskFieldUtil mask = new MaskFieldUtil() {};
    Setting s = new Setting();
    InsertControl ic = new InsertControl();
    
    // Declaração //
    private static final MigPane employeePane = new MigPane("wrap, ins 0");
    
    private ImageView employeeImage;
    
    private TextField tfdNome;
    private TextField tfdRg;
    private TextField tfdCpf;
    private TextField tfdDatanascimento;
    private ChoiceBox cbSexo;

    private TextField tfdTelefone;
    private TextField tfdCelular;
    private TextField tfdEmail;

    private TextField tfdCep;
    private ChoiceBox cbUf;
    private TextField tfdEndereco;
    private TextField tfdBairro;
    private TextField tfdComplemento;
    
    private TextField tfdCargo;
    private TextField tfdSalario;
    private PasswordField tfdSenha;
    private TextField tfdDataadmissao;
    private ChoiceBox  cbNivel;
    private TextField tfdDatademissao;
    
    private static Button btnEnviar;
}
