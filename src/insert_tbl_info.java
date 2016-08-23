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


public class insert_tbl_info extends JFrame {
    
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
     static final String DATABASE_URL = "jdbc:mysql://localhost/CSE11";
     Connection connection = null; // manages connection
     Statement statement = null; // query statement*/
    
    JPanel panel;
    JTextField field_roll,field_cgpa;
    JLabel label_roll,label_cgpa,label_msg;
    JButton button_insert,button_exit;
    
    
    public insert_tbl_info(){
        
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
        
        panel=new JPanel();
        panel.setLayout(null);
        
        
        panel.setSize(700,700);
        label_roll=new JLabel();
        label_cgpa=new JLabel();
        field_roll=new JTextField();
        field_cgpa=new JTextField();
        label_msg=new JLabel();
        button_insert=new JButton("OK");
        button_exit=new JButton("exit");
       
        
        panel.add(label_roll);
        panel.add(label_cgpa);
        panel.add(field_roll);
        panel.add(field_cgpa);
        panel.add(button_insert);
        panel.add(button_exit);
        panel.add(label_msg);
        label_roll.setText("  ROLL");
        label_roll.setBounds(10,0,50,50);
        field_roll.setBounds(10,40,150,50);
        
        
        label_cgpa.setText("   CGPA");
        label_cgpa.setBounds(170,0,150,50);
        field_cgpa.setBounds(170,40, 200,50);
        
        
        
       
        button_insert.setBounds(400, 40, 150, 50);
        button_insert.setBackground(Color.green);
        
        button_exit.setBounds(320,400,150,50);
        button_exit.setBackground(Color.red);
        
        label_msg.setBounds(30, 300, 600, 50);
        
         button_insert.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                
                                 try
                               {
                  String insert="insert into tbl_info values('"+Integer.parseInt(field_roll.getText().toString())+"','"+Double.parseDouble(field_cgpa.getText().toString())+"')";                 
                   statement.execute(insert);
                   field_roll.setText(null);
                   field_cgpa.setText(null);
                   label_msg.setText("Data inserted succesfully");
                   
                               }
                               catch(Exception ex)
                               {
                                   field_roll.setText(null);
                                    field_cgpa.setText(null);
                                   
                                   label_msg.setText("Error:::Data can't be inserted succesfully");
                               }
                            }
         
                            
    });
       
          
        button_exit.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                             dispose();
                            }
                        });
         
        
        add(panel);
        setTitle("Insert in tbl_info");
        setSize( 800, 800);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String args[])
    {
        insert_tbl_info ob=new insert_tbl_info();
    }
}
