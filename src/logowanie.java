import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class logowanie {
	public static JButton btnZaloguj;
	public static String stanowisko = null;
	public static int stanowiskoid = 0;
	public static String imie = null;
	public static String nazwisko = null;
	public static JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logowanie window = new logowanie();
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
	public logowanie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
		    Class.forName("org.postgresql.Driver");
		  } catch (ClassNotFoundException cnfe) {
		    System.out.println("Nie znaleziono sterownika!");
		    System.out.println("Wyduk sledzenia bledu i zakonczenie.");
		    cnfe.printStackTrace();
		    System.exit(1);
		  }
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame();
		frame.setResizable(false);
		
		frame.setBounds(100, 100, 535, 344);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
			ImageIcon image1 = new ImageIcon(getClass().getResource("logo.png"));
			Image img = image1.getImage() ;  
			   Image newimg = img.getScaledInstance( 150, 140,  java.awt.Image.SCALE_SMOOTH ) ;  
			   image1 = new ImageIcon( newimg );
		JLabel lblLab = new JLabel(image1);
		newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
		frame.setIconImage(newimg);
		lblLab.setBounds(29, 77, 151, 141);
		frame.getContentPane().add(lblLab);
		//btnZaloguj.setContentAreaFilled(false);
		JPanel panel = new JPanel();
		panel.setBounds(243, 92, 219, 126);
		panel.setBackground(new Color(0x446e79));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHaslo = new JLabel("Haslo");
		lblHaslo.setBounds(28, 67, 68, 14);
		panel.add(lblHaslo);
		lblHaslo.setForeground(Color.WHITE);
		
		JLabel lblUzytkownik = new JLabel("Uzytkownik");
		lblUzytkownik.setBounds(28, 42, 68, 14);
		panel.add(lblUzytkownik);
		lblUzytkownik.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBounds(106, 39, 107, 20);
		textField.setBackground(new Color(0xe1e1e1));
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(0xe1e1e1));
		passwordField.setBounds(106, 64, 107, 20);
		panel.add(passwordField);
		
		btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String imie_tmp = null;
				String idstanowisko = null;
				String nazwisko_tmp = null;
				Connection c = null;
				try { 
			c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
                    "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
		  } catch (SQLException se) {
		    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
		    se.printStackTrace();
		    System.exit(1);}
				String login = textField.getText();		
				String password = new String(passwordField.getPassword());

				try{
									
											
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery("SELECT p.id_stanowiska, p.imie,p.nazwisko FROM Pracownicy p where p.login =\'"+login+"\' and p.haslo = \'"+password+"\' ;");
						while (rs.next()){       
							 idstanowisko = (rs.getString("id_stanowiska")) ;
					             imie_tmp = (rs.getString("imie")) ;
					             nazwisko_tmp = (rs.getString("nazwisko")) ;
					             
					             if(!idstanowisko.isEmpty()){
					            	 stanowiskoid = Integer.parseInt(idstanowisko);
					            	 imie = imie_tmp;
					            	 nazwisko = nazwisko_tmp;
					            	 break;
					             }
						}
						
					
				}
				catch(SQLException z)  {
					System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
					}	
				if(stanowiskoid == 0){					
					textField.setText("");
					passwordField.setText("");
					btnZaloguj.setEnabled(false);
					errorLog err = new errorLog();
					err.ErrorScreen();
					
				}
				else{
					if(stanowiskoid == 1)
						stanowisko = "Pracownik";
					interfejs wind2 = new interfejs();
				    frame.setVisible(false);
					wind2.InterfaceScreen();
					textField.setText(null);
					passwordField.setText(null);
					
				}	
				
				
			}
		});
		btnZaloguj.setBounds(124, 95, 89, 23);
		panel.add(btnZaloguj);
		btnZaloguj.setBackground(new Color(0xe1e1e1));
		btnZaloguj.setBorderPainted(false);
		btnZaloguj.setFocusPainted(false);
		
		JLabel lblDemoV = new JLabel("Demo v.1");
		lblDemoV.setBounds(473, 290, 83, 14);
		frame.getContentPane().add(lblDemoV);
		
		
		
		///add(picLabel);
	}
}
