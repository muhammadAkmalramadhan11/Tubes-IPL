import javax.swing.*;
import javax.awt.*;
import javax.awt.event.*;
import javax.sql.*;

class login extends JFrame {
    JLabel username = new JLabel("Username");
    JLabel lpassword = new JLabel("Passowrd");
    JTextField txtusername = new JTextField();
    JPasswordField txtpassword = new JPasswordField();
    JButton masuk = new JButton("Masuk");
    JLabel menu = new JLabel(new ImageIcon(getClass().getResource("/image/Login admin apotek unjani.png")));
    login() {
        setSize(440, 356);
        setTitle("Menu Login Admin Apotek Unjani");
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KomponenVisual();
        AksiReaksi();
    }

    void KomponenVisual() {

    }

    void AksiReaksi () {
        
    }
}