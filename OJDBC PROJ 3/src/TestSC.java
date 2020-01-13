import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This whole class is dedicated to trying different select statements before formatting
 * @author MJJT
 *
 */
public class TestSC 
{
	
	public void run() throws SQLException
	{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2",  "mtrebing", "dovahkiin");
		Statement stmt = conn.createStatement (); 
        ResultSet rset = stmt.executeQuery ("select * from Hollywood.movies");
        
        while(rset.next())
        {
        	System.out.print(rset.getString("TITLE"));
        }
		
	}
}
