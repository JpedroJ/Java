package br.com.elaborata.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.elaborata.modelo.Entrevistado;
import br.com.elaborata.modelo.Genero;
import br.com.elaborata.modelo.TimeCoracao;
import br.com.elaborata.visao.JanelaFormulario;

public class OKActionListener implements ActionListener {

	JanelaFormulario formulario;

	public OKActionListener(JanelaFormulario janelaFormulario) {
		this.formulario = janelaFormulario;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Preencher os dados do entrevistado
		Entrevistado entrevistado = new Entrevistado();

		// verificar campo idade
		Integer idade;
		if ("".equals(formulario.getIdade().getText().trim())) {
			JOptionPane.showMessageDialog(null, "Campo idade deve ser preenchido");
			return;
		}
		try {
			idade = Integer.valueOf(formulario.getIdade().getText());
			if (idade < 18 || idade > 65) {
				JOptionPane.showMessageDialog(null,
						"Somente pessoas com idade entre 18 e 65 anos podem ser entrevistadas");
				return;
			}

		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "Idade invalida!");
			return;
		}
		entrevistado.setIdade(idade);

		// verifica qual o genero escolhido

		boolean masculino = formulario.getMasculino().isSelected();
		boolean feminino = formulario.getFeminino().isSelected();

		if (!masculino && !feminino) {
			JOptionPane.showMessageDialog(null, "Genero não informado");
			return;
		}
		entrevistado.setGenero(masculino ? Genero.MASCULINO : Genero.FEMININO);

		// verificar o time coração

		switch (formulario.getTimeCoracao().getSelectedIndex()) {
		case 0:
			JOptionPane.showMessageDialog(null, "Time não selecionado");
			return;
		case 1:
			entrevistado.setTimeCoracao(TimeCoracao.ATLETICO);
			break;
		case 2:
			entrevistado.setTimeCoracao(TimeCoracao.CORITIBA);
			break;
		case 3:
			entrevistado.setTimeCoracao(TimeCoracao.PARANA);
			break;
		case 4:
			entrevistado.setTimeCoracao(TimeCoracao.OUTROS);
			break;
		}
		
		formulario.getEntrevistados().add(entrevistado);
		// Atualiza a entrevista
		Entrevista.addEntrevistado(entrevistado);
		
		
		// Atualiza os campos do resultado
		formulario.getResultado().atualizaCampos();

		formulario.getIdade().setText("");
		formulario.getGenero().clearSelection();
		formulario.getTimeCoracao().setSelectedIndex(0);

	}

}
