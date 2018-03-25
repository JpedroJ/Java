package br.com.elaborata.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SobreActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		JOptionPane.showMessageDialog(null, "Pesquisa de Futebol Versão 2.0"+ "\nElaborata Informatica");

	}

}
