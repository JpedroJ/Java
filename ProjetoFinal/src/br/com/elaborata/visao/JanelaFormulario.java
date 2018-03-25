package br.com.elaborata.visao;

import java.awt.GridLayout;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.elaborata.controle.LimparActionListener;
import br.com.elaborata.controle.OKActionListener;
import br.com.elaborata.modelo.TimeCoracao;

public class JanelaFormulario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JanelaResultado resultado;

	private JTextField idade = new JTextField();
	private ButtonGroup genero = new ButtonGroup();
	private JRadioButton masculino = new JRadioButton("Masculino");
	private JRadioButton feminino = new JRadioButton("Feminino");
	private JComboBox timeCoracao = new JComboBox<>();

	private Set entrevistados;
	
	public JanelaFormulario(){
		
	}
	
	public JanelaFormulario(Set entrevistados) {
		super("Formulario");
		this.entrevistados = entrevistados;

		setSize(400, 200);
		setLocation(50, 50);

		// criar painel
		JPanel painel = new JPanel();

		// configurar o gerenciador de layout
		GridLayout grid = new GridLayout(5, 2, 10, 10);

		painel.setLayout(grid);
		painel.setSize(400, 200);
		painel.setBorder(new EmptyBorder(10, 10, 10, 10));

		// adicionando o componente idade
		painel.add(new JLabel("Idade"));
		painel.add(idade);

		// adicionando genero
		painel.add(new JLabel("Genero"));
		genero.add(masculino);
		genero.add(feminino);
		painel.add(masculino);
		painel.add(new JLabel(""));
		painel.add(feminino);

		// adicionando time do coracao
		painel.add(new JLabel("Time do coração"));
		painel.add(timeCoracao);
		timeCoracao.addItem("--Selecione--");
		for (TimeCoracao time : TimeCoracao.values()) {
			timeCoracao.addItem(time.name());
		}
		// adicionando botoes
		JButton ok = new JButton("OK");
		ok.addActionListener(new OKActionListener(this));
		painel.add(ok);

		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new LimparActionListener(this));
		painel.add(limpar);
		
		

		add(painel);

		pack();
	}

	public final Set getEntrevistados() {
		return entrevistados;
	}

	public final void setEntrevistados(Set entrevistados) {
		this.entrevistados = entrevistados;
	}

	public JanelaResultado getResultado() {
		return resultado;
	}

	public void setResultado(JanelaResultado resultado) {
		this.resultado = resultado;
	}

	public JTextField getIdade() {
		return idade;
	}

	public void setIdade(JTextField idade) {
		this.idade = idade;
	}

	public ButtonGroup getGenero() {
		return genero;
	}

	public void setGenero(ButtonGroup genero) {
		this.genero = genero;
	}

	public JRadioButton getMasculino() {
		return masculino;
	}

	public void setMasculino(JRadioButton masculino) {
		this.masculino = masculino;
	}

	public JRadioButton getFeminino() {
		return feminino;
	}

	public void setFeminino(JRadioButton feminino) {
		this.feminino = feminino;
	}

	public JComboBox getTimeCoracao() {
		return timeCoracao;
	}

	public void setTimeCoracao(JComboBox timeCoracao) {
		this.timeCoracao = timeCoracao;
	}

}
