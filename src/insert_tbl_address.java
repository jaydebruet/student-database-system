import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class insert_tbl_address extends JFrame{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
     static final String DATABASE_URL = "jdbc:mysql://localhost/CSE11";
     Connection connection = null; // manages connection
     Statement statement = null; // query statement*/
    
    JPanel panel;
    JTextField field_roll,field_name,field_asdress;
    JLabel label_roll,label_name,label_address,cgpa,label_msg;
    JButton button_insert,button_exit;
    
    
    public insert_tbl_address(){
        
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
        
        
        panel.setSize(900,900);
        label_roll=new JLabel();
        label_name=new JLabel();
        label_address=new JLabel();
        field_roll=new JTextField();
        field_name=new JTextField();
        field_asdress=new JTextField();
        label_msg=new JLabel();
        button_insert=new JButton("OK");
        button_exit=new JButton("exit");
       
        
        panel.add(label_roll);
        panel.add(label_name);
        panel.add(label_address);
        panel.add(field_roll);
        panel.add(field_name);
        panel.add(field_asdress);
        panel.add(button_insert);
        panel.add(button_exit);
        panel.add(label_msg);
        label_roll.setText("  ROLL");
        label_roll.setBounds(50,0,50,50);
        field_roll.setBounds(50,40,150,50);
        
        
        label_name.setText(" NAME ");
        label_name.setBounds(50,100,150,50);
        field_name.setBounds(50,140, 200,50);
        
        label_address.setText(" ADDRESS ");
        label_address.setBounds(50,195,150,50);
        field_asdress.setBounds(50,240,200,150);
        
        button_insert.setBounds(70, 420, 150, 50);
        button_insert.setBackground(Color.green);
        
        button_exit.setBounds(70,530,150,50);
        button_exit.setBackground(Color.red);
        
        label_msg.setBounds(350, 300, 600, 50);
        
         button_insert.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                
                                 try
                               {
                  String insert="insert into tbl_address values('"+Integer.parseInt(field_roll.getText().toString())+"','"+field_name.getText().toString()+"','"+field_asdress.getText().toString()+"')";                 
                   statement.execute(insert);
                   field_roll.setText(null);
                   field_name.setText(null);
                   field_asdress.setText(null);
                   label_msg.setText("Data inserted succesfully");
                   
                               }
                               catch(Exception ex)
                               {
                                   field_roll.setText(null);
                                    field_name.setText(null);
                                      field_asdress.setText(null);
                                   
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
    public static void main(String[] args) {
        // TODO code application logic here
        
      insert_tbl_address obj=new insert_tbl_address();
        
        
    }

}
