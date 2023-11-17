import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class stud extends JFrame{
    private JPanel panelMain;
    //    private JTextField txtName;
    private JButton ADDButton;
//    private JTextField txtName;

    public stud() {
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//               JOptionPane.showMessageDialog(ADDButton, "hello anushri");
                String name = textField1.getText();
                String roll = textField2.getText();
                String dep = textField3.getText();
                String sec = textField4.getText();
                int r = Integer.parseInt(roll);
                try{
//                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb");
                    Statement stm =getConnection().createStatement();
                    String sql = "INSERT INTO ST VALUES ('"+name+"','"+r+"','"+dep+"','"+sec+"');";
                    stm.executeUpdate(sql);
                    JOptionPane.showMessageDialog(ADDButton,"done insertion");
                    stm.close();
                }
                catch (Exception k){
                    System.out.println("err");
                }

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String roll = textField2.getText();
                String dep = textField3.getText();
                String sec = textField4.getText();
                int rl = Integer.parseInt(roll);
                try{
//                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb");
                    Statement st =getConnection().createStatement();
                    String sql = "UPDATE ST SET name='"+name+"',dept='"+dep+"',sec='"+sec+"' WHERE roll='"+rl+"';" ;
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(ADDButton,"updated successfully");
                    st.close();
                }
                catch (Exception k){
                    System.out.println("err");
                }

            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = textField1.getText();
                String roll = textField2.getText();
                String dep = textField3.getText();
                String sec = textField4.getText();
                int ro = Integer.parseInt(roll);
                try{
//                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb");
                    Statement sm =getConnection().createStatement();
                    String sql = "DELETE FROM ST WHERE roll='"+ro+"';";
                    sm.executeUpdate(sql);
                    JOptionPane.showMessageDialog(ADDButton,"Deleted successfully");
                    sm.close();
                }
                catch (Exception k){
                    System.out.println("erraa");
                }
            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String s = JOptionPane.showInputDialog(SEARCHButton,"Enter the roll no to search");
                int r = Integer.parseInt(s);
                try
                {
                    Statement stm =getConnection().createStatement();
                    String query = "select * from st  where roll ='"+r+"';";
                    ResultSet rs = stm.executeQuery(query);
                    if(rs.next()==false)
                    {
                        JOptionPane.showMessageDialog(SEARCHButton,"NO record found");
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                    }
                    else
                    {
                        textField1.setText(rs.getString("name"));
                        textField2.setText(rs.getString("roll"));
                        textField3.setText(rs.getString("dept"));
                        textField4.setText(rs.getString("sec"));
                        JOptionPane.showMessageDialog(SEARCHButton,"record found");
                    }
//                    JOptionPane.showMessageDialog(ADDButton,"success");
                    stm.close();
                }catch(Exception y){
                    System.out.println("error in search"+y);
                }
            }
        });

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        getConnection();
        getdata();
        stud obj = new stud();
        obj.setContentPane(obj.panelmain);
        obj.setTitle("Hello");
        obj.setSize(300,400);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static Connection getConnection()
    {
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/mydb";
            String userName = "root";
            String password = "Anu1234$";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseUrl,userName,password);
            System.out.println("connection done");
            return conn;

        }catch(Exception e){
            System.out.println("error");
        }
        return null
                ;
    }
    public static void getdata()
    {
        try{
            Statement statement =getConnection().createStatement();
            ResultSet result=statement.executeQuery("select * from student_info");
            while(result.next())
            {
                System.out.println(result.getString("name"));
            }


        }catch(Exception e)
        {
            System.out.println("Error in mydata"+e);
        }
    }

    private JPanel panelmain;
    private JTextField textField4;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField3;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JButton SEARCHButton;
    private JButton SHOWButton;
    //    private JButton ADDButton;
}