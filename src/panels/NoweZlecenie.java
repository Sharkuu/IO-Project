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
	private JTextField txtRam;
	private JTextField txtDataUsterki;
	private JTextField txtProducent;
	private JTextField txtModel;
	private JTextField txtMatryca;
	public ArrayList<String> pracownicyImiona = new ArrayList<>();
	public ArrayList<String> klienciImiona = new ArrayList<>();
	public ArrayList<String> rodzajSprz = new ArrayList<>();
	public ArrayList<String> rodzajUsterki = new ArrayList<>();
	public ArrayList<String> sprzetModele = new ArrayList<>();
	final private String pauzy = "---";
	private JTextField txtNazwaUsterki;
	private JTextField txtRodzaj;
	protected String lastModel;
	protected String lastRodzaj;
	protected String imie_pracownika;
	protected String nazwisko_pracownika;
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
		rodzajUsterki.add(pauzy);
		JComboBox comboBoxSerwisant = new JComboBox();
		comboBoxSerwisant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxSerwisant.getSelectedItem() != pauzy){
				 imie_pracownika = (String) comboBoxSerwisant.getSelectedItem();
				int index =imie_pracownika.indexOf(" ");
				nazwisko_pracownika = imie_pracownika.substring(index+1);
				imie_pracownika =imie_pracownika.substring(0, index);}
			}
		});
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
					             rodzajSprz.add(rodzaj_tmp );
					            
					             }
						st.close();
						c.close();
					
				}
				catch(SQLException z)  {
					System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
					}
				for (int i =0;i<rodzajSprz.size();i++){				
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
		lblPlytaGlowna.setBounds(386, 230, 103, 14);
		add(lblPlytaGlowna);
		
		JLabel lblProcesor = new JLabel("Procesor:");
		lblProcesor.setBounds(386, 255, 103, 14);
		add(lblProcesor);
		
		JLabel lblKartaGraficzna = new JLabel("Karta graficzna:");
		lblKartaGraficzna.setBounds(386, 280, 103, 14);
		add(lblKartaGraficzna);
		
		JLabel lblBateria = new JLabel("Bateria:");
		lblBateria.setBounds(386, 305, 103, 14);
		add(lblBateria);
		
		JLabel lblRam = new JLabel("Ram:");
		lblRam.setBounds(386, 330, 103, 14);
		add(lblRam);
		
		txtPlytaglowna = new JTextField();
		txtPlytaglowna.setText("");
		txtPlytaglowna.setBounds(501, 227, 182, 20);
		add(txtPlytaglowna);
		txtPlytaglowna.setColumns(10);
		
		txtProcesor = new JTextField();
		txtProcesor.setText("");
		txtProcesor.setBounds(501, 252, 182, 20);
		add(txtProcesor);
		txtProcesor.setColumns(10);
		
		txtKartagraficzna = new JTextField();
		txtKartagraficzna.setText("");
		txtKartagraficzna.setBounds(501, 277, 182, 20);
		add(txtKartagraficzna);
		txtKartagraficzna.setColumns(10);
		
		txtBateria = new JTextField();
		txtBateria.setText("");
		txtBateria.setBounds(501, 302, 182, 20);
		add(txtBateria);
		txtBateria.setColumns(10);
		
		txtRam = new JTextField();
		txtRam.setText("");
		txtRam.setBounds(501, 327, 182, 20);
		add(txtRam);
		txtRam.setColumns(10);
		
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
		lblProducent.setBounds(386, 180, 103, 14);
		add(lblProducent);
		
		txtProducent = new JTextField();
		txtProducent.setText("");
		txtProducent.setColumns(10);
		txtProducent.setBounds(501, 177, 182, 20);
		add(txtProducent);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(386, 355, 103, 14);
		add(lblModel);
		
		txtModel = new JTextField();
		txtModel.setText("");
		txtModel.setColumns(10);
		txtModel.setBounds(501, 352, 182, 20);
		add(txtModel);
		
		JLabel lblMatryca = new JLabel("Matryca:");
		lblMatryca.setBounds(386, 205, 103, 14);
		add(lblMatryca);
		
		txtMatryca = new JTextField();
		txtMatryca.setText("");
		txtMatryca.setColumns(10);
		txtMatryca.setBounds(501, 202, 182, 20);
		add(txtMatryca);
		
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
		
		
		comboBoxUsterka.addItem(pauzy);
		comboBoxUsterka.setMaximumRowCount(5);
		try { 
			c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
		            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
		  } catch (SQLException se) {
		    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
		    se.printStackTrace();
		    System.exit(1);}
				
				try{
									
											
						Statement st = c.createStatement();
						ResultSet rs = st.executeQuery("SELECT  u.nazwa FROM Usterki u ;");
						while (rs.next()){       
							
					           String  nazwa_tmp = (rs.getString("nazwa")) ;				           
					           comboBoxUsterka.addItem(nazwa_tmp);	;
					             }
						st.close();
						c.close();
					
				}
				catch(SQLException z)  {
					System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
					}
				
				
				
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
							ResultSet rs = st.executeQuery("SELECT k.id_klienta, k.imie,k.nazwisko,k.adres,k.mail,k.telefon FROM Klienci k  where k.imie = \'"+imie+"\' and k.nazwisko = \'"+nazwisko+"\';");
							while (rs.next()){       
									lblNrklientatxt.setText((rs.getString("id_klienta")));
						           txtImie.setText((rs.getString("imie"))) ;
						           txtNazwisko.setText((rs.getString("nazwisko")));
						           txtAdres.setText((rs.getString("adres")));
						           txtMail.setText((rs.getString("mail")));
						           txtKontakt.setText((rs.getString("telefon")));
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
		comboBoxUrzadzenie.addItem(pauzy);
		comboBoxRodzajUrz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((String)comboBoxRodzajUrz.getSelectedItem()!= "---"){
				Connection c = null;
				
				sprzetModele.removeAll(sprzetModele);
				try { 
					c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
				            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
				  } catch (SQLException se) {
				    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
				    se.printStackTrace();
				    System.exit(1);}
						
						try{
											
													
								Statement st = c.createStatement();
								ResultSet rs = st.executeQuery("SELECT s.producent,s.model FROM Sprzet s, RodzajSprzetu r where r.nazwa = \'"+(String)comboBoxRodzajUrz.getSelectedItem()+"\' AND r.id_rodzaj = s.id_rodzaj ;");
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
						int tmp =comboBoxUrzadzenie.getItemCount();
						if(tmp>1){
						for(int i = 1;i<tmp;++i){
							//System.out.println(comboBoxUrzadzenie.getItemAt(1));
							comboBoxUrzadzenie.removeItemAt(1);
							}}
						//comboBoxUrzadzenie.addItem(pauzy);
						for (int i =0;i<sprzetModele.size();i++){							
							comboBoxUrzadzenie.addItem(sprzetModele.get(i));
						}
						
						
						lastRodzaj = (String)comboBoxRodzajUrz.getSelectedItem();
						txtRodzaj.setText((String)comboBoxRodzajUrz.getSelectedItem());
						txtRodzaj.setEnabled(false);
						comboBoxUrzadzenie.setEnabled(true);
				}
				else {		
					txtRodzaj.setEnabled(true);
					txtModel.setText("");
					txtRodzaj.setText("");
					txtBateria.setText("");
					txtKartagraficzna.setText("");
					txtMatryca.setText("");
					txtPlytaglowna.setText("");
					txtProcesor.setText("");
					txtRam.setText("");
					txtProducent.setText("");				
					comboBoxUrzadzenie.removeAllItems();
					comboBoxUrzadzenie.setEnabled(false);
					comboBoxUrzadzenie.addItem(pauzy);
				}
			}
		});
		comboBoxUrzadzenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((String)comboBoxRodzajUrz.getSelectedItem() !="---" && (String)comboBoxUrzadzenie.getSelectedItem() != pauzy){
					Connection c = null;
				try { 
					c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
				            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
				  } catch (SQLException se) {
				    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
				    se.printStackTrace();
				    System.exit(1);}
						
						try{
								String rodzaj = (String) comboBoxUrzadzenie.getSelectedItem();
								lastModel = rodzaj;
						int index =rodzaj.indexOf(" ");
						String model = rodzaj.substring(index+1);
						rodzaj =rodzaj.substring(0, index);			
													
								Statement st = c.createStatement();
								ResultSet rs = st.executeQuery("select r.nazwa, s.producent, s.model, s.procesor, s.grafika, s.ram, s.plytagowna, s.matryca, s.zasilacz FROM RodzajSprzetu r, Sprzet s where r.nazwa = \'"+(String)comboBoxRodzajUrz.getSelectedItem()+"\' AND s.producent = \'"+rodzaj+"\' AND s.model = \'"+model+"\' ;");
								while (rs.next()){     
										txtModel.setText((rs.getString("model")));
										//txtRodzaj.setText((rs.getString("nazwa")));
										txtBateria.setText((rs.getString("zasilacz")));
										txtKartagraficzna.setText((rs.getString("grafika")));
										txtMatryca.setText((rs.getString("matryca")));
										txtPlytaglowna.setText((rs.getString("plytagowna")));
										txtProcesor.setText((rs.getString("procesor")));
										txtRam.setText((rs.getString("ram")));
										txtProducent.setText((rs.getString("producent")));
							           
							             //pracownicyImiona.add(imie_tmp+" "+nazwisko_tmp);
							             }
								
								st.close();
							c.close();
						}
						catch(SQLException z)  {
							System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
							}
				}
				else{
					txtModel.setText("");
					//txtRodzaj.setText("");
					txtBateria.setText("");
					txtKartagraficzna.setText("");
					txtMatryca.setText("");
					txtPlytaglowna.setText("");
					txtProcesor.setText("");
					txtRam.setText("");
					txtProducent.setText("");
					
					
					
				}
			}
		});
		comboBoxUsterka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((String) comboBoxUsterka.getSelectedItem()!="---"){
					//txtNrklienta.setEnabled(false);
					txtNazwaUsterki.setEnabled(false);
					txtpnOpisusterki.setEnabled(false);
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
							ResultSet rs = st.executeQuery("SELECT u.nazwa, u.opis from Usterki u where u.nazwa = \'"+comboBoxUsterka.getSelectedItem()+"\';");
							while (rs.next()){       						
						           txtNazwaUsterki.setText((rs.getString("nazwa"))) ;
						           txtpnOpisusterki.setText((rs.getString("opis")));					          
						             }
							
							st.close();
						c.close();
					}
					catch(SQLException z)  {
						System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
						}
					
				}	
				else {
					txtNazwaUsterki.setEnabled(true);
					txtpnOpisusterki.setEnabled(true);
					txtNazwaUsterki.setText("");;
					txtpnOpisusterki.setText("");;
					
				}
			}
		});
		
		ImageIcon dodaj = new ImageIcon(getClass().getResource("dodaj.png"));
		JButton btnDodaj = new JButton(dodaj);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxWyszukaj.getSelectedItem() == pauzy){
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
									boolean rs = st.execute("insert into Klienci(imie,nazwisko,adres,mail,telefon) values (\'"+txtImie.getText()+"\',\'"+txtNazwisko.getText()+"\',\'"+txtAdres.getText()+"\',\'"+txtMail.getText()+"\',"+txtKontakt.getText()+") ;");								
									st.close();
								c.close();
							}
							catch(SQLException z)  {
								System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
								}
				}
				if(comboBoxUrzadzenie.getSelectedItem() == pauzy){
					Connection c = null;
					try { 
						c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
					            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
					  } catch (SQLException se) {
					    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
					    se.printStackTrace();
					    System.exit(1);}
					String rodzaj_tmp ="";
							try{					
								boolean rs;		
									Statement st = c.createStatement();
									if(comboBoxRodzajUrz.getSelectedItem() == pauzy)
									 rs = st.execute("insert into RodzajSprzetu(nazwa) values (\'"+txtRodzaj.getText()+"\' ) ;");
									ResultSet r = st.executeQuery("SELECT r.id_rodzaj from RodzajSprzetu r where r.nazwa = \'"+txtRodzaj.getText()+"\';");
									    	while(r.next()){					
								            rodzaj_tmp = (r.getString("id_rodzaj")) ;
								           //System.out.println(rodzaj_tmp);
									    	}      
								             
									 rs = st.execute("insert into Sprzet(id_rodzaj,producent,model,procesor,grafika,ram,plytagowna,matryca,zasilacz) values (\'"+rodzaj_tmp+"\',\'"+txtProducent.getText()+"\',\'"+txtModel.getText()+"\',\'"+txtProcesor.getText()+"\',\'"+txtKartagraficzna.getText()+"\',\'"+txtRam.getText()+"\',\'"+txtPlytaglowna.getText()+"\',\'"+txtMatryca.getText()+"\',\'"+txtBateria.getText()+"\' ) ;");								
									    
									    st.close();
								c.close();
							}
							catch(SQLException z)  {
								System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
								}
				}
				if(comboBoxUsterka.getSelectedItem() == pauzy){
					Connection c = null;
					try { 
						c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
					            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
					  } catch (SQLException se) {
					    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
					    se.printStackTrace();
					    System.exit(1);}
					String rodzaj_tmp ="";
							try{					
								boolean rs;		
									Statement st = c.createStatement();								
									 rs = st.execute("insert into Usterki(nazwa,opis) values (\'"+txtNazwaUsterki.getText()+"\',\'"+txtpnOpisusterki.getText()+"\' ) ;");

									    st.close();
								c.close();
							}
							catch(SQLException z)  {
								System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
								}
				}
				Connection c = null;
				try { 
					c = DriverManager.getConnection("jdbc:postgresql://horton.elephantsql.com:5432/cgztcato",
				            "cgztcato", "En74d8gVrZZAtiO97NEYI7FN-DiReO9h");
				  } catch (SQLException se) {
				    System.out.println("Brak polaczenia z baza danych, wydruk logu sledzenia i koniec.");
				    se.printStackTrace();
				    System.exit(1);}
				String rodzaj_tmp ="";
						try{					
							boolean rs;		
								Statement st = c.createStatement();								
								 rs = st.execute("insert into Naprawy(opis,datausterki,dataprzyjecia,id_pracownika,id_usterki,id_klienta,id_sprzetu,id_status) values (\'"+textPanelOpisZlecenia.getText()+"\',CURRENT_DATE,\'"+txtDataUsterki.getText()+"\',(select id_pracownika from Pracownicy where imie = \'"+imie_pracownika+"\' and nazwisko = \'"+nazwisko_pracownika+"\'),(select id_usterki from Usterki where nazwa = \'"+txtNazwaUsterki.getText()+"\' and opis = \'"+txtpnOpisusterki.getText()+"\'),(select id_klienta from Klienci where imie = \'"+txtImie.getText()+"\' and nazwisko = \'"+txtNazwisko.getText()+"\'),(select id_sprzetu from Sprzet where producent = \'"+txtProducent.getText()+"\' and model = \'"+txtModel.getText()+"\'),(select id_status from StatusNaprawy where nazwa = 'Oczekuj¹ca') ) ;");

								    st.close();
							c.close();
						}
						catch(SQLException z)  {
							System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
							}
			}
		});
		btnDodaj.setBounds(886, 413, 137, 37);
		btnDodaj.setContentAreaFilled(false);
		btnDodaj.setBorder(BorderFactory.createEmptyBorder());
		add(btnDodaj);
		
		JLabel lblRodzaj = new JLabel("Rodzaj:");
		lblRodzaj.setBounds(386, 156, 103, 14);
		add(lblRodzaj);
		
		txtRodzaj = new JTextField();
		txtRodzaj.setText("");
		txtRodzaj.setColumns(10);
		txtRodzaj.setBounds(501, 153, 182, 20);
		add(txtRodzaj);
	}
}
