import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class errorLog {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void ErrorScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					errorLog window = new errorLog();
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
	public errorLog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 293, 188);
		frame.setDefaultCloseOperation(0);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().setLayout(null);
		ImageIcon image1 = new ImageIcon(getClass().getResource("logo.png"));
		Image img = image1.getImage() ;  
		   Image newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
			frame.setIconImage(newimg);
		JLabel lblInfo = new JLabel("B³êdny login lub haslo.");
		
		lblInfo.setBounds(78, 45, 174, 38);
		frame.getContentPane().add(lblInfo);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(0xe1e1e1));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				logowanie.btnZaloguj.setEnabled(true);			}
		});
		btnOk.setBounds(88, 86, 89, 23);
		frame.getContentPane().add(btnOk);
		btnOk.setBorderPainted(false);
		btnOk.setFocusPainted(false);
	}

}
