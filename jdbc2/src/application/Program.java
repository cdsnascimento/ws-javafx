package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection(); // cria a conexão
			st = conn.createStatement(); // instacia o objeto statement
			rs = st.executeQuery("select * from department"); // executa uma query
			
			while (rs.next()) {
				
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
