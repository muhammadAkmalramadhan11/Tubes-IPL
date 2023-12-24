import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class login extends JFrame {
	JLabel adduser = new JLabel(new ImageIcon(getClass().getResource("/image/admin1.png")));
	JLabel judul = new JLabel("LOGIN ADMIN");
	JLabel username = new JLabel("Username");
	JLabel tambah = new JLabel("Tambah Admin");
	JLabel lpassword = new JLabel("Password");
	JTextField txtusername = new JTextField();
	JLabel hoveruser = new JLabel(new ImageIcon(getClass().getResource("/image/hoveradmin.png")));
	JPasswordField txtpassword = new JPasswordField();
	JButton masuk = new JButton("Masuk");
	login() {
		setSize(440, 356);
		setTitle("Menu Login Admin Apotek Unjani");
		setLocation(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KomponenVisual();
		AksiReaksi();
	}

	void KomponenVisual() {
		
		getContentPane().add(adduser);
		adduser.setBounds(350, 10, 50, 50);
		adduser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		getContentPane().add(judul);
		judul.setBounds(150, 50, 150, 20);
		judul.setForeground(Color.WHITE);
		judul.setFont(new Font ("Times New Roman", Font.BOLD, 17));
		
		getContentPane().setLayout(null);
		
		getContentPane().add(username);
		username.setBounds(87, 127, 150, 20);
		username.setForeground(Color.white);
		username.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		getContentPane().add(tambah);
		tambah.setBounds(340, 55, 150, 20);  
		tambah.setForeground(Color.white);
		tambah.setFont(new Font("Times New Roman", Font.BOLD, 10)); 


		getContentPane().add(lpassword);
		lpassword.setBounds(87, 179, 150, 20);
		lpassword.setForeground(Color.white);
		lpassword.setFont(new Font("Times New Roman", Font.BOLD, 17));

		getContentPane().add(txtusername);
		txtusername.setBounds(187, 127, 130, 25);
		getContentPane().add(txtpassword);
		txtpassword.setBounds(187, 179, 130, 25);

		getContentPane().add(masuk);
		masuk.setBounds(187, 231, 130, 25);

		getContentPane().setBackground(new Color(100, 100, 120));
		setVisible(true);
	}

	void AksiReaksi() {
		adduser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				adduser.setIcon(new ImageIcon(getClass().getResource("/image/admin1.png")));
				hoveruser.setVisible(true);
			}

			public void mouseExited(MouseEvent e) {
				adduser.setIcon(new ImageIcon(getClass().getResource("/image/admin1.png")));
				hoveruser.setVisible(false);
			}

			public void mouseClicked(MouseEvent e) {
				new AddAdmin();
			}
		});
		masuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent me) {
				try {
					String nama = txtusername.getText();
					String password = txtpassword.getText();

					Class.forName("com.mysql.jdbc.Driver");

					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");

					Statement st = koneksi.createStatement();
					String sql = "select * from admin where Username = '" + nama + "' and Password = '" + password + "'";

					ResultSet rs = st.executeQuery(sql);
					if (rs.next()) {
						if ((rs.getString(1).equals(nama)) && (rs.getString(2).equals(password))) {
							JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "Konfirmasi",
									JOptionPane.INFORMATION_MESSAGE);
						}
						home go = new home(nama); // pemanggilan class lain
						go.KomponenVisual();
						go.AksiReaksi();
						dispose(); // untuk menutup login
					} else if(nama.equals("")||password.equals("")){
						JOptionPane.showMessageDialog(null, "Nama atau Password Masih Kosong", "Konfirmasi",
								JOptionPane.INFORMATION_MESSAGE);
					} else{
						JOptionPane.showMessageDialog(null, "Username atau Password Salah", "Konfirmasi",
								JOptionPane.INFORMATION_MESSAGE);
					}
					st.close();
					koneksi.close();
					txtusername.setText("");
					txtpassword.setText("");
				} catch (Exception ex) {
					System.out.println("Error: " + ex);
				}
			}
		});

	}

	public static void main(String[] args) {
		new login();
		
	}
}
