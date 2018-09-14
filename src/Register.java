import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Register {
    private JTextField UsernameTxt;
    private JTextField PasswordTxt;
    private JTextField RePasswordTxt;
    private JTextField EmailTxt;
    private JButton RegisterButton;
    private JButton clearButton;
    private JPanel Registerpanel;
    private JTextField Username;
    private JPasswordField passwordField1;
    private JPasswordField RepassField;
    private JPasswordField PepasswordField2;
    private JPasswordField PasswordField;
    private JPasswordField RePasswordField;


    public Register() throws SQLException {
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement pst;

                if (UsernameTxt.getText().equals("") || EmailTxt.getText().equals("") ||
                        new String(PasswordField.getPassword()).equals("") ||
                        new String(passwordField1.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบ !");
                } else {
                    if (new String(PasswordField.getPassword()).equals(new String(passwordField1.getPassword()))) {


                        try {
                            String serverName = "sql12.freemysqlhosting.net";
                            String mydatabase = "sql12255832";
                            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
                            String username = "sql12255832";
                            String password = "VqusRaY3qH";
                            Connection connection = DriverManager.getConnection(url, username, password);
                            connection.createStatement();
                            //เช็คว่ามี user นี้หรือยัง
                            String CheckUser = UsernameTxt.getText();
                            String sql = "SELECT User_Name FROM sql12255832.User where User_Name=?";
                            pst = connection.prepareStatement(sql);
                            pst.setString(1, CheckUser);
                            ResultSet rs = pst.executeQuery();

///

                            boolean russ = rs.next();
                            if (russ == true) {
                                JOptionPane.showMessageDialog(null, "มี User ซ้ำ");
                            } else {
                                InsertUser();
                            }


                        } catch (Exception String) {
                            JOptionPane.showMessageDialog(null, e);

                        }


                    } else {
                        JOptionPane.showMessageDialog(null, "รหัสผ่านไม่ตรงกัน");

                    }
                }


            }
        });



    }

    public void InsertUser() {
        PreparedStatement pst;
        try {
            String serverName = "sql12.freemysqlhosting.net";
            String mydatabase = "sql12255832";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "sql12255832";
            String password = "VqusRaY3qH";
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.createStatement();

            String sql = "Insert into User(User_Name, User_Email, User_Password) values (?,?,?)";

            pst = connection.prepareStatement(sql);
            pst.setString(1, Username.getText());
            pst.setString(2, EmailTxt.getText());
            pst.setString(3, new String(PasswordField.getPassword()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "กรอกข้อมูลสำเห็จ");
            Username.setText("");
            PasswordField.setText("");
            passwordField1.setText("");
            EmailTxt.setText("");
        } catch (Exception String) {

        }

    }
    public JPanel getMainPanel () { return Registerpanel;}
}

