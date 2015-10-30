package br.com.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoBanco {
	
	private static String status = "Não Conectou!";

	// Método de Conexão//
	public Connection getConexaoMySQL(){
		
		Connection conn = null; 

		try {	
			
			Class.forName("com.mysql.jdbc.Driver");		
			conn = DriverManager.getConnection("jdbc:mysql://localhost/letsgo", "root", ""); // LOCALHOST //
			//conn = DriverManager.getConnection("jdbc:mysql://br-cdbr-azure-south-a.cloudapp.net/LetsGo", "***", "***"); // AZURE //

			// Testa sua conexão //
			if (conn != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->Não foi possivel realizar conexão");
			}
			
			} catch (ClassNotFoundException e) { // Driver não encontrado //
				System.out.println("O driver expecificado nao foi encontrado.");				
			} catch (SQLException e) { // Não conseguindo se conectar ao banco //
				System.out.println("Nao foi possivel conectar ao Banco de Dados.");				
			}	
		
		return conn;
	}
	
	// Método que retorna o status da sua conexão//
	public String statusConection() {
		return status;
	}
	
	// Método que reinicia a conexão//
	public Connection ReiniciarConexao(Connection conn) throws SQLException {
		fecharConexao(conn);
		return getConexaoMySQL();
	}
	
	// Método que fecha Connection//
	public void fecharConexao(Connection conn) {
		if(conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {} 
	}
	
	// Método que fecha Statement//
	public void fecharConexao(Statement stmt) {
		if(stmt == null)
			return;
		try {
			stmt.close();
		} catch (SQLException e) {}
	}
	
	// Método que fecha ResultSet//
	public void fecharConexao(ResultSet rset) {
		if(rset == null)
			return;
		try {
			rset.close();
		} catch (SQLException e) {} 
	}
	
	// Método que fecha todas as conexões //
	public void fecharTodasConexoes(Connection conn, Statement stmt) {
		fecharConexao(stmt);
		fecharConexao(conn);
	}

	// Método que fecha todas as conexões, tudo mesmo //
	public void fecharTodasConexoes(Connection conn, Statement stmt, ResultSet rset) {
		fecharConexao(rset);
		fecharTodasConexoes(conn, stmt);
	}
}
