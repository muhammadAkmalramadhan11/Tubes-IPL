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
        getContentPane().setLayout(null);
		
		getContentPane().add(menu);
		menu.setBounds(0, 11, 424, 90);
		
		getContentPane().add(username);
		username.setBounds(87, 127, 150, 20);
		username.setForeground(Color.white);
		username.setFont(new Font("Rockwell", Font.BOLD, 17));

		getContentPane().add(lpassword);
		lpassword.setBounds(87, 179, 150, 20);
		lpassword.setForeground(Color.white);
		lpassword.setFont(new Font("Rockwell", Font.BOLD, 17));

		getContentPane().add(txtusername);
		txtusername.setBounds(187, 127, 130, 25);
		getContentPane().add(txtpassword);
		txtpassword.setBounds(187, 179, 130, 25);

		getContentPane().add(masuk);
		masuk.setBounds(187, 231, 130, 25);

		getContentPane().setBackground(new Color(13, 55, 73));
		setVisible(true);
    }

    void AksiReaksi () {
        
    }
}
