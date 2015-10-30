package br.com.viewfx;

import br.com.control.InsertControl;
import br.com.control.SelectControl;
import br.com.model.Dress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import org.tbee.javafx.scene.layout.MigPane;

public class DressPane implements EventHandler<javafx.event.ActionEvent>{

    Image image = new Image("File:vestidos/dressInsert.png", 200, 170, false, false);
    public MigPane insertDressPane(){
        insertDressPane.setId("insertDressPane");
        
        s.topBar(insertDressPane, "VESTIDO");
        
        insertDressPane.add(ivVestido = new ImageView(),"cell 1 2, align center"); 
        insertDressPane.add(tfdCor = new TextField(),"cell 1 3");
        insertDressPane.add(tfdTamanho = new ChoiceBox<>(),"cell 1 4, growx, pushx, h 48px!");
        insertDressPane.add(tfdModelo = new TextField(),"cell 1 5");
        insertDressPane.add(tfdQuantidade = new TextField(),"cell 1 6");
        insertDressPane.add(tfdValor = new TextField(),"cell 1 7");
        insertDressPane.add(btnEnviar = new Button("CADASTRAR"),"cell 1 8, growx, pushx");
        btnEnviar.setStyle("-fx-text-fill: white;");
        
                
        tfdTamanho.getItems().addAll("Tamanho", "PP", "P", "M", "G", "GG");
        tfdTamanho.getSelectionModel().selectFirst();
        
        ivVestido.setImage(image);
        
        btnEnviar.setOnAction(this);
        
        MaskFieldUtil.monetaryFieldDoubleFacilitator(tfdValor);
        
        s.promptText(tfdCor, "Cor: ");
        s.promptText(tfdModelo, "Modelo: ");
        s.promptText(tfdQuantidade, "Quantidade: ");
        s.promptText(tfdValor, "Valor: ");
        
        mouseHandler();

        insertDressPane.setVisible(false);
        
        return insertDressPane;
    }
    MigPane[] pane;
    MigPane topBar;
    public ScrollPane selectDressPane(){
        selectDressPane = new MigPane("ins 0, wrap 4");
        topBar = new MigPane("ins 0","push[][center][]push[][]","push[][center][]push");
        selectDressPane.setId("selectDressPane");
       
        sc.listDress();   

        pane = new MigPane[sc.getDressSize()];
        
        scrollPane = new ScrollPane();
        scrollPane.setPrefSize(500, 500);
        scrollPane.setContent(selectDressPane);
        scrollPane.setFitToWidth(true);
        
        
        Label label = new Label("VESTIDO");
        topBar.add(label, "cell 1 0");
        topBar.add(ivCarrinho = new ImageView(), "cell 3 0");
        ivCarrinho.setImage( new Image("/br/com/image/cart.png"));
        topBar.add(lblQtd = new Label(""));
        lblQtd.setStyle("-fx-font-size: 11px;");
        topBar.setId("topBar");
        
        selectDressPane.add(topBar, "cell 0 0, growx, pushx, span, h 70!");
        
        while(i < sc.getDressSize()){
            pane[i] = new MigPane("gapy 15", "[300] [300] [300]");

            labelArrayImage(pane, String.valueOf(sc.getCodVest().get(i)), "cell 1 0, span 0 5, wrap, align center", i);
            labelArray2(pane, "", sc.getTamanho().get(i),"cell 2 0", i);
            choiceBoxArray(pane, sc.getQuantidade().get(i), "cell 0 0", i);
            labelArray(pane, "", sc.getValor().get(i), "cell 1 6, align center", i);
            pane[i].setId("pane"+String.valueOf(sc.getCodVest().get(i)));
            
            pane[i].addEventFilter(MouseEvent.MOUSE_ENTERED, (MouseEvent mouseEvent) -> {
                MigPane migPane = (MigPane) mouseEvent.getSource();
                migPane.setStyle("-fx-background-color:#fce4ec;");
                migPane.getChildren().get(2).setVisible(true);
                migPane.getChildren().get(1).setVisible(true);
            });
            
            pane[i].addEventFilter(MouseEvent.MOUSE_EXITED, (MouseEvent mouseEvent) -> {
                MigPane migPane = (MigPane) mouseEvent.getSource();
                migPane.setStyle("-fx-background-color:none;");
                migPane.getChildren().get(2).setVisible(false);
                migPane.getChildren().get(1).setVisible(false);
            });
            
                            
            pane[i].addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                MigPane mig = (MigPane) mouseEvent.getSource();
                // Pega o ID e retira o cpf passado.
                String id = mouseEvent.getSource().toString();
                String cpf = "";
                char[] numbers  = id.toCharArray();
                    for (char number : numbers) {
                        if(Character.isDigit(number)) {
                            cpf += number;
                        }
                    }

                if(mig.getId().equals("pane"+Integer.valueOf(cpf))){
                        ChoiceBox choice = (ChoiceBox) mig.getChildren().get(2);
                        Label lbl = (Label) mig.getChildren().get(3);
                        totalCompra = (Integer)choice.getValue() * Double.valueOf(lbl.getText());
                        valores.put(cpf, totalCompra);
                        System.out.println(valores.get("totalCompra"));
                       
                }
            });
            
