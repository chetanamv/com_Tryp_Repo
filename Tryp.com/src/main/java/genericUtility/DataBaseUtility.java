package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	public Connection dbConnection(String url, String user, String pass) throws Exception {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		return DriverManager.getConnection(url, user, pass);
	}

	public boolean validateDataEntry(String tname,String cname,String data,String url, String user, String pass) throws Exception {
		
		Connection con = dbConnection(url,user,pass);
		Statement st = con.createStatement();
		return st.execute("select * from "+tname+" where "+cname+"='" + data + "'");
	}

}
