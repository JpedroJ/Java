package br.com.elaborata.visao;

import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.elaborata.controle.Entrevista;

public class JanelaResultado extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField qtdeTorcedores = new JTextField();
	private JTextField mediaIdade = new JTextField();
	private JTextField qtdeHomens = new JTextField();
	private JTextField qtdeMulheres = new JTextField();
	private JTextField qtdeAtletico = new JTextField();
	private JTextField qtdeCoritiba = new JTextField();
	private JTextField qtdeParana = new JTextField();
	private JTextField qtdeOutros = new JTextField();

	public JanelaResultado() {
		super("Resultado");
		setSize(450, 450);
		setLocation(500, 50);

		// criar o painel
		JPanel painel = new JPanel();

		// configurando o gerenciador de layout

		GridLayout grid = new GridLayout(10, 2, 10, 10);
		painel.setLayout(grid);
		painel.setSize(450, 450);
		painel.setBorder(new EmptyBorder(10, 10, 10, 10));

		// desabilitando os campos
		qtdeTorcedores.setEnabled(false);
		mediaIdade.setEnabled(false);
		qtdeHomens.setEnabled(false);
		qtdeMulheres.setEnabled(false);
		qtdeAtletico.setEnabled(false);
		qtdeCoritiba.setEnabled(false);
		qtdeParana.setEnabled(false);
		qtdeOutros.setEnabled(false);

		// adicionando os componentes
		painel.add(new JLabel("Quantidade de torcedores"));
		painel.add(qtdeTorcedores);
		painel.add(new JLabel("Media de idade"));
		painel.add(mediaIdade);
		painel.add(new JLabel("Quantidade de homens"));
		painel.add(qtdeHomens);
		painel.add(new JLabel("Quantidade de mulheres"));
		painel.add(qtdeMulheres);
		painel.add(new JLabel("Quantidade de atleticanos"));
		painel.add(qtdeAtletico);
		painel.add(new JLabel("Quantidade de coritibanos"));
		painel.add(qtdeCoritiba);
		painel.add(new JLabel("Quantidade de paranistas"));
		painel.add(qtdeParana);
		painel.add(new JLabel("Quantidade de outros times"));
		painel.add(qtdeOutros);

		add(painel);
	}

	public void atualizaCampos() {
		qtdeTorcedores.setText(String.valueOf(Entrevista.qtdeTorcedores));
		mediaIdade.setText(String.format("%.2f", Entrevista.mediaIdade));
		qtdeHomens.setText(String.valueOf(Entrevista.qtdeHomens));
		qtdeMulheres.setText(String.valueOf(Entrevista.qtdeMulheres));
		qtdeAtletico.setText(String.valueOf(Entrevista.qtdeAtletico));
		qtdeCoritiba.setText(String.valueOf(Entrevista.qtdeCoritiba));
		qtdeParana.setText(String.valueOf(Entrevista.qtdeParana));
		qtdeOutros.setText(String.valueOf(Entrevista.qtdeOutros));

		
	}
}
