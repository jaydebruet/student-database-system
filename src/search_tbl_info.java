import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class search_tbl_info extends JFrame{
    
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
     static final String DATABASE_URL = "jdbc:mysql://localhost/CSE11";
     Connection connection = null; // manages connection
     Statement statement = null; // query statement*/
     ResultSet res;
     JPanel jp;
     JLabel label_search_roll,label_search_cgpa;
     JTextField field_seacrh_roll;
     JButton button_find,button_exit,button_show;
     JOptionPane jopane;
     public search_tbl_info()
     {
        // sql_connector obj=new sql_connector();
         try
        {
           Class.forName( JDBC_DRIVER ); // load database driver class
           // establish connection to database                              
           connection =(Connection) DriverManager.getConnection( DATABASE_URL, "root", "" );

           // create Statement for querying database
           statement = (Statement) connection.createStatement();
        
        }catch(Exception e){
        e.printStackTrace();}
         
         jp=new JPanel();
         jp.setLayout(null);
         jp.setSize(500,500);
         
         label_search_roll=new JLabel();
         field_seacrh_roll=new JTextField();
         button_find=new JButton();
         button_exit=new JButton();
         
         jp.add(label_search_roll);
         jp.add(field_seacrh_roll);
         jp.add(button_find);
         jp.add(button_exit);
         
         
         label_search_roll.setText("Enter Your Roll");
         label_search_roll.setBounds(10,20,200,40);
         label_search_roll.setForeground(Color.BLUE);
         
         field_seacrh_roll.setBounds(10,70,170,30);
         
         button_find.setText("SEARCH");
         button_find.setForeground(Color.black);
         button_find.setBackground(Color.PINK);
         button_find.setBounds(120,180,120,30);
         
         button_exit.setText("EXIT");
         button_exit.setForeground(Color.BLUE);
         button_exit.setBackground(Color.YELLOW);
         button_exit.setBounds(120,250,120,30);
         
         button_find.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  res =statement.executeQuery("SELECT Roll, CGPA FROM  `tbl_info` WHERE roll="+Integer.parseInt(field_seacrh_roll.getText().toString()) +"");
                 //statement.execute(query);
                  String m=" ";
                  String l=" ";
                  while(res.next())
                  {
                      l=l+"Roll"+res.getString(1);
                      m=m+ "CGPA :" +res.getString(2);
                              
                  }
                 field_seacrh_roll.setText(null);
                 if(l==" ")
                 {
                    JOptionPane.showMessageDialog(null, "Not Found"); 
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null," "+l+ "  "+m);
                
                 }
                 
                }
                catch(Exception ex)
                {
                  JOptionPane.showMessageDialog(null, "Enter Valid Data");  
                  field_seacrh_roll.setText(null);
                }
                
            }
        });
         
         button_exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
         });
            
         
         add(jp);
         setTitle("search in tbl_info");
         setBounds(0,0, 500, 500);
         setVisible(true);
         
     }
    public static void main(String args[])
    {
       search_tbl_info obj=new search_tbl_info();
       
    }
}
