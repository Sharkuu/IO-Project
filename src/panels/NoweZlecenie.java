package panels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NoweZlecenie extends JPanel {
	private JTextField textNazwa;
	private JTextField txtImie;
	private JTextField txtNazwisko;
	private JTextField txtAdres;
	private JTextField txtMail;
	private JTextField txtKontakt;
	private JTextField txtPlytaglowna;
	private JTextField txtProcesor;
	private JTextField txtKartagraficzna;
	private JTextField txtBateria;
	private JTextField txtHdd;
	private JTextField txtDataUsterki;
	private JTextField txtProducent;
	private JTextField txtMatryca;
	private JTextField textField;
	public ArrayList<String> pracownicyImiona = new ArrayList<>();
	public ArrayList<String> klienciImiona = new ArrayList<>();
	public ArrayList<String> rodzajSprz = new ArrayList<>();
	public ArrayList<String> sprzetModele = new ArrayList<>();
	final private String pauzy = "---";
	private JTextField txtNazwaUsterki;
	/**
	 * Create the panel.
	 */
	public NoweZlecenie() {
		
		setBackground(new Color(0xf7f7f7));
		setBounds(0,0, 1072, 502);
		setLayout(null);
		
		JLabel lblDodaj = new JLabel("Dodaj nowe zlecenie");
		lblDodaj.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDodaj.setBounds(40, 6, 167, 25);
		add(lblDodaj);
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		lblNazwa.setBounds(40, 53, 98, 14);
		add(lblNazwa);
		
		JLabel lblSerwisant = new JLabel("Serwisant:");
		lblSerwisant.setBounds(40, 78, 98, 14);
		add(lblSerwisant);
		
		textNazwa = new JTextField();
		textNazwa.setBounds(167, 50, 116, 20);
		add(textNazwa);
		textNazwa.setColumns(10);
		pracownicyImiona.add(pauzy);
		klienciImiona.add(pauzy);
		JComboBox comboBoxSerwisant = new JComboBox();
		comboBoxSerwisant.setMaximumRowCount(5);
		comboBoxSerwisant.setBounds(167, 75, 116, 20);
		add(comboBoxSerwisant);
		Connection c = null;
		try { 
	c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
  } catch (SQLException se) {
    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
    se.printStackTrace();
    System.exit(1);}
		
		try{
							
									
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("SELECT  p.imie,p.nazwisko FROM Pracownicy p ;");
				while (rs.next()){       
					
			           String  imie_tmp = (rs.getString("imie")) ;
			           String  nazwisko_tmp = (rs.getString("nazwisko")) ;
			             pracownicyImiona.add(imie_tmp+" "+nazwisko_tmp);
			             }
				
				st.close();
			c.close();
		}
		catch(SQLException z)  {
			System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
			}
		for (int i =0;i<pracownicyImiona.size();i++)
			comboBoxSerwisant.addItem(pracownicyImiona.get(i));
		JLabel lblDaneKlienta = new JLabel("Dane klienta");
		lblDaneKlienta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDaneKlienta.setBounds(40, 192, 98, 14);
		add(lblDaneKlienta);
		
		JLabel lblWyszukaj = new JLabel("Wyszukaj klienta z bazy:");
		lblWyszukaj.setBounds(40, 217, 243, 14);
		add(lblWyszukaj);
		
		JComboBox comboBoxWyszukaj = new JComboBox();	
		comboBoxWyszukaj.setMaximumRowCount(5);
			
			
		comboBoxWyszukaj.setBounds(40, 242, 243, 20);
		add(comboBoxWyszukaj);
		try { 
			c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
		            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
		  } catch (SQLException se) {
		    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
		    se.printStackTrace();
		    System.exit(1);}
				
				try{
									
											
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery("SELECT  p.imie,p.nazwisko FROM Klienci p ;");
						while (rs.next()){       
							
					           String  imie_tmp = (rs.getString("imie")) ;
					           String  nazwisko_tmp = (rs.getString("nazwisko")) ;
					             klienciImiona.add(imie_tmp+" "+nazwisko_tmp);
					             }
						st.close();
						c.close();
					
				}
				catch(SQLException z)  {
					System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
					}
				for (int i =0;i<klienciImiona.size();i++)
					comboBoxWyszukaj.addItem(klienciImiona.get(i));
				
				
				
		
		JLabel lblRecznie = new JLabel("lub wpisz rêcznie wszystkie dane:");
		lblRecznie.setBounds(40, 273, 243, 14);
		add(lblRecznie);
		
		JLabel lblNrklienta = new JLabel("Nr klienta:");
		lblNrklienta.setBounds(40, 298, 98, 14);
		add(lblNrklienta);
		
		JLabel lblImie = new JLabel("Imiê:");
		lblImie.setBounds(40, 328, 137, 14);
		add(lblImie);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(40, 358, 98, 14);
		add(lblNazwisko);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(40, 388, 98, 14);
		add(lblAdres);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(40, 418, 98, 14);
		add(lblMail);
		
		JLabel lblKontakt = new JLabel("Kontakt:");
		lblKontakt.setBounds(40, 448, 98, 14);
		add(lblKontakt);
		
		txtImie = new JTextField();
		txtImie.setText("");
		txtImie.setBounds(167, 328, 116, 20);
		add(txtImie);
		txtImie.setColumns(10);
		
		txtNazwisko = new JTextField();
		txtNazwisko.setText("");
		txtNazwisko.setBounds(167, 358, 116, 20);
		add(txtNazwisko);
		txtNazwisko.setColumns(10);
		
		txtAdres = new JTextField();
		txtAdres.setText("");
		txtAdres.setBounds(167, 388, 116, 20);
		add(txtAdres);
		txtAdres.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setText("");
		txtMail.setBounds(167, 418, 116, 20);
		add(txtMail);
		txtMail.setColumns(10);
		
		txtKontakt = new JTextField();
		txtKontakt.setText("");
		txtKontakt.setBounds(167, 448, 116, 20);
		add(txtKontakt);
		txtKontakt.setColumns(10);
		
		JLabel lblUrzadzenieinfo = new JLabel("Urzadzenie:");
		lblUrzadzenieinfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUrzadzenieinfo.setBounds(386, 11, 103, 14);
		add(lblUrzadzenieinfo);
		
		JLabel lblRodzajurzadzenia = new JLabel("Rodzaj urzadzenia: ");
		lblRodzajurzadzenia.setBounds(386, 53, 116, 14);
		add(lblRodzajurzadzenia);
		rodzajSprz.add(pauzy);
		JComboBox comboBoxRodzajUrz = new JComboBox();
		comboBoxRodzajUrz.setMaximumRowCount(5);
		try { 
			c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
		            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
		  } catch (SQLException se) {
		    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
		    se.printStackTrace();
		    System.exit(1);}
				
				try{
									
											
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery("SELECT  s.nazwa FROM RodzajSprzetu s ;");
						while (rs.next()){       
							
					           String  rodzaj_tmp = (rs.getString("nazwa")) ;
					           //String  rodzajID_tmp = (rs.getString("id_rodzaj")) ;
					             rodzajSprz.add(rodzaj_tmp /*+" "+ rodzajID_tmp*/);
					            
					             }
						st.close();
						c.close();
					
				}
				catch(SQLException z)  {
					System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
					}
				for (int i =0;i<rodzajSprz.size();i++){
					/*String rodzajNazwa = rodzajSprz.get(i);
					int index =rodzajNazwa.indexOf(" ");
					String rodzajID = imie.substring(index+1);
					imie =imie.substring(0, index);*/
					comboBoxRodzajUrz.addItem(rodzajSprz.get(i));
				}
		comboBoxRodzajUrz.setBounds(501, 50, 182, 20);
		add(comboBoxRodzajUrz);
		
		JLabel lblWybor = new JLabel("Wybierz urz¹dzenie z listy: ");
		lblWybor.setBounds(386, 78, 167, 14);
		add(lblWybor);
		
		JComboBox comboBoxUrzadzenie = new JComboBox();
		comboBoxUrzadzenie.setMaximumRowCount(5);
		comboBoxUrzadzenie.setBounds(386, 103, 297, 20);
		add(comboBoxUrzadzenie);
		
		JLabel lblWpiszinfo = new JLabel("lub wpisz rêcznie wszystkie podzespo³y:");
		lblWpiszinfo.setBounds(386, 128, 297, 14);
		add(lblWpiszinfo);
		
		JLabel lblPlytaGlowna = new JLabel("P³yta g³ówna:");
		lblPlytaGlowna.setBounds(386, 206, 103, 14);
		add(lblPlytaGlowna);
		
		JLabel lblProcesor = new JLabel("Procesor:");
		lblProcesor.setBounds(386, 231, 103, 14);
		add(lblProcesor);
		
		JLabel lblKartaGraficzna = new JLabel("Karta graficzna:");
		lblKartaGraficzna.setBounds(386, 256, 103, 14);
		add(lblKartaGraficzna);
		
		JLabel lblBateria = new JLabel("Bateria:");
		lblBateria.setBounds(386, 281, 103, 14);
		add(lblBateria);
		
		JLabel lblHdd = new JLabel("HDD:");
		lblHdd.setBounds(386, 306, 103, 14);
		add(lblHdd);
		
		txtPlytaglowna = new JTextField();
		txtPlytaglowna.setText("");
		txtPlytaglowna.setBounds(501, 203, 182, 20);
		add(txtPlytaglowna);
		txtPlytaglowna.setColumns(10);
		
		txtProcesor = new JTextField();
		txtProcesor.setText("");
		txtProcesor.setBounds(501, 228, 182, 20);
		add(txtProcesor);
		txtProcesor.setColumns(10);
		
		txtKartagraficzna = new JTextField();
		txtKartagraficzna.setText("");
		txtKartagraficzna.setBounds(501, 253, 182, 20);
		add(txtKartagraficzna);
		txtKartagraficzna.setColumns(10);
		
		txtBateria = new JTextField();
		txtBateria.setText("");
		txtBateria.setBounds(501, 278, 182, 20);
		add(txtBateria);
		txtBateria.setColumns(10);
		
		txtHdd = new JTextField();
		txtHdd.setText("");
		txtHdd.setBounds(501, 303, 182, 20);
		add(txtHdd);
		txtHdd.setColumns(10);
		
		JLabel lblOpisusterki = new JLabel("Opis usterki: ");
		lblOpisusterki.setBounds(760, 159, 167, 14);
		add(lblOpisusterki);
		
		JPanel panelOpisUsterki = new JPanel();
		panelOpisUsterki.setBounds(760, 184, 235, 70);
		add(panelOpisUsterki);
		panelOpisUsterki.setLayout(null);
		
		JTextPane txtpnOpisusterki = new JTextPane();
		txtpnOpisusterki.setBounds(0, 0, 239, 70);
		panelOpisUsterki.add(txtpnOpisusterki);
		txtpnOpisusterki.setText("");
		
		JLabel lblDatausterki = new JLabel("Data wyst¹pienia usterki: ");
		lblDatausterki.setBounds(760, 273, 168, 14);
		add(lblDatausterki);
		
		txtDataUsterki = new JTextField();
		txtDataUsterki.setBounds(915, 270, 108, 20);
		add(txtDataUsterki);
		txtDataUsterki.setColumns(10);
		
		JLabel lblProducent = new JLabel("Producent:");
		lblProducent.setBounds(386, 156, 103, 14);
		add(lblProducent);
		
		txtProducent = new JTextField();
		txtProducent.setText("");
		txtProducent.setColumns(10);
		txtProducent.setBounds(501, 153, 182, 20);
		add(txtProducent);
		
		JLabel lblMatryca = new JLabel("Matryca:");
		lblMatryca.setBounds(386, 331, 103, 14);
		add(lblMatryca);
		
		txtMatryca = new JTextField();
		txtMatryca.setText("");
		txtMatryca.setColumns(10);
		txtMatryca.setBounds(501, 328, 182, 20);
		add(txtMatryca);
		
		JLabel label = new JLabel("Matryca:");
		label.setBounds(386, 181, 103, 14);
		add(label);
		
		textField = new JTextField();
		textField.setText("");
		textField.setColumns(10);
		textField.setBounds(501, 178, 182, 20);
		add(textField);
		
		JLabel lblNrklientatxt = new JLabel("");
		lblNrklientatxt.setBounds(167, 298, 116, 14);
		add(lblNrklientatxt);
		
		JLabel lblOpisZlecenia = new JLabel("Opis zlecenia:");
		lblOpisZlecenia.setBounds(40, 103, 98, 14);
		add(lblOpisZlecenia);
		
		JLabel lblUsterka = new JLabel("Usterka:");
		lblUsterka.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsterka.setBounds(760, 11, 103, 14);
		add(lblUsterka);
		
		JLabel lblWybierzUsterkZ = new JLabel("Wybierz usterk\u0119 z listy: ");
		lblWybierzUsterkZ.setBounds(760, 53, 167, 14);
		add(lblWybierzUsterkZ);
		
		JComboBox comboBoxUsterka = new JComboBox();
		comboBoxUsterka.setMaximumRowCount(5);
		comboBoxUsterka.setBounds(760, 75, 235, 20);
		add(comboBoxUsterka);
		
		JLabel lblUsterkaRecznie = new JLabel("lub wpisz usterkê rêcznie: ");
		lblUsterkaRecznie.setBounds(760, 104, 167, 14);
		add(lblUsterkaRecznie);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 129, 243, 57);
		add(scrollPane);
		
		JTextPane textPanelOpisZlecenia = new JTextPane();
		scrollPane.setViewportView(textPanelOpisZlecenia);
		
		JLabel lblNazwausterki = new JLabel("Nazwa usterki:");
		lblNazwausterki.setBounds(760, 131, 103, 14);
		add(lblNazwausterki);
		
		txtNazwaUsterki = new JTextField();
		txtNazwaUsterki.setBounds(915, 125, 108, 20);
		add(txtNazwaUsterki);
		txtNazwaUsterki.setColumns(10);
		
		
		comboBoxWyszukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((String) comboBoxWyszukaj.getSelectedItem()!="---"){
					//txtNrklienta.setEnabled(false);
					txtImie.setEnabled(false);
					txtNazwisko.setEnabled(false);
					txtAdres.setEnabled(false);
					txtMail.setEnabled(false);
					txtKontakt.setEnabled(false);
					Connection c = null;
					try { 
				c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
			            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
			  } catch (SQLException se) {
			    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
			    se.printStackTrace();
			    System.exit(1);}
					String imie = (String) comboBoxWyszukaj.getSelectedItem();
					int index =imie.indexOf(" ");
					String nazwisko = imie.substring(index+1);
					imie =imie.substring(0, index);
					try{
										
												
							Statement st = c.createStatement();
							ResultSet rs = st.executeQuery("SELECT k.id_klienta, k.imie,k.nazwisko,k.adres,k.mail,k.inne FROM Klienci k  where k.imie = \'"+imie+"\' and k.nazwisko = \'"+nazwisko+"\';");
							while (rs.next()){       
									lblNrklientatxt.setText((rs.getString("id_klienta")));
						           txtImie.setText((rs.getString("imie"))) ;
						           txtNazwisko.setText((rs.getString("nazwisko")));
						           txtAdres.setText((rs.getString("adres")));
						           txtMail.setText((rs.getString("mail")));
						           txtKontakt.setText((rs.getString("inne")));
						             //pracownicyImiona.add(imie_tmp+" "+nazwisko_tmp);
						             }
							
							st.close();
						c.close();
					}
					catch(SQLException z)  {
						System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
						}
					
				}	
				else {
					//txtNrklienta.setEnabled(true);
					lblNrklientatxt.setText("");
					txtImie.setEnabled(true);
					txtImie.setText("");
					txtNazwisko.setEnabled(true);
					txtNazwisko.setText("");
					txtAdres.setEnabled(true);
					txtAdres.setText("");
					txtMail.setEnabled(true);
					txtMail.setText("");
					txtKontakt.setEnabled(true);
					txtKontakt.setText("");
					
				}
			}
		});
		comboBoxRodzajUrz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sprzetModele.removeAll(sprzetModele);
				Connection c = null;
				try { 
					c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
				            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
				  } catch (SQLException se) {
				    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
				    se.printStackTrace();
				    System.exit(1);}
						
						try{
											
													
								Statement st = c.createStatement();
								ResultSet rs = st.executeQuery("SELECT  s.producent,s.model FROM Sprzet s, RodzajSprzetu r where r.nazwa = \'"+(String)comboBoxRodzajUrz.getSelectedItem()+"\' AND r.id_rodzaj = s.id_rodzaj ;");
								while (rs.next()){       
									
							           String  producent_tmp = (rs.getString("producent")) ;
							           String  model_tmp = (rs.getString("model")) ;
							           sprzetModele.add(producent_tmp+" "+model_tmp);
							             }
								st.close();
								c.close();
							
						}
						catch(SQLException z)  {
							System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
							}
						comboBoxUrzadzenie.removeAllItems();
						comboBoxUrzadzenie.addItem(pauzy);
						for (int i =0;i<sprzetModele.size();i++){							
							comboBoxUrzadzenie.addItem(sprzetModele.get(i));
						}
				
			}
		});
		ImageIcon dodaj = new ImageIcon(getClass().getResource("dodaj.png"));
		JButton btnDodaj = new JButton(dodaj);
		btnDodaj.setBounds(886, 413, 137, 37);
		btnDodaj.setContentAreaFilled(false);
		btnDodaj.setBorder(BorderFactory.createEmptyBorder());
		add(btnDodaj);
	}
}
