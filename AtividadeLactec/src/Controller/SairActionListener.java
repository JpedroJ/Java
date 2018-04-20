package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.ClienteView;

public class SairActionListener implements ActionListener {

	ClienteView cliente;

	public SairActionListener(ClienteView clienteView) {
		this.cliente = clienteView;
	}

	// acao do botao sair 
	@Override
	public void actionPerformed(ActionEvent e) {
		int confirme = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação",
				JOptionPane.YES_NO_OPTION);
		if (confirme == 0) {
			System.exit(0);

		}

	}
}
