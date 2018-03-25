import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Extrato extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private ContaBancaria conta;
	
	private JTable tblDados;
	
	public Extrato(ContaBancaria conta) {
		this.conta = conta;
		
		//------------------------------------------------------------
		// Configuração do Formulário
		setTitle("Extrato");
		setSize(820, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//------------------------------------------------------------
		// Botão Extrato Por Data
		JButton btnExtratoPorData = new JButton();
		btnExtratoPorData.setText("Extrato por Data");
		btnExtratoPorData.setFont(new Font("", Font.PLAIN, 12));
		btnExtratoPorData.setBounds(20, 20, 170, 20);
		btnExtratoPorData.addActionListener( (e) -> exibirExtratoPorData() );
		add(btnExtratoPorData);

		//------------------------------------------------------------
		// Botão Extrato Por Operacao
		JButton btnExtratoPorOperacao = new JButton();
		btnExtratoPorOperacao.setText("Extrato por Operação");
		btnExtratoPorOperacao.setFont(new Font("", Font.PLAIN, 12));
		btnExtratoPorOperacao.setBounds(20, 50, 170, 20);
		btnExtratoPorOperacao.addActionListener( (e) -> exibirExtratoPorOperacao());
		add(btnExtratoPorOperacao);

		//------------------------------------------------------------
		// Tabela Despesas
		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		dtm.addColumn("Operação");
		dtm.addColumn("Data");
		dtm.addColumn("Valor");
		dtm.addColumn("Saldo Anterior");
		dtm.addColumn("Saldo Atual");
		
		tblDados = new JTable(dtm);
	    tblDados.setRowHeight(21);
	    tblDados.getTableHeader().setReorderingAllowed(false);
	    tblDados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDados.getColumnModel().getColumn(0).setPreferredWidth(100); // Operação
		tblDados.getColumnModel().getColumn(0).setResizable(false);
		tblDados.getColumnModel().getColumn(1).setPreferredWidth(110); // Data
		tblDados.getColumnModel().getColumn(1).setResizable(false);
		tblDados.getColumnModel().getColumn(2).setPreferredWidth(110); // Valor
		tblDados.getColumnModel().getColumn(2).setResizable(false);
		tblDados.getColumnModel().getColumn(3).setPreferredWidth(120); // Saldo Anterior
		tblDados.getColumnModel().getColumn(3).setResizable(false);
		tblDados.getColumnModel().getColumn(4).setPreferredWidth(120); // Saldo Atual
		tblDados.getColumnModel().getColumn(4).setResizable(false);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setViewportView(tblDados);
	    scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollTable.getViewport().setBackground(Color.WHITE);
	    scrollTable.setBounds(220, 20, 580, 340);
		this.add(scrollTable);
		
	}
	
	private void exibirExtratoPorData() {
	
		conta.getOperacoes().sort( (data1, data2) -> data1.getData().compareTo(data2.getData()));
		
		preencherTabela();
	}

	
	private void exibirExtratoPorOperacao() {
		
		conta.getOperacoes().sort( (op1, op2) -> Character.compare(op1.getTipo(), op2.getTipo()));
		
		preencherTabela();
	}

	private void preencherTabela() {
		DefaultTableModel dtm = (DefaultTableModel)tblDados.getModel();
		
		while (dtm.getRowCount() > 0)
			dtm.removeRow(0);
			
		for (Operacao operacao : conta.getOperacoes()) {
	
			dtm.addRow(new Object[] {operacao.getTipo(),
					                 operacao.getData(),
					                 operacao.getValor(),
					                 operacao.getSaldoAnterior(),
					                 operacao.getSaldoAtual() } );
		}
	}
}















