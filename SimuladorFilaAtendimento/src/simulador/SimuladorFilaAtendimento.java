package simulador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SimuladorFilaAtendimento extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Font FONTE_PADRAO = new Font("", Font.PLAIN, 12);

	private JTextField fldQtdePessoasNaFila;

	private JButton btnCriarCenario;
	private JButton btnIniciarSimulacao;
	private JButton btnPararSimulacao;
	
	private JList<String> fldFila;
	private JPanel pnlAtendentes;

	private JButton btnAtendente1;
	private JButton btnAtendente2;
	private JButton btnAtendente3;
	private JButton btnAtendente4;

	public SimuladorFilaAtendimento() {

		setSize(800, 370);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JLabel lblQtdePessoasNaFila = new JLabel();
		lblQtdePessoasNaFila.setText("Quantidade pessoas na fila:");
		lblQtdePessoasNaFila.setFont(FONTE_PADRAO);
		lblQtdePessoasNaFila.setBounds(20, 20, 180, 20);
		add(lblQtdePessoasNaFila);

		fldQtdePessoasNaFila = new JTextField();
		fldQtdePessoasNaFila.setBounds(200, 20, 80, 20);
		add(fldQtdePessoasNaFila);


		btnCriarCenario = new JButton();
		btnCriarCenario.setText("Criar Cenário");
		btnCriarCenario.setFont(FONTE_PADRAO);
		btnCriarCenario.setBounds(300, 20, 120, 25);
		btnCriarCenario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				criarCenario();
			}
		});
		add(btnCriarCenario);


		btnIniciarSimulacao = new JButton();
		btnIniciarSimulacao.setText("Iniciar Simulação");
		btnIniciarSimulacao.setFont(FONTE_PADRAO);
		btnIniciarSimulacao.setBounds(440, 20, 140, 25);
		btnIniciarSimulacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarSimulacao();
			}
		});
		add(btnIniciarSimulacao);


		btnPararSimulacao = new JButton();
		btnPararSimulacao.setText("Parar Simulação");
		btnPararSimulacao.setFont(FONTE_PADRAO);
		btnPararSimulacao.setBounds(440, 55, 140, 25);
		btnPararSimulacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pararSimulacao();
			}
		});
		add(btnPararSimulacao);


		JLabel lblFila = new JLabel();
		lblFila.setText("Fila");
		lblFila.setFont(FONTE_PADRAO);
		lblFila.setBounds(20, 110, 180, 20);
		add(lblFila);

		fldFila = new JList<>();
		fldFila.setFont(FONTE_PADRAO);

		JScrollPane scrollFila = new JScrollPane(fldFila);
		scrollFila.setBounds(20, 130, 150, 200);
		add(scrollFila);


		JLabel lblAtendentes = new JLabel();
		lblAtendentes.setText("Atendentes");
		lblAtendentes.setFont(FONTE_PADRAO);
		lblAtendentes.setBounds(190, 110, 180, 20);
		add(lblAtendentes);

		pnlAtendentes = new JPanel();
		pnlAtendentes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		pnlAtendentes.setBounds(190, 130, 590, 200);
		pnlAtendentes.setLayout(null);
		add(pnlAtendentes);
		
		btnAtendente1 = new JButton();
		btnAtendente1.setText("Atendente 1");
		btnAtendente1.setFont(FONTE_PADRAO);
		btnAtendente1.setBounds(20, 20, 120, 50);

		pnlAtendentes.add(btnAtendente1);

		btnAtendente2 = new JButton();
		btnAtendente2.setText("Atendente 2");
		btnAtendente2.setFont(FONTE_PADRAO);
		btnAtendente2.setBounds(160, 20, 120, 50);
		pnlAtendentes.add(btnAtendente2);

		btnAtendente3 = new JButton();
		btnAtendente3.setText("Atendente 3");
		btnAtendente3.setFont(FONTE_PADRAO);
		btnAtendente3.setBounds(300, 20, 120, 50);
		pnlAtendentes.add(btnAtendente3);

		btnAtendente4 = new JButton();
		btnAtendente4.setText("Atendente 4");
		btnAtendente4.setFont(FONTE_PADRAO);
		btnAtendente4.setBounds(440, 20, 120, 50);
		pnlAtendentes.add(btnAtendente4);
		
        btnCriarCenario.setEnabled(true);
        btnIniciarSimulacao.setEnabled(true);
		btnPararSimulacao.setEnabled(false);
	}

	private void criarCenario() {
		int qtdePessoasNaFila = Integer.parseInt(fldQtdePessoasNaFila.getText());

		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i=100; i < (100+qtdePessoasNaFila); i++) {
			listModel.addElement(String.valueOf(i));
		}
		fldFila.setModel(listModel);

	}

	private void iniciarSimulacao() {
        btnCriarCenario.setEnabled(false);
        btnIniciarSimulacao.setEnabled(false);
		btnPararSimulacao.setEnabled(true);
		
		AtendenteThread atendente1 = new AtendenteThread(this,  btnAtendente1);
		AtendenteThread atendente2 = new AtendenteThread(this,  btnAtendente2);
		AtendenteThread atendente3 = new AtendenteThread(this,  btnAtendente3);
		AtendenteThread atendente4 = new AtendenteThread(this,  btnAtendente4);
		
		atendente1.start();
		atendente2.start();
		atendente3.start();
		atendente4.start();
	}

	private void pararSimulacao() {
        btnCriarCenario.setEnabled(true);
        btnIniciarSimulacao.setEnabled(true);
		btnPararSimulacao.setEnabled(false);
	}

	synchronized public String obterPessoa() {
		DefaultListModel<String> pessoas = (DefaultListModel<String>)fldFila.getModel();
		
		String pessoa = null;
		if (pessoas.size() > 0) {
			pessoa = pessoas.getElementAt(0);
			pessoas.remove(0);
		}	
		return pessoa;
			
	}

	public static void main(String[] args) {
		new SimuladorFilaAtendimento().setVisible(true);

	}

}










