package panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class PanelGlowny extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGlowny() {
		setLayout(null);
		setBounds(0,0, 1072, 502);
		setBackground(new Color(0xf7f7f7));
		
		JLabel lblPanelglownyLogo = new JLabel("PANELGLOWNY LOGO");
		lblPanelglownyLogo.setBounds(242, 173, 163, 41);
		add(lblPanelglownyLogo);
	}
}
