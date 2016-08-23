import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class update_tbl_info extends JFrame{
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
     static final String DATABASE_URL = "jdbc:mysql://localhost/CSE11";
     Connection connection = null; // manages connection
     Statement statement = null; // query statement*/
    
    JPanel jp1;
    JLabel label_roll,label_cgpa,label_msg;
    JTextField field_roll,field_cgpa;
    JButton button_update,button_show_tbl_info,button_exit;
    public update_tbl_info()
    {
        
        // sql_connector a=new sql_connector();
        try
        {
           Class.forName( JDBC_DRIVER ); // load database driver class
           // establish connection to database                              
           connection =(Connection) DriverManager.getConnection( DATABASE_URL, "root", "" );

           // create Statement for querying database
           statement = (Statement) connection.createStatement();
        
        }catch(Exception e){
        e.printStackTrace();}
        
        
        jp1=new JPanel();
        jp1.setLayout(null);
        jp1.setSize(700,700);
        
        label_roll=new JLabel();
        label_cgpa=new JLabel();
        field_roll=new JTextField();
        field_cgpa=new JTextField();
        
        label_msg=new JLabel();
        button_update=new JButton();
        button_show_tbl_info=new JButton();
        button_exit=new JButton();
        
        jp1.add(label_roll);
        jp1.add(label_cgpa);
        jp1.add(field_roll);
         jp1.add(field_cgpa);
        jp1.add(label_msg);
        jp1.add(button_update);
        jp1.add(button_show_tbl_info);
        jp1.add(button_exit);
       
        
        label_roll.setText("Required Roll");
        label_roll.setBounds(20,10,150,50);
        label_roll.setForeground(Color.red);
        
        field_roll.setBounds(20,60,150,50);
        
        label_msg.setBounds(30,200,300,50);
        label_msg.setForeground(Color.BLACK);
        
        label_cgpa.setText("Updated CGPA");
        label_cgpa.setBounds(250,20,100,50);
        label_cgpa.setForeground(Color.BLUE);
        
        field_cgpa.setBounds(250,60,100,50);
        
        
        
        
        button_update.setText("UPDATE");
        button_update.setBounds(400,60,140,50);
        button_update.setBackground(Color.GREEN);
        
        button_show_tbl_info.setText("SHOW");
        button_show_tbl_info.setBackground(Color.CYAN);
        button_show_tbl_info.setBounds(100, 350, 140,50);
        
        button_exit.setText("EXIT");
        button_exit.setBackground(Color.gray);
        button_exit.setBounds(100,450,140,50);
        
        
        button_update.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                             try
                             {
                                 String update_query="update tbl_info set cgpa="+Double.parseDouble(field_cgpa.getText().toString()) +" where Roll= " +Integer.parseInt(field_roll.getText().toString()) + "";
                                 statement.execute(update_query);
                                 
                                 field_roll.setText(null);
                                 field_cgpa.setText(null);

                                 
                                 label_msg.setText("CGPA is updated succesfully");
                             }
                             catch(Exception ex)
                             {
                                 label_msg.setText("Error: Data can't be updated... please check again");
                             }
                            }
                        }); 
        
       button_show_tbl_info.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                             Show obj= new Show();
                            }
                        }); 
        
        button_exit.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                             dispose();
                            }
                        });
        
        setTitle("Update From tbl_info");
        add(jp1);
        setSize(800,800);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public static void main(String args[])
    {
       update_tbl_info obj1=new update_tbl_info();
    }
    
}