            selectDressPane.add(pane[i]);
            
            i++;
        }
//        Label columnCor = new Label();
//        columnCor.setText("Cor");
//        buyPane.add(columnCor, "cell 0 0");
//        Label columnTamanho = new Label();
//        columnTamanho.setText("Tamanho");
//        buyPane.add(columnTamanho, "cell 1 0");
//        Label columnModelo = new Label();
//        columnModelo.setText("Modelo");
//        buyPane.add(columnModelo, "cell 2 0");
//        Label columnValor = new Label();
//        columnValor.setText("Valor");
//        buyPane.add(columnValor, "cell 3 0");
        btnAlugar = new Button("Alugar");
        ivCarrinho.addEventFilter(MouseEvent.MOUSE_PRESSED, (MouseEvent mouseEvent) -> {
            int k=0;
            for (int j = 0; j < sc.getDressSize(); j++) {
                for (k = 0; k < string.size(); k++) {
                    if(sc.getCodVest().get(j).equals(Integer.valueOf(string.get(k)))){
                        scrollPane.setVisible(false);
                        buyPanel(j);
                        System.out.println(choiceBoxs[j].getValue());
                        break; 
                    }
                }

            }
               
            for (String key : valores.keySet()) {
                //Capturamos o valor a partir da chave
                Double value = valores.get(key);
                System.out.println(key + " = " + value);
                totalmsm += value;
                System.out.println(totalmsm);
            }

            MainPane.getMainPane().add(buyPanel(k), "wrap, hidemode 3, grow, push");
            buyPane.remove(k);
            buyPane.add(lblValor = new Label(),"cell 0 "+k+++", wrap, gap 345");
            buyPane.add(tfdCpf = new TextField(),"cell 0 "+k+++", wrap");
            buyPane.add(tfdDataDevolucao = new TextField(),"cell 0 "+k+++", wrap");
            s.formatterCPF(tfdCpf);
            s.promptText(tfdCpf, "CPF do Cliente*:");
            MaskFieldUtil.dateField(tfdDataDevolucao);
            s.promptText(tfdDataDevolucao, "Data de devolução*:");
            lblValor.setText(String.valueOf(totalmsm));
            buyPane.add(btnAlugar,"cell 0 "+k+++", w 250!, gapx 150");
            btnAlugar.setStyle("-fx-text-fill: WHITE;");
            btnAlugar.setText("ALUGAR");
            buyPane.setVisible(true);
        });

        
        btnAlugar.setOnAction(this);
        selectDressPane.add(scrollPane);
        scrollPane.setVisible(true);
        
        return scrollPane;
    }
    TextField tfdDataDevolucao;
    Double totalmsm = 0d;
    Map<String, Double> valores = new HashMap<String, Double>();
    public MigPane buyPanel(int k){
        buyPane.setId("buyPane");
        MigPane[] pane = new MigPane[sc.getDressSize()];
        
        pane[k] = new MigPane("gapy 15");

        labelArrayImage(pane, "span 1 5", k);
        labelArray(pane, "Cor: ", sc.getCor().get(k), "", k);
        labelArray(pane, "Tamanho: ", sc.getTamanho().get(k),"", k);
        labelArray(pane, "Modelo: ", sc.getModelo().get(k), "", k);
        labelArray(pane, "R$ ", sc.getValor().get(k), "", k);
        choiceBoxArray(pane, sc.getQuantidade().get(k), "wrap", k);
        
        buyPane.add(pane[k],"wrap");
        
        return buyPane;
    }
    ChoiceBox[] choiceBoxs;
    private void choiceBoxArray(MigPane[] pane, Integer text, String setting, int i){
        choiceBoxs = new ChoiceBox[sc.getDressSize()];
        pane[i].add(choiceBoxs[i] = new ChoiceBox(), setting);

        for (int j = 1; j <= text; j++) {
            choiceBoxs[i].getItems().add(j);
        }

        choiceBoxs[i].getSelectionModel().selectFirst();
        choiceBoxs[i].setVisible(false);
    }
    
    private void buttonArray(MigPane[] pane, String text, String setting, int i) {
        button = new Button[sc.getDressSize()];
        pane[i].add(button[i] = new Button(), setting);
        button[i].setText("ALUGAR");
        button[i].setId("alugar"+text);
        
        button[i].setOnAction(this);
    }
    
    private void labelArray(MigPane[] pane, String text, String text2, String setting, Integer qtd, int i) {
        Label[] labelsName = new Label[qtd];
        pane[i].add(labelsName[i] = new Label(), setting);
        labelsName[i].setText(text + text2);
    }
    
    private void labelArray2(MigPane[] pane, String text, String text2, String setting, int i) {
        Label[] labelsName = new Label[sc.getDressSize()];
        pane[i].add(labelsName[i] = new Label(), setting);
        labelsName[i].setText(text + text2);
        labelsName[i].setVisible(false);
    }
    
    private void labelArray(MigPane[] pane, String text, String text2, String setting, int i){
        labelArray(pane, text, text2, setting, sc.getDressSize(), i);
    }

    private void labelArrayImage(MigPane[] pane, String setting, int i){
        ImageView[] imageViews = new ImageView[sc.getDressSize()];
        imageViews[i] = new ImageView();
        imageViews[i].setImage(new Image("File:"+sc.getVestido().get(i), 100, 120, false, false));
        pane[i].add(imageViews[i], setting); 
    }
    
    private void labelArrayImage(MigPane[] pane, String text, String setting, int i){
        ImageView[] imageViews = new ImageView[sc.getDressSize()];
        imageViews[i] = new ImageView();
        imageViews[i].setImage(new Image("File:"+sc.getVestido().get(i), 250, 300, false, false));
        imageViews[i].setId("alugar"+text);
        pane[i].add(imageViews[i], setting); 

        imageViews[i].addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Pega o ID e retira o cpf passado.
                String id = mouseEvent.getSource().toString();
                String cpf = "";
                char[] numbers  = id.toCharArray();
                    for (char number : numbers) {
                        if(Character.isDigit(number)) {
                            cpf += number;
                        }
                    }

                ImageView image = (ImageView) mouseEvent.getSource();
                if(image.getId().equals("alugar"+Integer.valueOf(cpf))){
                    string.add(cpf);
                    image.setDisable(true);
                    lblQtd.setText(""+a++);
                    System.out.println(string);
                }  
            }
        });
        
    }
    
    // Evento do mouse //
    private void mouseHandler(){
        ivVestido.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                s.addImage(ivVestido);
            }
        });
    }
    
    public void setText(String string, String string2, String string3, String string4, String string5){
        tfdCor.setText(string);
        tfdModelo.setText(string3);
        tfdQuantidade.setText(string4);

        tfdValor.setText(string5);
    }
    
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == btnEnviar){
            if(tfdCor.getText().equals("") ||
                tfdModelo.getText().equals("") ||
                tfdQuantidade.getText().equals("") ||
                tfdValor.getText().equals("")){
                
                if(ivVestido.getImage().equals(image)){
                    s.setAlert(Alert.AlertType.ERROR, "Error", "Você precisa adicionar a image do vestido");
                }
                
                if(tfdCor.getText().equals("")){
                    tfdCor.setStyle("-fx-border-color: red;");
                    tfdCor.requestFocus();
                }
                if(tfdModelo.getText().equals("")){
                    tfdModelo.setStyle("-fx-border-color: red;");
                    tfdModelo.requestFocus();
                }
                if(tfdQuantidade.getText().equals("")){
                    tfdQuantidade.setStyle("-fx-border-color: red;");
                    tfdQuantidade.requestFocus();
                } 
                if(tfdValor.getText().equals("")){
                    tfdValor.setStyle("-fx-border-color: red;");
                    tfdValor.requestFocus();
                }
                return;
            }
            
            Dress dress = new Dress(s.getSelectedFile().toString(), tfdCor.getText(), (String)tfdTamanho.getValue(), tfdModelo.getText(), Integer.valueOf(tfdQuantidade.getText()), tfdValor.getText());
            ic.insertDress(dress);
            
            ivVestido.setImage(image);
            
            tfdTamanho.setStyle("-fx-border-color: none;");
            tfdModelo.setStyle("-fx-border-color: none;");
            tfdQuantidade.setStyle("-fx-border-color: none;");
            tfdValor.setStyle("-fx-border-color: none;");
            
            tfdCor.setText("");
            tfdTamanho.getSelectionModel().select("Tamanho");
            tfdModelo.setText("");
            tfdQuantidade.setText("");
            tfdValor.setText("");
        }
        
        if(event.getSource() == btnAlugar){
            sc.listClient();
            int k=0;
            Boolean bool = false;

            String id = tfdCpf.getText();
             String cpf = "";
             char[] numbers  = id.toCharArray();
                 for (char number : numbers) {
                     if(Character.isDigit(number)) {
                         cpf += number;
                     }
                 }
            
            for (int j = 0; j < sc.getCpf().size(); j++) {

                if(sc.getCpf().get(j).toString().equals(cpf)){
                    bool = true;
                    break;
                }
            }

            if(bool){
                
                for (k = 0; k < string.size(); k++) {
                    ic.insertLocacao(cpf, Long.valueOf(LoginPane.getTfdLogin()), string.get(k), getDateTime(), tfdDataDevolucao.getText(), Double.valueOf(lblValor.getText()));
                }
                tfdCpf.setText("");
                s.promptText(tfdCpf, "CPF do Cliente*:");
                s.setAlert(Alert.AlertType.INFORMATION, "Aviso", "Aluguel efetuado com sucesso!");
                
                DressPane dp = new DressPane();
                DressPane.getScrollPane().setContent(null);
                MainPane.getMainPane().remove(DressPane.getScrollPane());
                MainPane.getMainPane().add(dp.selectDressPane(), "cell 1 0, hidemode 3, grow, push");
                
                if(dp.getScrollPane().isVisible()){
                    dp.getInsertDressPane().setVisible(false);
                    ClientPane.getClientPane().setVisible(false);
                    EmployeePane.getEmployeePane().setVisible(false);
                    dp.getScrollPane().setVisible(true);
                    dp.getBuyPane().setVisible(false);
                    SearchPane.getClientScrollPane().setVisible(false);
                    SearchPane.getClientScrollPane2().setVisible(false);
                }
                
            } else{
                s.setAlert(Alert.AlertType.INFORMATION, "Aviso", "Cliente não encontrado!");
            }    
        }
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	return dateFormat.format(date);
    }

    // Getters //
    public static MigPane getInsertDressPane() {
        return insertDressPane;
    }

    public static ScrollPane getScrollPane() {
        return scrollPane;
    }

    public static MigPane getBuyPane() {
        return buyPane;
    }
    
    // Instancia //
    Setting s = new Setting();
    SelectControl sc = new SelectControl();
    InsertControl ic = new InsertControl();
    
    // Declaração //
    private int i = 0;
    private int a = 1;
    
    // Insert Dress //
    private static final MigPane insertDressPane = new MigPane("ins 0, wrap", "[]push[center]push[]");
    private static ScrollPane scrollPane;
    
    private ImageView ivVestido;    
    private TextField tfdCor;
    private ChoiceBox tfdTamanho;
    private TextField tfdModelo;
    private TextField tfdQuantidade;
    private TextField tfdValor;
    private Button btnEnviar;    
    
    // Select Dress //
    private MigPane selectDressPane;
    private Button[] button;
    
    // Buy Dress //
    private static MigPane buyPane = new MigPane("gapy 25", "push[center]push[]");
    private ImageView ivCarrinho;
    private Label lblValor;
    private Label lblQtd;
    private Button btnAlugar;
    Double totalCompra=0d;
    
    private TextField tfdCpf;

    List<String> string = new ArrayList<>();
    List<Double> values = new ArrayList<>();
     
    TableView<Dress> table;
     
    private void table(){
        //String vestido, String cor, String tamanho, String modelo, Integer quantidade, Double valor
        //Name column
        TableColumn<Dress, String> nameColumn = new TableColumn<>("vestido");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("vestido"));

        //Price column
        TableColumn<Dress, String> tamanho = new TableColumn<>("tamanho");
        tamanho.setMinWidth(100);
        tamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        
        //Price column
        TableColumn<Dress, String> priceColumn = new TableColumn<>("cor");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("cor"));

        //Quantity column
        TableColumn<Dress, String> quantityColumn = new TableColumn<>("modelo");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        
        //Quantity column
        TableColumn<Dress, Integer> quantidade = new TableColumn<>("quantidade");
        quantidade.setMinWidth(100);
        quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        
        //Quantity column
        TableColumn<Dress, Double> valor = new TableColumn<>("valor");
        valor.setMinWidth(100);
        valor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        table = new TableView<>();
        table.setMinSize(800, 600);
        table.setItems(sc.listDress2());
        table.getColumns().addAll(nameColumn, tamanho, priceColumn, quantityColumn, quantidade, valor);
        
        insertDressPane.add(table);
    }
}
