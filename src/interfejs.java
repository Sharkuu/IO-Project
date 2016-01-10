import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Icon;

public class interfejs {

	private JFrame frame;
	public JButton btnHome;
	public JButton btnNowy;
	public JButton btnNaprawy;
	public JButton btnBazy;
	public JButton btnUsers;
	public JButton btnStat;
	public JButton btnSzukaj;
	public JButton btnSettings;
	public JButton current;

	/**
	 * Launch the application.
	 */
	public void InterfaceScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfejs window = new interfejs();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfejs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(25, 25, 1325, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setBackground(new Color(0xf7f7f7));

		////////////////////panel gorny
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x606060));
		panel.setBounds(10, 11, 1072, 76);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		//////////////info o zalogowaniu
		JLabel zalogowany = new JLabel("Zalogowany jako:");
		zalogowany.setForeground(new Color(0xfdfdfd));
		zalogowany.setBounds(832, 11, 115, 14);
		panel.add(zalogowany);
		JLabel lblImie = new JLabel(logowanie.imie);
		lblImie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImie.setBounds(857, 36, 90, 14);
		lblImie.setForeground(new Color(0xfdfdfd));
		panel.add(lblImie);
		JLabel lblStanowisko = new JLabel(logowanie.stanowisko);
		lblStanowisko.setForeground(new Color(0xfdfdfd));
		lblStanowisko.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStanowisko.setBounds(857, 57, 90, 14);
		panel.add(lblStanowisko);
		/////////////////dodanie loga
		//////////////////pobranie loga
		ImageIcon logo = new ImageIcon(getClass().getResource("logo_biale.png"));
		Image img = logo.getImage() ;  
		Image newimg = img.getScaledInstance( 90, 75,  java.awt.Image.SCALE_SMOOTH ) ;  
		logo = new ImageIcon( newimg );
		JLabel lblLablogo = new JLabel(logo);
		lblLablogo.setBounds(0, 0, 90, 75);
		panel.add(lblLablogo);
		frame.setIconImage(img);
		////////////////////////////wylogowanie button
		ImageIcon wyloguj = new ImageIcon(getClass().getResource("wyloguj.png"));
		JButton btnWyloguj = new JButton(wyloguj);
		btnWyloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logowanie.imie = logowanie.nazwisko = logowanie.stanowisko = null;
				logowanie.stanowiskoid = 0;
				logowanie.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnWyloguj.setBounds(729, 21, 52, 42);
		btnWyloguj.setBorder(BorderFactory.createEmptyBorder());
		btnWyloguj.setContentAreaFilled(false);
		panel.add(btnWyloguj);
		///////////////////ustawienia button
		ImageIcon ustawienia = new ImageIcon(getClass().getResource("ustawienia.png"));
		JButton btnUstawienia = new JButton(ustawienia);
		btnUstawienia.setContentAreaFilled(false);
		btnUstawienia.setBorder(BorderFactory.createEmptyBorder());
		btnUstawienia.setBounds(651, 25, 68, 38);
		panel.add(btnUstawienia);
		///////////////obrazek usera
		ImageIcon user = new ImageIcon(getClass().getResource("user.png"));
		JLabel lblImguser = new JLabel(user);
		lblImguser.setBounds(815, 36, 46, 43);
		panel.add(lblImguser);
		///////////////////////////////panel szybkiego dostepu
		JPanel szybki_dostep = new JPanel();
		szybki_dostep.setBounds(1092, 11, 217, 576);
		szybki_dostep.setBackground(new Color(0x606060));
		frame.getContentPane().add(szybki_dostep);
		szybki_dostep.setLayout(null);
		////////////////////////nazwa panelu
		JLabel label_dostep = new JLabel("Panel szybkiego dostepu");
		label_dostep.setBounds(44, 11, 163, 14);
		label_dostep.setForeground(new Color(0xfdfdfd));
		szybki_dostep.add(label_dostep);
		////////////////przycisk home
		ImageIcon home = new ImageIcon(getClass().getResource("home.png"));
		JButton btnHome = new JButton(home);
		current = btnHome;
		btnHome.setEnabled(false);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			btnHome.setEnabled(false);
			current.setEnabled(true);
			current = btnHome;
				
			}
		});
		btnHome.setBounds(21, 60, 193, 57);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorder(BorderFactory.createEmptyBorder());
		szybki_dostep.add(btnHome);
		///////////////przycisk nowa naprawa
		ImageIcon nowy = new ImageIcon(getClass().getResource("nowy.png"));
		JButton btnNowy = new JButton(nowy);
		btnNowy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				btnNowy.setEnabled(false);
				current.setEnabled(true);
				current = btnNowy;
				
			}
		});
		btnNowy.setBounds(21, 144, 193, 57);
		btnNowy.setContentAreaFilled(false);
		btnNowy.setBorder(BorderFactory.createEmptyBorder());
		szybki_dostep.add(btnNowy);
		/////////////////przycisk naprawy
		ImageIcon naprawy = new ImageIcon(getClass().getResource("naprawy.png"));
		
		JButton btnNaprawy = new JButton(naprawy);
		btnNaprawy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNaprawy.setEnabled(false);
				current.setEnabled(true);
				current = btnNaprawy;
			}
		});
		btnNaprawy.setContentAreaFilled(false);
		btnNaprawy.setBorder(BorderFactory.createEmptyBorder());
		btnNaprawy.setBounds(21, 198, 193, 57);
		szybki_dostep.add(btnNaprawy);
		////////////////////przycisk bazy
		ImageIcon bazy = new ImageIcon(getClass().getResource("bazy.png"));
		JButton btnBazy = new JButton(bazy);
		btnBazy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBazy.setEnabled(false);
				current.setEnabled(true);
				current = btnBazy;
			}
		});
		btnBazy.setContentAreaFilled(false);
		btnBazy.setBorder(BorderFactory.createEmptyBorder());
		btnBazy.setBounds(21, 249, 193, 57);
		szybki_dostep.add(btnBazy);
		////////////////////////////////////przycisk uzytkownicy
		ImageIcon users = new ImageIcon(getClass().getResource("users.png"));
		JButton btnUsers = new JButton(users);
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUsers.setEnabled(false);
				current.setEnabled(true);
				current = btnUsers;
			}
		});
		btnUsers.setContentAreaFilled(false);
		btnUsers.setBorder(BorderFactory.createEmptyBorder());
		btnUsers.setBounds(21, 299, 193, 57);
		szybki_dostep.add(btnUsers);
		
		
		////////////przycisk szukaj
		ImageIcon szukaj = new ImageIcon(getClass().getResource("szukaj.png"));
		JButton btnSzukaj = new JButton(szukaj);
		btnSzukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSzukaj.setEnabled(false);
				current.setEnabled(true);
				current = btnSzukaj;
			}
		});
		btnSzukaj.setContentAreaFilled(false);
		btnSzukaj.setBorder(BorderFactory.createEmptyBorder());
		btnSzukaj.setBounds(21, 349, 193, 57);
		szybki_dostep.add(btnSzukaj);
		
		
		///////////przycisk statystyki
		ImageIcon stat = new ImageIcon(getClass().getResource("stat.png"));
		JButton btnStat = new JButton(stat);
		btnStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStat.setEnabled(false);
				current.setEnabled(true);
				current = btnStat;
			}
		});
		btnStat.setContentAreaFilled(false);
		btnStat.setBorder(BorderFactory.createEmptyBorder());
		btnStat.setBounds(21, 400, 193, 57);
		szybki_dostep.add(btnStat);
		//////////////przyciski settings
		ImageIcon settings = new ImageIcon(getClass().getResource("sett.png"));
		JButton btnSettings = new JButton(settings);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSettings.setEnabled(false);
				current.setEnabled(true);
				current = btnSettings;
			}
		});
		btnSettings.setContentAreaFilled(false);
		btnSettings.setBorder(BorderFactory.createEmptyBorder());
		btnSettings.setBounds(21, 496, 193, 57);
		szybki_dostep.add(btnSettings);
		
		
		
	}
}
