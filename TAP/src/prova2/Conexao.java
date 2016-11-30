package prova2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection conn(){
		Connection conn = null;
		try{
			File f = new File("prova2.sqlite");
				if(f.exists()){
					Class.forName("org.sqlite.JDBC");
					conn = DriverManager.getConnection("jdbc:sqlite:prova2.sqlite");
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		}
}
