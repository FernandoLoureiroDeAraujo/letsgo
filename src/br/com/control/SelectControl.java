package br.com.control;

import br.com.model.Dress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SelectControl {

    public SelectControl() {
        conexaobanco = new ConexaoBanco();
        databasecontrol = new DataBaseControl();

        conn = null;
        stmt = null;
        pstmt = null;
        rset = null;
    }
    
    public boolean loginAuthentication(String login, String senha) {
        
        boolean access = false;        
        
        try {
            conn = conexaobanco.getConexaoMySQL();

            String query = "SELECT Func_CPF, Senha, Nome, Foto, Nivel from tbl_dadosFuncionario WHERE Func_CPF = ? and Senha = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            
            rset = pstmt.executeQuery();

            if(rset.next()) {
                access = true;
                userfoto = rset.getString("Foto");
                username = rset.getString("Nome");
                userNivel = rset.getInt("Nivel");
            }
        } catch (Exception e) {
            System.err.println("Got an exception! Login"+e);
        } finally {
            conexaobanco.fecharTodasConexoes(conn, stmt, rset);
        }
        return access;
    }

    public void listDress() {
        try {
            conn = conexaobanco.getConexaoMySQL();

            String query = "SELECT * FROM tbl_vestido";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);

            while (rset.next()) {
                cod_vest.add(rset.getInt("Cod_Vest"));
                vestido.add(rset.getString("Vestido"));
                cor.add(rset.getString("Cor"));
                tamanho.add(rset.getString("Tamanho"));
                modelo.add(rset.getString("Modelo"));
                quantidade.add(rset.getInt("Quantidade"));
                valor.add(rset.getString("Valor"));
            }            
        } catch (Exception e) {
            System.err.println("Got an exception! listDress"+e);
            System.err.println(e.getMessage());
        } finally {
            conexaobanco.fecharTodasConexoes(conn, stmt, rset);
        }
    }
    
    public ObservableList<Dress> listDress2() {

        ObservableList<Dress> dresses = FXCollections.observableArrayList();
        
        try {
            conn = conexaobanco.getConexaoMySQL();

            String query = "SELECT * FROM tbl_vestido";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);

            while (rset.next()) {
                dresses.add(new Dress(rset.getString("Vestido"), 
                                      rset.getString("Cor"), 
                                      rset.getString("Tamanho"), 
                                      rset.getString("Modelo"), 
                                      rset.getInt("Quantidade"),  
                                      rset.getString("Valor")));
            }
            
        } catch (Exception e) {
            System.err.println("Got an exception! listClient2"+e);
            System.err.println(e.getMessage());
        } finally {
            conexaobanco.fecharTodasConexoes(conn, stmt, rset);
        }	
        System.out.println(dresses);
        return dresses;
    }
        
    public void listClient() {

        try {
            conn = conexaobanco.getConexaoMySQL();

            String query = "SELECT * FROM tbl_cliente WHERE Status = 1";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);

            while (rset.next()) {
//                cpf.removeAll(cpf);
//                nome.removeAll(nome);
//                rg.removeAll(rg);
//                sexo.removeAll(sexo);
//                dataNascimento.removeAll(dataNascimento);
//                telefone.removeAll(telefone);
//                celular.removeAll(celular);
//                email.removeAll(email);
//                cep.removeAll(cep);
//                uf.removeAll(uf);
//                endereco.removeAll(endereco);
//                bairro.removeAll(bairro);
//                complemento.removeAll(complemento);
                cpf.add(rset.getLong("Cliente_CPF"));
                nome.add(rset.getString("Nome"));
                rg.add(rset.getInt("RG"));
                sexo.add(rset.getString("Sexo"));
                dataNascimento.add(rset.getString("Data_Nascimento"));
                telefone.add(rset.getString("Telefone"));
                celular.add(rset.getString("Celular"));
                email.add(rset.getString("Email"));
                cep.add(rset.getString("Cep"));
                uf.add(rset.getString("Uf"));
                endereco.add(rset.getString("Endereco"));
                bairro.add(rset.getString("Bairro"));
                complemento.add(rset.getString("Complemento"));
            }

        } catch (Exception e) {
            System.err.println("Got an exception! listClient"+e);
            System.err.println(e.getMessage());
        } finally {
            conexaobanco.fecharTodasConexoes(conn, stmt, rset);
        }

    }
    public void listClient2(String nome3) {

        try {
            conn = conexaobanco.getConexaoMySQL();

            String query = "SELECT * FROM tbl_cliente WHERE Status = 1 and Nome=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nome3);
            
            rset = pstmt.executeQuery();
            
            while (rset.next()) {
//                cpf.removeAll(cpf);
//                nome.removeAll(nome);
//                rg.removeAll(rg);
//                sexo.removeAll(sexo);
//                dataNascimento.removeAll(dataNascimento);
//                telefone.removeAll(telefone);
//                celular.removeAll(celular);
//                email.removeAll(email);
//                cep.removeAll(cep);
//                uf.removeAll(uf);
//                endereco.removeAll(endereco);
//                bairro.removeAll(bairro);
//                complemento.removeAll(complemento);
                cpf.add(rset.getLong("Cliente_CPF"));
                nome.add(rset.getString("Nome"));
                rg.add(rset.getInt("RG"));
                sexo.add(rset.getString("Sexo"));
                dataNascimento.add(rset.getString("Data_Nascimento"));
                telefone.add(rset.getString("Telefone"));
                celular.add(rset.getString("Celular"));
                email.add(rset.getString("Email"));
                cep.add(rset.getString("Cep"));
                uf.add(rset.getString("Uf"));
                endereco.add(rset.getString("Endereco"));
                bairro.add(rset.getString("Bairro"));
                complemento.add(rset.getString("Complemento"));
            }

        } catch (Exception e) {
            System.err.println("Got an exception! listClient"+e);
            System.err.println(e.getMessage());
        } finally {
            conexaobanco.fecharTodasConexoes(conn, stmt, rset);
        }

    }
    
    public void listEmployeeData() {

        try {
            conn = conexaobanco.getConexaoMySQL();

            String query = "SELECT * FROM tbl_dadosFuncionario WHERE Status = 1";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);

            while (rset.next()) {
                cpf2.add(rset.getLong("Func_CPF"));
                nome2.add(rset.getString("Nome"));
                rg2.add(rset.getInt("RG"));
                sexo2.add(rset.getString("Sexo"));
                dataNascimento2.add(rset.getString("Data_Nascimento"));
                telefone2.add(rset.getString("Telefone"));
                celular2.add(rset.getString("Celular"));
                email2.add(rset.getString("Email"));
                cep2.add(rset.getString("Cep"));
                uf2.add(rset.getString("Uf"));
                endereco2.add(rset.getString("Endereco"));
                bairro2.add(rset.getString("Bairro"));
                complemento2.add(rset.getString("Complemento"));
            }

        } catch (Exception e) {
            System.err.println("Got an exception! listEmployeeData"+e);
            System.err.println(e.getMessage());
        } finally {
            conexaobanco.fecharTodasConexoes(conn, stmt, rset);
        }

    }
    
    public void listEmployeeValue() {

        try {
            conn = conexaobanco.getConexaoMySQL();

            String query = "SELECT * FROM tbl_administrativoFuncionario";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);

            while (rset.next()) {
                cargo.add(rset.getString("Cargo_Funcionario"));
                salario.add(rset.getString("Salario_Funcionario"));
                admissao.add(rset.getString("Admissao_Data"));
                demissao.add(rset.getString("Demissao_Data"));
                funcCpf.add(rset.getLong("Func_CPF"));

            }

        } catch (Exception e) {
            System.err.println("Got an exception! listEmployeeValue"+e);
            System.err.println(e.getMessage());
        } finally {
            conexaobanco.fecharTodasConexoes(conn, stmt, rset);
        }

    }

    // Getters //
    // Tabela vestido //
    public int getDressSize(){
        return cor.size();
    }
    
    public static String getUserName(){
        return username;
    }

    public static String getUserFoto(){
        return userfoto;
    }
    
    public static Integer getUserNivel(){
        return userNivel;
    }
    
    public List<Integer> getCodVest() {
        return cod_vest;
    }
    
    public  List<String> getVestido() {
        return vestido;
    }

    public List<String> getCor() {
        return cor;
    }

    public List<String> getTamanho() {
        return tamanho;
    }

    public List<String> getModelo() {
        return modelo;
    }

    public List<Integer> getQuantidade() {
        return quantidade;
    }
    
    public List<String> getValor() {
        return valor;
    }
    
    // Tabela cliente //
    public int getClientSize(){
        return cpf.size();
    }
    // Tabela cliente //
    public int getEmployeeSize(){
        return cpf2.size();
    }
    
    public List<Long> getCpf() {
        return cpf;
    }

    public List<String> getNome() {
        return nome;
    }

    public List<Integer> getRg() {
        return rg;
    }

    public List<String> getSexo() {
        return sexo;
    }

    public List<String> getDataNascimento() {
        return dataNascimento;
    }

    public List<String> getTelefone() {
        return telefone;
    }

    public List<String> getCelular() {
        return celular;
    }

    public List<String> getEmail() {
        return email;
    }

    public List<String> getCep() {
        return cep;
    }

    public List<String> getUf() {
        return uf;
    }

    public List<String> getEndereco() {
        return endereco;
    }

    public List<String> getBairro() {
        return bairro;
    }

    public List<String> getComplemento() {
        return complemento;
    }
    
    // tabela funcionario get e set //

    public List<Long> getCpf2() {
        return cpf2;
    }

    public List<String> getNome2() {
        return nome2;
    }

    public List<Integer> getRg2() {
        return rg2;
    }

    public List<String> getSexo2() {
        return sexo2;
    }

    public List<String> getDataNascimento2() {
        return dataNascimento2;
    }

    public List<String> getTelefone2() {
        return telefone2;
    }

    public List<String> getCelular2() {
        return celular2;
    }

    public List<String> getEmail2() {
        return email2;
    }

    public List<String> getCep2() {
        return cep2;
    }

    public List<String> getUf2() {
        return uf2;
    }

    public List<String> getEndereco2() {
        return endereco2;
    }

    public List<String> getBairro2() {
        return bairro2;
    }

    public List<String> getComplemento2() {
        return complemento2;
    }
    // func values //

    public List<String> getCargo() {
        return cargo;
    }

    public List<String> getSalario() {
        return salario;
    }

    public List<String> getAdmissao() {
        return admissao;
    }

    public List<String> getDemissao() {
        return demissao;
    }

    public List<Long> getFuncCpf() {
        return funcCpf;
    }
    
    
    private ConexaoBanco conexaobanco;
    private DataBaseControl databasecontrol;

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rset;

    private static String username;    
    private static String userfoto;    
    private static Integer userNivel;    
    
    // Tabela vestido //
    List<String> vestido = new ArrayList<>();
    List<Integer> cod_vest = new ArrayList<>();
    List<String> cor = new ArrayList<>();  
    List<String> tamanho = new ArrayList<>();  
    List<String> modelo = new ArrayList<>();  
    List<Integer> quantidade = new ArrayList<>();
    List<String> valor = new ArrayList<>();
    
    // Tabela cliente //
    List<Long> cpf = new ArrayList<>(); 
    List<String> nome = new ArrayList<>();  
    List<Integer> rg = new ArrayList<>();  
    List<String> sexo = new ArrayList<>();  
    List<String> dataNascimento = new ArrayList<>();  
    List<String> telefone = new ArrayList<>();  
    List<String> celular = new ArrayList<>();  
    List<String> email = new ArrayList<>();  
    List<String> cep = new ArrayList<>();  
    List<String> uf = new ArrayList<>();  
    List<String> endereco = new ArrayList<>();  
    List<String> bairro = new ArrayList<>();  
    List<String> complemento = new ArrayList<>();  
    
    // Tabela funcionario //
    List<Long> cpf2 = new ArrayList<>(); 
    List<String> nome2 = new ArrayList<>();  
    List<Integer> rg2 = new ArrayList<>();  
    List<String> sexo2 = new ArrayList<>();  
    List<String> dataNascimento2 = new ArrayList<>();  
    List<String> telefone2 = new ArrayList<>();  
    List<String> celular2 = new ArrayList<>();  
    List<String> email2 = new ArrayList<>();  
    List<String> cep2 = new ArrayList<>();  
    List<String> uf2 = new ArrayList<>();  
    List<String> endereco2 = new ArrayList<>();  
    List<String> bairro2 = new ArrayList<>();  
    List<String> complemento2 = new ArrayList<>();  
    
    List<String> cargo = new ArrayList<>();  
    List<String> salario = new ArrayList<>();  
    List<String> admissao = new ArrayList<>();  
    List<String> demissao = new ArrayList<>();  
    List<Long> funcCpf = new ArrayList<>();  
    
    
    
}
