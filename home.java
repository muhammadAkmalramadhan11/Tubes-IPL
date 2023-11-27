import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

class home extends JFrame {

	JLabel adduser = new JLabel(new ImageIcon(getClass().getResource("/image/menuadmin.png")));
	JLabel addobat = new JLabel(new ImageIcon(getClass().getResource("/image/addobat.png")));
	JLabel kasir = new JLabel(new ImageIcon(getClass().getResource("/image/kasir.png")));
	JLabel hoveruser = new JLabel(new ImageIcon(getClass().getResource("/image/hoveradmin.png")));
	JLabel dbobat_hover = new JLabel(new ImageIcon(getClass().getResource("/image/hoverobat.png")));
	JLabel kasir_hover = new JLabel(new ImageIcon(getClass().getResource("/image/hoverkasir.png")));

	JLabel home_jl_keluar = new JLabel(new ImageIcon(getClass().getResource("/image/logout.png")));
	private final JLabel Menu = new JLabel("");
	private LabelTime waktu;
	home(String nama) {
		setLocation(120, 50);
		setSize(1100, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menu Admin Apotek Unjani");
		JOptionPane.showMessageDialog(null, "Login Berhasil", "Konfirmasi",JOptionPane.INFORMATION_MESSAGE);
		KomponenVisual();
		AksiReaksi();
		JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "Konfirmasi",
		JOptionPane.INFORMATION_MESSAGE);
        setLocationRelativeTo(null);
        userInterface();
		setResizable(false);

	}