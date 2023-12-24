import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

import com.toedter.calendar.JDateChooser;

import java.util.Date;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

class AddObat extends JFrame {

	JLabel lihatdatabase_jl_ubah = new JLabel(new ImageIcon(getClass().getResource("/image/change.jpg")));
	JLabel lihatdatabase_jl_hapus = new JLabel(new ImageIcon(getClass().getResource("/image/delete.png")));
	JLabel lihatdatabase_jl_cari = new JLabel(new ImageIcon(getClass().getResource("/image/cariadmin.png")));
	JLabel kembali = new JLabel(new ImageIcon(getClass().getResource("/image/kembali.png")));
	JLabel Kode_Obat_label = new JLabel("Kode Obat");
	JTextField kode_obat = new JTextField();

	JLabel nama_obat_label = new JLabel("Nama Obat");
	JTextField name = new JTextField();

	JLabel harga_label = new JLabel("Harga");
	
	JTextField Harga = new JTextField();

	JLabel lihatdatabase_jl_cari2 = new JLabel("Kode_Obat");
	JTextField lihatdatabase_jtf_cari = new JTextField();

	JLabel lihatdatabase_jl_logo = new JLabel(
			new ImageIcon(getClass().getResource("/image/tambahobt.jpg")));
	
	String[] header = { "Kode Obat", "Nama Obat" , "Harga", "Stok","Keterangan","Exp_Date" };
	DefaultTableModel model = new DefaultTableModel(null, header);
	JLabel stock_label,ket_label,Exp;
	JTable tabel = new JTable(model);
	JScrollPane pane = new JScrollPane(tabel);
	JDateChooser txtTggl = new com.toedter.calendar.JDateChooser();
	
	private final JLabel lihatdatabase_jl_tambah = new JLabel(new ImageIcon(getClass().getResource("/image/add.jpg")));
	private final JLabel lihatdatabase_jl_bersih = new JLabel(new ImageIcon(getClass().getResource("/image/clear.png")));
	private LabelTime waktu;
	private JTextField stok_field;
	private JTextField keterangan;
	
	AddObat() {
		setLocation(350, 50);
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Tambah Obat");
        KomponenVisual();
        AksiReaksi();
	}

	void KomponenVisual() {
		getContentPane().setLayout(null);
		// logo
		getContentPane().add(lihatdatabase_jl_logo);
		lihatdatabase_jl_logo.setBounds(150, 30, 222, 90);
		
		// kembali
        getContentPane().add(kembali);
        kembali.setBounds(5, 2, 100, 100);
		
		// tabel
		getContentPane().add(pane);
		pane.setBounds(450, 185, 700, 190);

		// kode obat
		getContentPane().add(Kode_Obat_label);
		Kode_Obat_label.setBounds(30, 150, 100, 20);
		Kode_Obat_label.setForeground(Color.black);
		kode_obat.setEditable(false);
		
		getContentPane().add(kode_obat);
		kode_obat.setBounds(150, 145, 250, 20);

		// nama obat
		getContentPane().add(nama_obat_label);
		nama_obat_label.setBounds(30, 190, 100, 20);
		nama_obat_label.setForeground(Color.black);

		getContentPane().add(name);
		name.setBounds(150, 185, 250, 20);

		// harga
		getContentPane().add(harga_label);
		harga_label.setBounds(30, 230, 100, 20);
		harga_label.setForeground(Color.black);

		getContentPane().add(Harga);
		Harga.setBounds(150, 225, 250, 20);
		
		//tombol tambah
		lihatdatabase_jl_tambah.setBounds(30, 400, 115, 33);
		
		// tombol ubah
		getContentPane().add(lihatdatabase_jl_ubah);
		lihatdatabase_jl_ubah.setBounds(150, 400, 115, 33);

		// tombol hapus
		getContentPane().add(lihatdatabase_jl_hapus);
		lihatdatabase_jl_hapus.setBounds(290, 400, 115, 33);
		
		//tombol bersih
		getContentPane().add(lihatdatabase_jl_bersih);
		lihatdatabase_jl_bersih.setBounds(420, 400, 115, 33);
		
		// label cari
		getContentPane().add(lihatdatabase_jl_cari2);
		lihatdatabase_jl_cari2.setBounds(500, 140, 150, 20);
		lihatdatabase_jl_cari2.setForeground(Color.black);
		
		getContentPane().add(lihatdatabase_jtf_cari);
		lihatdatabase_jtf_cari.setBounds(600, 140, 130, 20);
		
		// tombol cari
		getContentPane().add(lihatdatabase_jl_cari);
		lihatdatabase_jl_cari.setBounds(740, 140, 126, 20);

		// bg
		getContentPane().setBackground(new Color(100, 100, 120));
		
		// stok obat
		stock_label = new JLabel("Stok");
		stock_label.setForeground(Color.black);
		stock_label.setBounds(30, 270, 100, 20);
		getContentPane().add(stock_label);
		
		stok_field = new JTextField();
		stok_field.setBounds(150, 265, 250, 20);
		getContentPane().add(stok_field);
		
		// keterangan obat
		ket_label = new JLabel("Keterangan");
		ket_label.setForeground(Color.black);
		ket_label.setBounds(30, 310, 100, 20);
		getContentPane().add(ket_label);
		
		keterangan = new JTextField();
		keterangan.setBounds(150, 305, 250, 20);
		getContentPane().add(keterangan);
		
		// exp_date
		Exp = new JLabel("Exp_Date");
		Exp.setForeground(Color.black);
		Exp.setBounds(30, 350, 100, 20);
		getContentPane().add(Exp);
		getContentPane().add(lihatdatabase_jl_tambah);
		tampilTabel();
		setVisible(true);
		
		txtTggl.setBounds(150,345,250,20);
		getContentPane().add(txtTggl);
	}
	private void userInterface(){
        waktu = new LabelTime();
        waktu.setForeground(Color.black);
        waktu.setSize(200, 100);
        waktu.setLocation(800, 551);
        waktu.setHorizontalAlignment(LabelTime.RIGHT);
        
        getContentPane().add(waktu);
		waktu.setBounds(470, 80, 300, 40);		
		
    }
	
