package br.com.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.control.ConexaoBanco;

public class DataBaseControl {
	
	ConexaoBanco conexaobanco = new ConexaoBanco();
	
	public long executePreparedUpdateAndReturnGeneratedKeys(Connection conn, String query, Object... params) throws SQLException{
		
		int index = 0;
		long result = 01;
		
		PreparedStatement pstmt = null;	
		ResultSet rset = null;
		
		try{
			pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);			
			
			for (Object param : params) {
				pstmt.setObject(++index, param);
			}
			
			pstmt.executeUpdate();
			
			rset =  pstmt.getGeneratedKeys();
		
			if(rset.next()) result = rset.getLong(1);
			
		}finally{
			conexaobanco.fecharConexao(pstmt);
			conexaobanco.fecharConexao(rset);
		}
		
		return result;
	}
	
	public void executePreparedUpdate(Connection conn, String query, Object... params) throws SQLException{
		
		int index = 0;
		
		PreparedStatement pstmt = null;	
		
		try{
			pstmt = conn.prepareStatement(query);			
			
			for (Object param : params) {
				pstmt.setObject(++index, param);
			}
			
			pstmt.executeUpdate();
			
		}finally{
			conexaobanco.fecharConexao(pstmt);
		}
	}
	
	public <T> List<T> executePreparedQuery (String query,QueryMapper<T> mapper) throws SQLException {
			
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		List<T> list = new ArrayList<T>();
		
		try {
			conn =	conexaobanco.getConexaoMySQL();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = mapper.mapping(rset);
		} finally {		
			conexaobanco.fecharTodasConexoes(conn, stmt, rset);
		}
		
		return list;
	
	}
        
	public String executePreparedQuery (String query) throws SQLException {
                String string = "";
            
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			conn =	conexaobanco.getConexaoMySQL();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
		} finally {		
			conexaobanco.fecharTodasConexoes(conn, stmt, rset);
		}
		
		return string;
	
	}
	
}