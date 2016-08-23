
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;


public class sql_connector {
     

        
        public sql_connector()
        {
            /*static final */String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
     //static final 
        String DATABASE_URL = "jdbc:mysql://localhost/gre_vocabulary";
        Connection connection = null; // manages connection
        Statement statement = null; // query statement
            try
        {
           Class.forName( JDBC_DRIVER ); // load database driver class
           // establish connection to database                              
           connection =(Connection) DriverManager.getConnection( DATABASE_URL, "root", "" );

           // create Statement for querying database
           statement = (Statement) connection.createStatement();
        
        }catch(Exception e){
        e.printStackTrace();}
        }
        public static void main(String argS[])
        {
            sql_connector obj=new sql_connector();
        }
       
}
