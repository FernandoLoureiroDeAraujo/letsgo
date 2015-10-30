package br.com.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteControl {
    
    private ConexaoBanco conexaobanco;
    private DataBaseControl databasecontrol;

    public DeleteControl(){
            conexaobanco = new ConexaoBanco();
            databasecontrol = new DataBaseControl();
    }
    
    // No deleta os registros apenas altera a visibilidade do mesmo //
    public void clientDelete(String string) throws ExceptionControl{		
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
                int index = 0;

                conn = conexaobanco.getConexaoMySQL();
                stmt = conn.prepareStatement("UPDATE tbl_cliente SET Status = 0 WHERE Cliente_CPF = ?");
                stmt.setString(++index, string);
                stmt.executeUpdate();

        } catch (SQLException e) {
                throw new ExceptionControl("Não foi possivel salvar os dados!", e);
        } finally{
                conexaobanco.fecharTodasConexoes(conn, stmt);
        }
    }
    
    // No deleta os registros apenas altera a visibilidade do mesmo //
    public void employeeDelete(String string) throws ExceptionControl{		
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
                int index = 0;

                conn = conexaobanco.getConexaoMySQL();
                stmt = conn.prepareStatement("UPDATE tbl_dadosFuncionario SET Status = 0 WHERE Func_CPF = ?");
                stmt.setString(++index, string);
                stmt.executeUpdate();

        } catch (SQLException e) {
                throw new ExceptionControl("Não foi possivel salvar os dados!", e);
        } finally{
                conexaobanco.fecharTodasConexoes(conn, stmt);
        }
    }
}
