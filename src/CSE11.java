import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CSE11 extends JFrame {
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
     static final String DATABASE_URL = "jdbc:mysql://localhost/CSE11";
     Connection connection = null; // manages connection
     Statement statement = null; // query statement*/
    
  
    
    
    JPanel panel;
    JTextField field_roll,field_cgpa;
    JLabel label_roll,label_cgpa,label_msg;
    JButton button_insert,button_delete,button_update,button_show_tbl_info,button_show_tbl_address,button_show_joint_tbl,button_search;
    JButton button_insert_tbl_address;
    
    
    public CSE11()
    {   
        panel=new JPanel();
        panel.setLayout(null);
        
        
        panel.setSize(700,700);
        
        label_msg=new JLabel();
        button_insert=new JButton("INSERT");
        button_show_tbl_info=new JButton();
        button_delete=new JButton();
        button_update=new JButton();
        button_search=new JButton();
        button_show_tbl_address=new JButton();
        button_show_joint_tbl=new JButton();  
        button_insert_tbl_address=new JButton();
        
        panel.add(button_insert);
        panel.add(button_search);
        panel.add(button_show_tbl_info);
        panel.add(label_msg);
        panel.add(button_delete);
        panel.add(button_update);
        panel.add(button_show_tbl_address);
        panel.add(button_show_joint_tbl);
        panel.add(button_insert_tbl_address);
        
        button_insert.setBounds(200,40,150,50);
        button_insert.setBackground(Color.red);
        
        button_search.setText("SEARCH");
        button_search.setBounds(400,40,150,50);
        
        button_delete.setText("DELETE");
        button_delete.setBounds(200,170,150,50);
        button_delete.setBackground(Color.CYAN);
        
        button_update.setText("UPDATE");
        button_update.setBounds(200,300,150,50);
        button_update.setBackground(Color.PINK);
        
        button_show_tbl_info.setText("TABLE_INFO");
        button_show_tbl_info.setBounds(200, 400,170,50);
        button_show_tbl_info.setBackground(Color.green);
        
        button_show_tbl_address.setText("TABLE ADDRESS");
        button_show_tbl_address.setBounds(400, 400,200,50);
        button_show_tbl_address.setBackground(Color.MAGENTA);
        
        button_show_joint_tbl.setText("JOINT TABLE");
        button_show_joint_tbl.setBounds(300,500,200,50);
        button_show_joint_tbl.setBackground(Color.BLACK);
        button_show_joint_tbl.setForeground(Color.gray);
        
        
        label_msg.setBounds(30, 300, 600, 50);
        add(panel);
        
        setTitle("HOME PAGE");
        setBackground(Color.orange);
        setForeground(Color.red);
        setSize( 800, 800);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    
    
   
     button_insert.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            insert_tbl_info ob=new insert_tbl_info();
            }
        }); 
     
      button_search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            search_tbl_info obj=new search_tbl_info();
            }
        }); 
     
     button_delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            delete_tbl_info ob1=new delete_tbl_info();
            }
        });   
     
      button_update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            update_tbl_info ob1=new update_tbl_info();
            }
        });
    
    button_show_tbl_info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               Show obj= new Show();
            }
        }); 
    
    button_show_tbl_address.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               show_tbl_address obj=new show_tbl_address();
            }
        });
    
    button_show_joint_tbl.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               show_combined_tblinfo_and_tbl_address obj=new show_combined_tblinfo_and_tbl_address();
            }
        });
    
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
      CSE11 a=new CSE11();
        
        
    }

}