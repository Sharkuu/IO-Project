package panels;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

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
		textField.setBounds(173, 143, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 57, 98, 117);
		add(panel);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);

	}
}
