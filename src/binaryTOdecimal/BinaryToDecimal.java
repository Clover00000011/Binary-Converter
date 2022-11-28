package binaryTOdecimal;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class BinaryToDecimal extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	private JComboBox<String> comboBox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinaryToDecimal frame = new BinaryToDecimal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BinaryToDecimal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Create JTextField for number input
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 21, 240, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Create JLabel with no text for now
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 89, 414, 14);
		contentPane.add(label);
		
		// Create button "Submit"
		button = new JButton("Submit");
		button.setBounds(148, 146, 151, 41);
		contentPane.add(button);
		
		// Create two Strings with values "Decimal to Binary" and "Binary to Decimal"
		String dTOb = "Decimal to Binary";
		String bTOd = "Binary to Decimal";
		
		// Create JComboBox with the Strings above as items
		comboBox = new JComboBox();
		comboBox.setBounds(260, 21, 164, 32);
		comboBox.addItem("");
		comboBox.addItem(dTOb);
		comboBox.addItem(bTOd);
		contentPane.add(comboBox);
		
		// Add ItemListener to comboBox
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedItem().equals(dTOb)) {
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int number = Integer.parseInt(textField.getText());
							String binary = Integer.toBinaryString(number);
							label.setText(binary);
								
						} 
					});
				} 
				if(comboBox.getSelectedItem().equals(bTOd)) {
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String binary = textField.getText();
							label.setText(""+Integer.parseInt(binary,2));
						}
					});
				}
				else {
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								label.setText("This is not a Number!");
						}
					});
				}
			}
		});
		
		

	}
}
