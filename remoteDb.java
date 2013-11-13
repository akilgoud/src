import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class remoteDb {
	
	public static void initDB(String ipaddress, String databasename, String login, String pass) {
	    
		 try { 
			    Class.forName("com.mysql.jdbc.Driver");
					     System.out.println("jdbc:mysql://localhost/pcs");
				             //"jdbc:mysql://" + ipaddress + "/" + databasename, login, pass
					      Connection db = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pcs","root","akil");
					     
					      Statement st= (Statement) db.createStatement();
			                      int newrate=(Integer.parseInt("5")+5)/2;
			                     String vname="C-programming";
								st.executeUpdate("update videocontent set rating="+newrate+" where vname='"+vname+"'");
			                   System.out.print("update videocontent set rating="+newrate+" where vname='"+vname+"'");
			 }
			      
					      
					    catch (Exception e) {
					    	System.out.print("Could not initialize the database.");
					      e.printStackTrace();
					    }
	  }
	public static void main(String args[]){
		initDB("localhost", "enggnotebook","root","akil");
	}
	
}
