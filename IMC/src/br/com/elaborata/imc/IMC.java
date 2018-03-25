package br.com.elaborata.imc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IMC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabel;
	private JLabel jLabel2;

	private JTextField field;
	private JTextField field2;
	private JButton button;

	public IMC() {
		setTitle("Calculo de IMC");
		setSize(400, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jLabel = new JLabel();
		jLabel.setText("Digite a altura: ");
		jLabel.setBounds(20, 20, 160, 20);
		add(jLabel);
		
		jLabel2 = new JLabel();
		jLabel2.setText("Digite o peso: ");
		jLabel2.setBounds(20, 20, 160, 20);
		add(jLabel2);
		
		field = new JTextField();
		field.setText("");
		field.setBounds(180, 20, 200, 20);
		add(field);

		field2 = new JTextField();
		field2.setText("");
		field2.setBounds(180, 20, 200, 20);
		add(field2);
		
		
		
		


		// botao
		button = new JButton();
		button.setText("Calcular");
		button.setBounds(20, 50, 140, 20);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				field.getText();
				field2.getText();
				Double altura = Double.valueOf(field.getText());
				Double peso = Double.valueOf(field2.getText());
				JOptionPane.showMessageDialog(null, "Seu Indice de massa corporal é: " + String.format("%.2f", peso / (altura*altura)), null, 
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		add(button);

	}

}
