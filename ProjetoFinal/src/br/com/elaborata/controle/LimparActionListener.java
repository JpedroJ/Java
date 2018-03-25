package br.com.elaborata.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.elaborata.visao.JanelaFormulario;

public class LimparActionListener implements ActionListener {

	JanelaFormulario formulario;

	public LimparActionListener(JanelaFormulario janelaFormulario) {
		this.formulario = janelaFormulario;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.formulario.getIdade().setText("");
		this.formulario.getGenero().clearSelection();
		// this.formulario.getMasculino().setSelected(false);
		// this.formulario.getFeminino().setSelected(false);
		this.formulario.getTimeCoracao().setSelectedIndex(0);
	}

}
