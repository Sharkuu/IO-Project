package panels;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class NoweZlecenie extends JPanel {
	private JTextField textNazwa;
	private JTextField txtNrklienta;
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

	/**
	 * Create the panel.
	 */
	public NoweZlecenie() {
		
		setBackground(new Color(0xf7f7f7));
		setBounds(0,0, 1072, 502);
		setLayout(null);
		
		JLabel lblDodaj = new JLabel("Dodaj nowe zlecenie");
		lblDodaj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDodaj.setBounds(40, 26, 137, 14);
		add(lblDodaj);
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		lblNazwa.setBounds(40, 53, 98, 14);
		add(lblNazwa);
		
		JLabel lblSerwisant = new JLabel("Serwisant:");
		lblSerwisant.setBounds(40, 78, 98, 14);
		add(lblSerwisant);
		
		textNazwa = new JTextField();
		textNazwa.setBounds(167, 51, 116, 20);
		add(textNazwa);
		textNazwa.setColumns(10);
		
		JComboBox comboBoxSerwisant = new JComboBox();
		comboBoxSerwisant.setBounds(167, 75, 116, 20);
		add(comboBoxSerwisant);
		
		JLabel lblDaneKlienta = new JLabel("Dane klienta");
		lblDaneKlienta.setBounds(40, 192, 98, 14);
		add(lblDaneKlienta);
		
		JLabel lblWyszukaj = new JLabel("Wyszukaj klienta z bazy:");
		lblWyszukaj.setBounds(40, 217, 243, 14);
		add(lblWyszukaj);
		
		JComboBox comboBoxWyszukaj = new JComboBox();
		comboBoxWyszukaj.setBounds(40, 242, 243, 20);
		add(comboBoxWyszukaj);
		
		JLabel lblRecznie = new JLabel("lub wpisz r�cznie wszystkie dane:");
		lblRecznie.setBounds(40, 273, 243, 14);
		add(lblRecznie);
		
		JLabel lblNrklienta = new JLabel("Nr klienta:");
		lblNrklienta.setBounds(40, 298, 98, 14);
		add(lblNrklienta);
		
		JLabel lblImie = new JLabel("Imi�:");
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
		
		txtNrklienta = new JTextField();
		txtNrklienta.setText("");
		txtNrklienta.setBounds(167, 298, 116, 20);
		add(txtNrklienta);
		txtNrklienta.setColumns(10);
		
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
		lblUrzadzenieinfo.setBounds(591, 11, 103, 14);
		add(lblUrzadzenieinfo);
		
		JLabel lblRodzajurzadzenia = new JLabel("Rodzaj urzadzenia: ");
		lblRodzajurzadzenia.setBounds(591, 36, 116, 14);
		add(lblRodzajurzadzenia);
		
		JComboBox comboBoxRodzajUrz = new JComboBox();
		comboBoxRodzajUrz.setBounds(706, 33, 182, 20);
		add(comboBoxRodzajUrz);
		
		JLabel lblWybor = new JLabel("Wybierz urz�dzenie z listy: ");
		lblWybor.setBounds(591, 61, 167, 14);
		add(lblWybor);
		
		JComboBox comboBoxUrzadzenie = new JComboBox();
		comboBoxUrzadzenie.setBounds(591, 75, 297, 20);
		add(comboBoxUrzadzenie);
		
		JLabel lblWpiszinfo = new JLabel("lub wpisz r�cznie wszystkie podzespo�y:");
		lblWpiszinfo.setBounds(591, 106, 297, 14);
		add(lblWpiszinfo);
		
		JLabel lblPlytaGlowna = new JLabel("P�yta g��wna:");
		lblPlytaGlowna.setBounds(591, 181, 103, 14);
		add(lblPlytaGlowna);
		
		JLabel lblProcesor = new JLabel("Procesor:");
		lblProcesor.setBounds(591, 206, 103, 14);
		add(lblProcesor);
		
		JLabel lblKartaGraficzna = new JLabel("Karta graficzna:");
		lblKartaGraficzna.setBounds(591, 231, 103, 14);
		add(lblKartaGraficzna);
		
		JLabel lblBateria = new JLabel("Bateria:");
		lblBateria.setBounds(591, 256, 103, 14);
		add(lblBateria);
		
		JLabel lblHdd = new JLabel("HDD:");
		lblHdd.setBounds(591, 281, 103, 14);
		add(lblHdd);
		
		txtPlytaglowna = new JTextField();
		txtPlytaglowna.setText("");
		txtPlytaglowna.setBounds(706, 178, 182, 20);
		add(txtPlytaglowna);
		txtPlytaglowna.setColumns(10);
		
		txtProcesor = new JTextField();
		txtProcesor.setText("");
		txtProcesor.setBounds(706, 203, 182, 20);
		add(txtProcesor);
		txtProcesor.setColumns(10);
		
		txtKartagraficzna = new JTextField();
		txtKartagraficzna.setText("");
		txtKartagraficzna.setBounds(706, 228, 182, 20);
		add(txtKartagraficzna);
		txtKartagraficzna.setColumns(10);
		
		txtBateria = new JTextField();
		txtBateria.setText("");
		txtBateria.setBounds(706, 253, 182, 20);
		add(txtBateria);
		txtBateria.setColumns(10);
		
		txtHdd = new JTextField();
		txtHdd.setText("");
		txtHdd.setBounds(706, 278, 182, 20);
		add(txtHdd);
		txtHdd.setColumns(10);
		
		JLabel lblInfusterka = new JLabel("Informacje o usterce:");
		lblInfusterka.setBounds(591, 341, 167, 14);
		add(lblInfusterka);
		
		JLabel lblOpisusterki = new JLabel("Opis usterki: ");
		lblOpisusterki.setBounds(591, 358, 167, 14);
		add(lblOpisusterki);
		
		JPanel panelOpisUsterki = new JPanel();
		panelOpisUsterki.setBounds(591, 376, 297, 70);
		add(panelOpisUsterki);
		panelOpisUsterki.setLayout(null);
		
		JTextPane txtpnOpisusterki = new JTextPane();
		txtpnOpisusterki.setBounds(0, 0, 297, 70);
		panelOpisUsterki.add(txtpnOpisusterki);
		txtpnOpisusterki.setText("");
		
		JLabel lblDatausterki = new JLabel("Data wyst�pienia usterki: ");
		lblDatausterki.setBounds(591, 448, 168, 14);
		add(lblDatausterki);
		
		txtDataUsterki = new JTextField();
		txtDataUsterki.setBounds(591, 471, 116, 20);
		add(txtDataUsterki);
		txtDataUsterki.setColumns(10);
		
		JLabel lblProducent = new JLabel("Producent:");
		lblProducent.setBounds(591, 131, 103, 14);
		add(lblProducent);
		
		txtProducent = new JTextField();
		txtProducent.setText("");
		txtProducent.setColumns(10);
		txtProducent.setBounds(706, 128, 182, 20);
		add(txtProducent);
		
		JLabel lblMatryca = new JLabel("Matryca:");
		lblMatryca.setBounds(591, 306, 103, 14);
		add(lblMatryca);
		
		txtMatryca = new JTextField();
		txtMatryca.setText("");
		txtMatryca.setColumns(10);
		txtMatryca.setBounds(706, 303, 182, 20);
		add(txtMatryca);
		
		JLabel label = new JLabel("Matryca:");
		label.setBounds(591, 156, 103, 14);
		add(label);
		
		textField = new JTextField();
		textField.setText("");
		textField.setColumns(10);
		textField.setBounds(706, 153, 182, 20);
		add(textField);
		
	}
}
