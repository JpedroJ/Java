package windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IMCcalculo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMCcalculo window = new IMCcalculo();
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
	public IMCcalculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblDigiteAAltura = new JLabel("Digite a altura");
		frame.getContentPane().add(lblDigiteAAltura);
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteOPeso = new JLabel("Digite o peso");
		frame.getContentPane().add(lblDigiteOPeso);
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.getText();
				textField_1.getText();
				Double altura = Double.valueOf(textField.getText());
				Double peso = Double.valueOf(textField_1.getText());
				JOptionPane.showMessageDialog(null, "Seu Indice de massa corporal é: " + String.format("%.2f", peso / (altura*altura)), null, JOptionPane.INFORMATION_MESSAGE);				
			}
		});
		frame.getContentPane().add(btnNewButton);
	}

}
