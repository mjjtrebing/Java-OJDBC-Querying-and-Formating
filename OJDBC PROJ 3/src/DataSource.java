import java.sql.*;
public class DataSource {
	

	/**
	 * This Constructor establishes a connection to the SQL server named Picard2, and authenticates the sessions with the username and password
	 * 
	 * @throws SQLException
	 */
	public DataSource() throws SQLException{

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String user, pass;
        user = "mtrebing";
        pass = "S0m3th!ng_cOplecks"; //This password is no longer in effect
        try {
        	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2",  user, pass);

        	Reports repo = new Reports(conn);
        	conn.close();//closes connection
        } catch (SQLException e) {e.printStackTrace();}
        
    }
	
}
