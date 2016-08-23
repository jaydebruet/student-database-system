import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class show_combined_tblinfo_and_tbl_address extends JFrame{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
     static final String DATABASE_URL = "jdbc:mysql://localhost/CSE11";
     Connection connection = null; // manages connection
     Statement statement = null; // query statement*/
     
    JPanel panel;
    JScrollPane jscp1;
    JButton button_exit;
    JTable tbl=new JTable();
    
    
    public show_combined_tblinfo_and_tbl_address()
    {   
        
        panel=new JPanel();
        panel.setLayout(null);
        panel.setSize(700,700);
        
        //jscp1=new JScrollPane();
        
        button_exit=new JButton("EXIT");
        panel.add(button_exit);
        button_exit.setBounds(350,600,150,50);
        button_exit.setBackground(Color.red);
        
        button_exit.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                             dispose();
                            }
                        });
        
        
      JTable mytable = new JTable();
                        JScrollPane jScrollPane1 = new JScrollPane();
                        mytable.setVisible(true);
                        JLabel jLabel1 = new JLabel();

                        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                        mytable.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][]{
                                    {null, null, null,null},
                                    {null, null, null,null},
                                    
                                },
                                new String[]{
                                    "Roll", "Name","CGPA","address"
                                }));
                        jScrollPane1.setViewportView(mytable);

                        //  jLabel1.setText("my table");
                        add(jLabel1);

                        
                        //Main things of jtable
                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(157, 157, 157).addComponent(jLabel1))).addContainerGap()));
                        layout.setVerticalGroup(
                               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(20, 20, 20).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(46, Short.MAX_VALUE)));



                        try {
                            Class.forName(JDBC_DRIVER);
                            connection = (Connection) DriverManager.getConnection(DATABASE_URL, "root", "");
                            statement = (Statement) connection.createStatement();




                            // create Statement for querying database


                            // query database                                        
                            ResultSet resultSet = statement.executeQuery(
                        "SELECT tbl_info.Roll, Name, cgpa, address FROM tbl_info, tbl_address WHERE tbl_info.Roll = tbl_address.Roll");
                            java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
                            int numberOfColumns = metaData.getColumnCount();
                            DefaultTableModel dtm = new DefaultTableModel();
                            Vector column_name = new Vector();
                            Vector data_rows = new Vector();
                            for (int i = 1; i <= numberOfColumns; i++) {
                                column_name.addElement(metaData.getColumnName(i));
                            }
                            dtm.setColumnIdentifiers(column_name);
                            while (resultSet.next()) {
                                data_rows = new Vector();
                                for (int j = 1; j <= numberOfColumns; j++) {
                                    data_rows.addElement(resultSet.getString(j));
                                }
                                dtm.addRow(data_rows);
                            }
                            mytable.setModel(dtm);
                        } catch (Exception x) {
                            x.printStackTrace();
                        }

                       add(jScrollPane1);



           
           
        
        add(panel);
        setTitle("JOINT TABLE");
        setSize( 800, 800);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

                       
    
    public static void main(String Args[])
    {
        // sql_connector obj=new sql_connector();
       show_combined_tblinfo_and_tbl_address ob= new show_combined_tblinfo_and_tbl_address();
      // obj.setVisible(true);
    }
}
