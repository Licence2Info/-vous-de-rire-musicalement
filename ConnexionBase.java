import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

//import java.util.ArrayList;
//import java.util.List;

public class ConnexionBase {
	private String url="jdbc:mysql://localhost/niveau";
	private String login="root";
	private String password="";
	private Connection cn=null;
	private Statement st = null;
	
	public ConnexionBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		cn= DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException e) {
			//System.err.println("erreur de chargement du driver");
			e.printStackTrace();
		}
 catch (SQLException e) {
	System.err.println("erreur de chargement du driver");
	e.printStackTrace();
}
	}
	public boolean rechercher(String login , String mdp) {
		
		boolean existe = false ;
		
		try {
			 
			Statement statement = cn.createStatement();
			Statement st=cn.createStatement();
			String query = "SELECT * FROM utilisateur where login = '"+login+"' and mdp='"+mdp+"' ";   
			ResultSet res = st.executeQuery(query);
			ResultSetMetaData rsmd = res.getMetaData();
			int nbCols = rsmd.getColumnCount();
			while (res.next()) {
				//On va chercher si l'utilisateur existe dans la base de données
			      existe = true;
			     // System.out.println(enregistre);
			     // System.out.println(res.getString("login") + " ");
			     // System.out.println(res.getString("mdp") + " ");
			      
			  }
			//System.out.println(enregistre);
			res.close();
		
				
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		return existe ;
		
	
	}
	
	public boolean insert(String login, String mdp)
	{
		
		try {
		Statement st=cn.createStatement();
		String s="insert into utilisateur (login,mdp) values ('"+login+"','"+mdp+"')" ;
		
		int res=st.executeUpdate(s);
		if (res==1) 
			return true;
		else 
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
}
	
	
}

/**
 *
 * @author l'uniik touti
 */
