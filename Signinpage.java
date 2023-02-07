
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Signinpage extends JFrame {

	private JTextField idLabel;
	JFrame frame;
	

	// Create the frame.

	public Signinpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(0, 0, 455, 350);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(124, 28, 204, 195);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel welcomelabel = new JLabel("Welcome");
		welcomelabel.setBounds(6, 5, 192, 30);
		panel.add(welcomelabel);
		welcomelabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
		welcomelabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel message = new JLabel("");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(143, 235, 185, 38);
		getContentPane().add(message);

		idLabel = new JTextField();
		idLabel.setBounds(42, 82, 130, 26);
		panel.add(idLabel);
		idLabel.setColumns(10);

		// id label
		JLabel idlabel = new JLabel("ID");
		idlabel.setBounds(16, 87, 24, 16);
		panel.add(idlabel);

		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = idLabel.getText();
				int id = Integer.parseInt(text);
				if (id > 201399999 && id < 202199999) {
					Resturant res = new Resturant();
					res.setVisible(true);
					
				} else {
					message.setForeground(Color.red);
					message.setText("Invalid ID");
				}
			}
		});
		btnNewButton.setForeground(new Color(46, 139, 87));
		btnNewButton.setBounds(52, 138, 117, 29);
		panel.add(btnNewButton);
	}
}