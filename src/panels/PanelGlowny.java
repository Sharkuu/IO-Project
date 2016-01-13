package panels;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Image;

public class PanelGlowny extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGlowny() {
		setLayout(null);
		setBounds(0,0, 1072, 502);
		setBackground(new Color(0xf7f7f7));
		
		
		ImageIcon image1 = new ImageIcon(getClass().getResource("logo.png"));
		//Image img = image1.getImage() ;  
		   //Image newimg = img.getScaledInstance( 150, 140,  java.awt.Image.SCALE_SMOOTH ) ;  
		  // image1 = new ImageIcon( newimg );
		   JLabel lblPanelglownyLogo = new JLabel(image1);
			lblPanelglownyLogo.setBounds(463, 132, 191, 208);
			add(lblPanelglownyLogo);
	}
}
