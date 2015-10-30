package br.com.control;

import br.com.model.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class UpdateControl {

    private ConexaoBanco conexaobanco;
    private DataBaseControl databasecontrol;

    public UpdateControl(){
            conexaobanco = new ConexaoBanco();
            databasecontrol = new DataBaseControl();
    }
    
    // No deleta os registros apenas altera a visibilidade do mesmo //
    public void clientUpdate(String string, Data data) throws ExceptionControl{		
        Connection conn = null;

        try {
                int index = 0;

                conn = conexaobanco.getConexaoMySQL();
                
                String query = ("UPDATE tbl_cliente SET Cliente_CPF = ?, Nome = ?, RG = ?, Sexo = ?, Data_Nascimento = ?, "
                                                     + "Telefone = ?, Celular = ?, Email = ?,"
                                                     + "Cep = ?, UF = ?, Endereco = ?, Bairro = ?, Complemento = ? WHERE Cliente_CPF = ?");

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
                                                       ,string);

        } catch (SQLException e) {
                throw new ExceptionControl("Não foi possivel salvar os dados!", e);
        } finally{
                conexaobanco.fecharConexao(conn);
        }
    }
}
