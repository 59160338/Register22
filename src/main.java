import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame();
        Register register = new Register();
        frame.setContentPane(register.getMainPanel());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setVisible(true);
    }
}
