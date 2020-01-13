import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reports {

	public Reports(Connection conn) throws SQLException
	{
		System.out.println("Instructor Details");
		instructorDEETs(conn);
		System.out.println("\n Student Details");
		studDEETS(conn);
		System.out.println("\n Class/Student Details");
		classySTudDEETs(conn);
	}
	
	
	/**
	 * 	
	 * @param var
	 * @throws SQLException
	 */
	private void classySTudDEETs(Connection var) throws SQLException
    {
        Statement stmt = var.createStatement ();
        ResultSet rset = stmt.executeQuery(("Select Student.First, Student.Last, Enroll.Class_Name from Student inner join Enroll on Student.SID = Enroll.SID where Student.SID = Enroll.SID  ORDER BY class_name, Last"));


        while(rset.next())
        {
            System.out.println("Class: " + rset.getString("Class_Name") + "                Student Name: " + rset.getString("First") + rset.getString("Last"));

        }
    }
	
	
	
	
	
	/**
	 * The following code selects the class and Instructor tables and joins them on TID. it then prints out first name, last name, class name, and class count.
	 * @param var
	 * @throws SQLException
	 * 
	 */
	private void instructorDEETs(Connection var) throws SQLException
	{
		Statement stmt = var.createStatement (); 
        ResultSet rset = stmt.executeQuery ("select * from Class inner join Instructor on Class.TID = Instructor.TID");
        
        while(rset.next())
        {
        	System.out.println("Name: " + rset.getString("Fname") + " " + rset.getString("Lname") + "           Class: " + rset.getString("Name") + "            Class count: " + rset.getString("classCount"));
        }
	}
	
	/**
	 * The following code selects the Student and Enroll tables and joins them on SID. It then prints out first name, last name, class name, and experience level of the student.
	 * @param var
	 * @throws SQLException
	 * 
	 */
	private void studDEETS(Connection var) throws SQLException
	{
		Statement stmt = var.createStatement (); 
        ResultSet rset = stmt.executeQuery ("select * from Student inner join Enroll on Student.SID = Enroll.SID");
        
        while(rset.next())
        {
        	System.out.println("Name: " + rset.getString("First") + " " + rset.getString("Last") + "           Class: " + rset.getString("Class_Name") + "           Experience Level: " + rset.getString("Exp_Level"));
        }
	}
	
}
