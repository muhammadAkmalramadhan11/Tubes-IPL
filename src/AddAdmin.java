import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;

class AddAdmin extends JFrame {

	JLabel titledatabase = new JLabel(
			new ImageIcon(getClass().getResource("/image/juduladmin.png")));

	JLabel ID_Admin_label = new JLabel("Kode Admin");
	JTextField Kode_Admin = new JTextField();

	JLabel Username_label = new JLabel("Username");
	JTextField name = new JTextField();

	JLabel Password_label = new JLabel("Password");
	
	JLabel kembali = new JLabel(new ImageIcon(getClass().getResource("/image/kembali.png")));
	
	JPasswordField pass = new JPasswordField();

	String[] header = { "Kode Admin", "Username" , "Password" };
	DefaultTableModel model = new DefaultTableModel(null, header);

	JTable tabel = new JTable(model);
	JScrollPane pane = new JScrollPane(tabel);
	private final JLabel lihatdatabase_jl_tambah = new JLabel(new ImageIcon(getClass().getResource("/image/tambah1.jpg")));
	
	private LabelTime waktu;
	AddAdmin() {
		setLocation(220, 10);
		setSize(553, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Database Tambah Admin");
		KomponenVisual();
		AksiReaksi();
		setLocationRelativeTo(null);
        setResizable(false);
	}

	void KomponenVisual() {
		getContentPane().setLayout(null);
		
		// title
		getContentPane().add(titledatabase);
		titledatabase.setBounds(85, 25, 400, 79);

		// kode obat
		getContentPane().add(ID_Admin_label);
		ID_Admin_label.setBounds(30, 150, 100, 20);
		ID_Admin_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		ID_Admin_label.setForeground(Color.WHITE);
		Kode_Admin.setEditable(false);
		
		
		
		getContentPane().add(Kode_Admin);
		Kode_Admin.setBounds(150, 145, 250, 30);

		// merk
		getContentPane().add(Username_label);
		Username_label.setBounds(30, 190, 100, 20);
		Username_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		Username_label.setForeground(Color.WHITE);

		getContentPane().add(name);
		name.setBounds(150, 185, 250, 30);

		// kategori
		getContentPane().add(Password_label);
		Password_label.setBounds(30, 230, 100, 20);
		Password_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		Password_label.setForeground(Color.WHITE);

		getContentPane().add(pass);
		pass.setBounds(150, 226, 250, 30);
		
		getContentPane().add(kembali);
		kembali.setBounds(0, 10, 90, 25);
		kembali.setCursor(new Cursor(Cursor.HAND_CURSOR));

		getContentPane().setBackground(new Color(100, 100, 120));
		lihatdatabase_jl_tambah.setBounds(220, 287, 126, 30);
		
		getContentPane().add(lihatdatabase_jl_tambah);
		tampilTabel();
		setVisible(true);
	}
	private void userInterface(){
        waktu = new LabelTime();
        waktu.setForeground(Color.WHITE);
        waktu.setSize(200, 100);
        waktu.setLocation(800, 551);
        waktu.setFont(new Font("Arial", Font.BOLD, 24));
        waktu.setHorizontalAlignment(LabelTime.RIGHT);
        
        getContentPane().add(waktu);
		waktu.setBounds(220, 80, 300, 40);
    }
	
	void AksiReaksi() {
		kembali.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new login();
				dispose();
			}
		});
				
		lihatdatabase_jl_tambah.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection koneksi = DriverManager.getConnection ("jdbc:mysql://localhost/apkapotek","root","");
					Kode_Admin.setText("ADM00"+nomor());
					String sql = "INSERT INTO admin VALUES(?,?,?)";
					PreparedStatement pr = koneksi.prepareStatement(sql);
					pr.setString(1, Kode_Admin.getText());
					pr.setString(2, name.getText());
					pr.setString(3, pass.getText());
					pr.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data berhasil disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					Kode_Admin.setText("");
					name.setText("");
					pass.setText("");
					tampilTabel();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Data gagal disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex);
				}
			} 
			@Override
			public void mouseEntered(MouseEvent e) {
				Kode_Admin.setText("ADM00"+nomor());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Kode_Admin.setText("");
			}
		});
		
	}

	

	void tampilTabel() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
			Statement state = koneksi.createStatement();
			String sql = "SELECT * FROM admin ORDER BY ID_Admin ASC";
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				Object obj[] = new Object[3];
				obj[0] = rs.getString(1);
				obj[1] = rs.getString(2);
				obj[2] = rs.getString(3);
				model.addRow(obj);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	int nomor() {
		int row = model.getRowCount()+1;
		return row;
	}

	public static void main(String args[]) {
		new AddAdmin();
	}
}