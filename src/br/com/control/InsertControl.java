package br.com.control;

import br.com.model.Data;
import br.com.model.Dress;
import br.com.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertControl {
	
    private ConexaoBanco conexaobanco;
    private DataBaseControl databasecontrol;

    public InsertControl(){
            conexaobanco = new ConexaoBanco();
            databasecontrol = new DataBaseControl();
    }

    public void insertLocacao(String string1, Long string2, String string3, String string4, String string5, Double double1){
        Connection conn = null;
        
        try{
        conn = conexaobanco.getConexaoMySQL();

        String query = "INSERT INTO tbl_locacao(Cliente_CPF, Func_CPF, Cod_vest, Locacao_Data, Devolucao_Data, Valor_Total) VALUES (?,?,?,?,?,?)";

        databasecontrol.executePreparedUpdate (conn
                                               ,query 
                                               ,string1
                                               ,string2
                                               ,string3
                                               ,string4
                                               ,string5
                                               ,double1);
                                               
        } catch (SQLException e) {
                throw new ExceptionControl("Não foi possivel salvar os dados!", e);
        } finally{
                conexaobanco.fecharConexao(conn);
        }
    }
    
    public void insertClient(Data data){
        Connection conn = null;
        
        try{
        conn = conexaobanco.getConexaoMySQL();

        String query = "INSERT INTO tbl_cliente (Cliente_CPF, Nome, RG, Sexo, Data_Nascimento, Telefone, Celular, Email, Cep, UF, Endereco, Bairro, Complemento, Status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        databasecontrol.executePreparedUpdate (conn
                                               ,query 
                                               ,data.getCpf()
                                               ,data.getNome()
                                               ,data.getRg()
                                               ,data.getSexo()
                                               ,data.getDatanascimento()
                                               ,data.getTelefone()
                                               ,data.getCelular()
                                               ,data.getEmail()
                                               ,data.getCep()
                                               ,data.getUf()
                                               ,data.getEndereco()
                                               ,data.getBairro()
                                               ,data.getComplemento()
                                               ,data.getStatus());
        } catch (SQLException e) {
                throw new ExceptionControl("Não foi possivel salvar os dados!", e);
        } finally{
                conexaobanco.fecharConexao(conn);
        }
    }
    
    public void insertEmployeeData(Employee employee){
        Connection conn = null;
        
        try{
        conn = conexaobanco.getConexaoMySQL();

        String query = "INSERT INTO tbl_dadosFuncionario (Func_CPF, Senha, Foto, Nome, RG, Sexo, Data_Nascimento, Telefone, Celular, Email, Cep, UF, Endereco, Bairro, Complemento, Nivel, Status)"
                     + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        databasecontrol.executePreparedUpdate (conn
                                               ,query 
                                               ,employee.getCpf()
                                               ,employee.getSenha()
                                               ,employee.getFoto()
                                               ,employee.getNome()
                                               ,employee.getRg()
                                               ,employee.getSexo()
                                               ,employee.getDatanascimento()
                                               ,employee.getTelefone()
                                               ,employee.getCelular()
                                               ,employee.getEmail()
                                               ,employee.getCep()
                                               ,employee.getUf()
                                               ,employee.getEndereco()
                                               ,employee.getBairro()
                                               ,employee.getComplemento()
                                               ,employee.getNivel()
                                               ,employee.getStatus());

        } catch (SQLException e) {
                throw new ExceptionControl("Não foi possivel salvar os dados!", e);
        } finally{
                conexaobanco.fecharConexao(conn);
        }
    }
    
    public void insertEmployeeAdm(Employee employee){
        Connection conn = null;
        
        try{
        conn = conexaobanco.getConexaoMySQL();

        String query = "INSERT INTO tbl_administrativoFuncionario (Cargo_Funcionario, Salario_Funcionario, Admissao_Data, Demissao_Data, Func_CPF)"
                       + "VALUES (?,?,?,?,?)";
        
        databasecontrol.executePreparedUpdate (conn
                                               ,query 
                                               ,employee.getCargo()
                                               ,employee.getSalario()
                                               ,employee.getDataadmissao()
                                               ,employee.getDatademissao()
                                               ,employee.getCpf());
        } catch (SQLException e) {
                throw new ExceptionControl("Não foi possivel salvar os dados!", e);
        } finally{
                conexaobanco.fecharConexao(conn);
        }
    }
    
    public void insertDress(Dress dress) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            conn = conexaobanco.getConexaoMySQL();

            String query = "INSERT INTO tbl_vestido (Vestido, Cor, Tamanho, Modelo, Quantidade, Valor) VALUES (?,?,?,?,?,?)";

            databasecontrol.executePreparedUpdate (conn
                                               ,query 
                                               ,dress.getVestido()
                                               ,dress.getCor()
                                               ,dress.getTamanho()
                                               ,dress.getModelo()
                                               ,dress.getQuantidade()
                                               ,dress.getValor());
  
        } catch (SQLException e) {
                throw new ExceptionControl("Não foi possivel salvar os dados!", e);
        } finally{
                conexaobanco.fecharConexao(conn);
        } 
    }
}