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

	JLabel lihatdatabase_jl_ubah = new JLabel();
	JLabel lihatdatabase_jl_hapus = new JLabel();
	JLabel lihatdatabase_jl_cari = new JLabel();
	JLabel titledatabase = new JLabel();
	JLabel Kode_Obat_label = new JLabel("Kode Obat");
	JTextField kode_obat = new JTextField();
	JLabel nama_obat_label = new JLabel("Nama Obat");
	JTextField name = new JTextField();
	JLabel harga_label = new JLabel("Harga");
	JTextField Harga = new JTextField();
	JLabel lihatdatabase_jl_cari2 = new JLabel("Kode_Obat");
	JTextField lihatdatabase_jtf_cari = new JTextField();
	JLabel lihatdatabase_jl_logo = new JLabel();
	JLabel stock_label,ket_label,Exp;
	JTable tabel = new JTable(model);
	JScrollPane pane = new JScrollPane(tabel);
	JDateChooser txtTggl = new com.toedter.calendar.JDateChooser();
	
	private LabelTime waktu;
	private JTextField stok_field;
	private JTextField keterangan;
	AddObat() {
		setLocation(220, 10);
		setSize(833, 689);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Database Tambah Admin");
		KomponenVisual();
		AksiReaksi();
		setLocationRelativeTo(null);
        userInterface();
        setResizable(false);
	}
}