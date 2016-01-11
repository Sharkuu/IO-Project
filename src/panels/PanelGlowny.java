package panels;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class PanelGlowny extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelGlowny() {
		setForeground(Color.YELLOW);
		setBackground(Color.ORANGE);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(105, 130, 86, 20);
		add(textField);
		textField.setColumns(10);

	}
}
