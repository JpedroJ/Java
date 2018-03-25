package br.com.elaborata.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SairActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int confirme = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação",
				JOptionPane.YES_NO_OPTION);
		if (confirme == 0) {
			System.exit(0);
		}
	}

}
