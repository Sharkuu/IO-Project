package panels;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class PanelNaprawy extends JPanel {

	/**
	 * Create the panel.
	 */
	public String pauzy = "---";
	public ArrayList<String> naprawy = new ArrayList<>();
	public ArrayList<String> naprawyZ = new ArrayList<>();
	public PanelNaprawy() {
		setBounds(0,0, 1072, 502);
		setBackground(new Color(0xf7f7f7));
		setLayout(null);
		
		JLabel lblMenanapraw = new JLabel("Menager napraw");
		lblMenanapraw.setBounds(35, 47, 162, 24);
		lblMenanapraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenanapraw.setBackground(new Color(0x446e79));
		lblMenanapraw.setForeground(Color.WHITE);
		lblMenanapraw.setOpaque(true);
		add(lblMenanapraw);
		
		JLabel lblNaprawyRozp = new JLabel("Naprawy rozpoczête");
		lblNaprawyRozp.setBounds(35, 82, 162, 14);
		lblNaprawyRozp.setForeground(new Color(0x446e79));
		add(lblNaprawyRozp);
		
		JComboBox comboBoxNapRozpocz = new JComboBox();
		comboBoxNapRozpocz.setBounds(35, 106, 162, 20);
		add(comboBoxNapRozpocz);
		
		JLabel lblNaprawyzak = new JLabel("Naprawy zakoñczone");
		lblNaprawyzak.setBounds(35, 137, 162, 14);
		lblNaprawyzak.setForeground(new Color(0x446e79));
		add(lblNaprawyzak);
		
		JComboBox comboBoxNapZak = new JComboBox();
		comboBoxNapZak.setBounds(35, 162, 162, 20);
		add(comboBoxNapZak);
		
		JLabel lblOpcjenaprawy = new JLabel("Opcje naprawy");
		lblOpcjenaprawy.setBounds(35, 200, 162, 24);
		lblOpcjenaprawy.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcjenaprawy.setForeground(Color.WHITE);
		lblOpcjenaprawy.setBackground(new Color(0x446e79));
		lblOpcjenaprawy.setOpaque(true);
		add(lblOpcjenaprawy);
		
		JLabel lblDodajserw = new JLabel("Dodaj serwisanta");
		lblDodajserw.setBounds(35, 235, 162, 14);
		lblDodajserw.setForeground(new Color(0x446e79));
		add(lblDodajserw);
		
		JComboBox comboBoxDodajSerw = new JComboBox();
		comboBoxDodajSerw.setEnabled(false);
		comboBoxDodajSerw.setBounds(35, 260, 162, 20);
		add(comboBoxDodajSerw);
		
		JLabel lblZmienstatus = new JLabel("Zmieñ status naprawy");
		lblZmienstatus.setBounds(35, 291, 162, 14);
		lblZmienstatus.setForeground(new Color(0x446e79));
		add(lblZmienstatus);
		
		JComboBox comboBoxZmienStat = new JComboBox();
		comboBoxZmienStat.setBounds(35, 316, 162, 20);
		add(comboBoxZmienStat);
		
		JLabel lblPostep = new JLabel("Ustaw postêp");
		lblPostep.setBounds(35, 347, 162, 14);
		lblPostep.setForeground(new Color(0x446e79));
		add(lblPostep);
		
		JComboBox comboBoxUstPostep = new JComboBox();
		comboBoxUstPostep.setBounds(35, 372, 162, 20);
		add(comboBoxUstPostep);
		comboBoxDodajSerw.setMaximumRowCount(5);
		comboBoxNapRozpocz.setMaximumRowCount(5);
		comboBoxNapZak.setMaximumRowCount(5);
		comboBoxZmienStat.setMaximumRowCount(5);
		comboBoxUstPostep.setMaximumRowCount(5);
		
		JLabel lblInfonaprawa = new JLabel(" Informacje o naprawie");
		lblInfonaprawa.setBounds(275, 47, 750, 24);
		lblInfonaprawa.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfonaprawa.setForeground(Color.white);
		lblInfonaprawa.setBackground(new Color(0x446e79));
		lblInfonaprawa.setOpaque(true);
		add(lblInfonaprawa);
		
		JLabel lblStatusnaprawy = new JLabel("Status naprawy:");
		lblStatusnaprawy.setBounds(275, 82, 102, 14);
		lblStatusnaprawy.setForeground(new Color(0x446e79));
		add(lblStatusnaprawy);
		
		JLabel lbltxtStatus = new JLabel("");
		lbltxtStatus.setBounds(387, 82, 114, 14);
		add(lbltxtStatus);
		
		JLabel lblSerwisant = new JLabel("Serwisant:");
		lblSerwisant.setBounds(275, 109, 102, 14);
		lblSerwisant.setForeground(new Color(68, 110, 121));
		add(lblSerwisant);
		
		JLabel lbltxtSerwisant = new JLabel("");
		lbltxtSerwisant.setBounds(387, 109, 114, 14);
		add(lbltxtSerwisant);
		
		JLabel lblPostepInfo = new JLabel("Status naprawy:");
		lblPostepInfo.setBounds(643, 82, 102, 14);
		lblPostepInfo.setForeground(new Color(68, 110, 121));
		add(lblPostepInfo);
		
		JLabel lbltxtPostep = new JLabel("");
		lbltxtPostep.setBounds(755, 82, 114, 14);
		add(lbltxtPostep);
		
		JLabel lblPoprzednie = new JLabel("Poprzednie aktualizacje naprawy:");
		lblPoprzednie.setBounds(275, 137, 360, 14);
		add(lblPoprzednie);
		
		JScrollPane scrollPaneInfoPoprzednie = new JScrollPane();
		scrollPaneInfoPoprzednie.setBounds(275, 162, 750, 145);
		add(scrollPaneInfoPoprzednie);
		
		JTextPane textPaneInfoPoprzednie = new JTextPane();
		textPaneInfoPoprzednie.setEditable(false);
		scrollPaneInfoPoprzednie.setViewportView(textPaneInfoPoprzednie);
		
		JLabel lblInfozlecenie = new JLabel("Informacje o zleceniu:");
		lblInfozlecenie.setBounds(275, 319, 137, 14);
		add(lblInfozlecenie);
		
		JScrollPane scrollPaneInfoUsterka = new JScrollPane();
		scrollPaneInfoUsterka.setBounds(275, 347, 182, 144);
		add(scrollPaneInfoUsterka);
		
		JTextPane textPaneInfoUsterka = new JTextPane();
		textPaneInfoUsterka.setEditable(false);
		scrollPaneInfoUsterka.setViewportView(textPaneInfoUsterka);
		
		JLabel lblNowanotatka = new JLabel("Nowa notatka:");
		lblNowanotatka.setBounds(493, 319, 114, 14);
		add(lblNowanotatka);
		
		ImageIcon zamow = new ImageIcon(getClass().getResource("zamow.png"));
		JButton btnZamow = new JButton(zamow);
		btnZamow.setBounds(45, 403, 139, 35);
		btnZamow.setContentAreaFilled(false);
		btnZamow.setBorder(BorderFactory.createEmptyBorder());
		add(btnZamow);
		
		ImageIcon anulujzlecenie = new ImageIcon(getClass().getResource("anuluj_zlecenie.png"));
		JButton btnAnulujzlecenie = new JButton(anulujzlecenie);
		btnAnulujzlecenie.setBounds(47, 449, 137, 31);
		btnAnulujzlecenie.setContentAreaFilled(false);
		btnAnulujzlecenie.setBorder(BorderFactory.createEmptyBorder());
		add(btnAnulujzlecenie);
		
		ImageIcon zatwierdz = new ImageIcon(getClass().getResource("zatwierdz.png"));
		JButton btnZatwierdz = new JButton(zatwierdz);
		btnZatwierdz.setBounds(891, 464, 133, 27);
		btnZatwierdz.setContentAreaFilled(false);
		btnZatwierdz.setBorder(BorderFactory.createEmptyBorder());
		add(btnZatwierdz);
		
		ImageIcon anulujzmiany = new ImageIcon(getClass().getResource("anuluj.png"));
		JButton btnAnulujzmiany = new JButton(anulujzmiany);
		btnAnulujzmiany.setBounds(751, 464, 133, 27);
		btnAnulujzmiany.setContentAreaFilled(false);
		btnAnulujzmiany.setBorder(BorderFactory.createEmptyBorder());
		add(btnAnulujzmiany);
		
		JTextPane textPaneNotatka = new JTextPane();
		textPaneNotatka.setEditable(false);
		textPaneNotatka.setBounds(493, 344, 532, 108);
		add(textPaneNotatka);
		comboBoxNapRozpocz.addItem(pauzy);
		comboBoxNapZak.addItem(pauzy);
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
				ResultSet rs = st.executeQuery("SELECT  n.id_naprawy, k.imie, k.nazwisko from naprawy n, klienci k where n.id_klienta = k.id_klienta and (n.id_status = 1 or n.id_status = 2);");
				while (rs.next()){       
					
			           String  id_tmp = (rs.getString("id_naprawy")) ;
			           String  imie_tmp = (rs.getString("imie")) ;
			           String  nazwisko_tmp = (rs.getString("nazwisko")) ;
			            naprawy.add(id_tmp+" "+imie_tmp+" "+nazwisko_tmp);
			             }
				rs = st.executeQuery("SELECT  n.id_naprawy, k.imie, k.nazwisko from naprawy n, klienci k where n.id_klienta = k.id_klienta and (n.id_status = 3);");
				while (rs.next()){       
					
			           String  idZ_tmp = (rs.getString("id_naprawy")) ;
			           String  imieZ_tmp = (rs.getString("imie")) ;
			           String  nazwiskoZ_tmp = (rs.getString("nazwisko")) ;
			            naprawyZ.add(idZ_tmp+" "+imieZ_tmp+" "+nazwiskoZ_tmp);
			             }
				st.close();
			c.close();
		}
		catch(SQLException z)  {
			System.out.println("Blad podczas przetwarzania danych:\n"+z) ;  
			}
		for (int i =0;i<naprawy.size();i++)
			comboBoxNapRozpocz.addItem(naprawy.get(i));
		for (int i =0;i<naprawyZ.size();i++)
			comboBoxNapZak.addItem(naprawyZ.get(i));
		
		
		
		
	}
}