	void AksiReaksi() {
        kembali.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new home("").setVisible(true);
            }
        });
	lihatdatabase_jl_tambah.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection koneksi = DriverManager.getConnection ("jdbc:mysql://localhost/apkapotek","root","");
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				kode_obat.setText("OBT0"+nomor());
				String sql = "INSERT INTO db_obat VALUES(?,?,?,?,?,?)";
				PreparedStatement pr = koneksi.prepareStatement(sql);
				pr.setString(1, kode_obat.getText());
				pr.setString(2, name.getText());
				pr.setString(3, Harga.getText());
				pr.setString(4, stok_field.getText());
				pr.setString(5, keterangan.getText());
				pr.setString(6, date.format(txtTggl.getDate()));
				pr.executeUpdate();
				JOptionPane.showMessageDialog(null,"Data berhasil disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
				kode_obat.setText("");
				name.setText("");
				Harga.setText("");
				stok_field.setText("");
				keterangan.setText("");
				txtTggl.setDate(null);
				tampilTabel();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Data gagal disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(ex);
			}
		} 
		@Override
		public void mouseEntered(MouseEvent e) {
			kode_obat.setText("OBT0"+nomor());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			kode_obat.setText("");
		}
	});
		
		lihatdatabase_jl_hapus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String kodeobat = kode_obat.getText();
				int tanya = JOptionPane.showConfirmDialog(null,
						"Apakah Anda ingin Menghapus Data dengan kode barang " + kodeobat + " ?", "Konfirmasi",
						JOptionPane.YES_NO_OPTION);
				if (tanya == 0) {
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root","");
						String sql = "DELETE FROM db_obat WHERE ID_Obat=?";
						PreparedStatement pr = koneksi.prepareStatement(sql);
						pr.setString(1, kodeobat);
						pr.executeUpdate();
						pr.close();

						koneksi.close();
						JOptionPane.showMessageDialog(null, "Data telah dihapus");
						bersih();
						tampilTabel();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error :" + ex, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		lihatdatabase_jl_ubah.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
					String sql = "UPDATE db_obat SET ID_Obat='"+kode_obat.getText()+"',NamaObat='"+name.getText()+"',Harga='"+Harga.getText()+"',Stok='"+stok_field.getText()+"',Keterangan='"+keterangan.getText()+"'WHERE ID_Obat='"+kode_obat.getText()+"'";
					PreparedStatement pr = koneksi.prepareStatement(sql);
				
					pr.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan",JOptionPane.INFORMATION_MESSAGE);
					bersih();
					tampilTabel();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Pesan",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex);
				}
			}
		});
		lihatdatabase_jl_bersih.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
	            bersih();
	            tampilTabel();
			}
	    });
		lihatdatabase_jl_cari.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == lihatdatabase_jl_cari) {
					try {
						String kb = lihatdatabase_jtf_cari.getText();
						Class.forName("com.mysql.jdbc.Driver");
						Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root","");
						kode_obat.setText("");
						Statement st = koneksi.createStatement();
						String sql = "SELECT * from db_obat WHERE ID_Obat LIKE '" + kb + "'";
						ResultSet rs = st.executeQuery(sql);
						if (rs.next()) {
							kode_obat.setText(rs.getString(1));
							name.setText(rs.getString(2));
							Harga.setText(rs.getString(3));
							stok_field.setText(rs.getString(4));
							keterangan.setText(rs.getString(5));
							txtTggl.setDate(rs.getDate(6));
							tampilTabel();
						} else {
							JOptionPane.showMessageDialog(null, "Data yang anda cari tidak ada", "Konfirmasi",
									JOptionPane.INFORMATION_MESSAGE);
						}
						st.close();
						koneksi.close();
					} catch (Exception ex) {
						System.out.println("Error :" + ex);
					}
				}
			}
		});

	}

	void bersih() {
		kode_obat.setText("");
		name.setText("");
		Harga.setText("");
		stok_field.setText("");
		keterangan.setText("");
		txtTggl.setDate(null);
		lihatdatabase_jtf_cari.setText("");
	}

	void tampilTabel() {
		hapusTabel();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
			Statement state = koneksi.createStatement();
			String sql = "SELECT * FROM db_obat ORDER BY ID_Obat ASC";
			ResultSet rs = state.executeQuery(sql);

			while (rs.next()) {
				Object obj[] = new Object[6];
				obj[0] = rs.getString(1);
				obj[1] = rs.getString(2);
				obj[2] = rs.getString(3);
				obj[3] = rs.getString(4);
				obj[4] = rs.getString(5);
				obj[5] = rs.getString(6);
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

	void hapusTabel() {
		int row = model.getRowCount();
		for (int i = 0; i < row; i++) {
			model.removeRow(0);
		}
	}

	public static void main(String args[]) {
		new AddObat();
	}
}