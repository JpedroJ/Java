package despesas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DespesasView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> fldCategoria;
	private JTextField fldDescricao;
	private JTextField fldDataPagamento;
	private JTextField fldValor;

	private JButton btnIncluir;
	private JButton btnCancelar;

	JTable tblDados;

	private JButton btnEditar;
	private JButton btnExcluir;

	private DespesasController controller;
	private Integer codigoDespesaEmEdicao;

	public DespesasView() {
		// ------------------------------------------------------------
		// Configuração do Formulário
		setTitle("Controle de Despesas Pessoais");
		setSize(1000, 520);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ------------------------------------------------------------
		// Campo Categoria
		JLabel lblCategoria = new JLabel();
		lblCategoria.setText("Categoria: *");
		lblCategoria.setFont(new Font("", Font.PLAIN, 12));
		lblCategoria.setBounds(20, 20, 120, 20);
		add(lblCategoria);

		fldCategoria = new JComboBox<>();
		fldCategoria.addItem("--selecione--");
		fldCategoria.addItem("Alimentação");
		fldCategoria.addItem("Carro");
		fldCategoria.addItem("Casa");
		fldCategoria.addItem("Farmácia");
		fldCategoria.setBounds(145, 20, 200, 20);
		add(fldCategoria);

		// ------------------------------------------------------------
		// Campo Descrição
		JLabel lblDescricao = new JLabel();
		lblDescricao.setText("Descrição: *");
		lblDescricao.setFont(new Font("", Font.PLAIN, 12));
		lblDescricao.setBounds(20, 50, 120, 20);
		add(lblDescricao);

		fldDescricao = new JTextField();
		fldDescricao.setText("");
		fldDescricao.setBounds(145, 50, 200, 20);
		add(fldDescricao);

		// ------------------------------------------------------------
		// Campo Data pagamento
		JLabel lblDataPagamento = new JLabel();
		lblDataPagamento.setText("Data pagamento: *");
		lblDataPagamento.setFont(new Font("", Font.PLAIN, 12));
		lblDataPagamento.setBounds(20, 80, 120, 20);
		add(lblDataPagamento);

		fldDataPagamento = new JTextField();
		fldDataPagamento.setText("");
		fldDataPagamento.setBounds(145, 80, 200, 20);
		add(fldDataPagamento);

		// -----------------------------------------------------------
		// Campo Valor
		JLabel lblValor = new JLabel();
		lblValor.setText("Valor: *");
		lblValor.setFont(new Font("", Font.PLAIN, 12));
		lblValor.setBounds(20, 110, 120, 20);
		add(lblValor);

		fldValor = new JTextField();
		fldValor.setText("");
		fldValor.setBounds(145, 110, 200, 20);
		add(fldValor);

		// ------------------------------------------------------------
		// Botão Incluir
		btnIncluir = new JButton();
		btnIncluir.setText("Incluir Despesa");
		btnIncluir.setFont(new Font("", Font.PLAIN, 12));
		btnIncluir.setBounds(20, 150, 130, 25);
		btnIncluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnIncluir.getText().equals("Incluir Despesa"))
					incluirDespesa();
				else if (btnIncluir.getText().equals("Salvar Edição"))
					salvarEdicaoDespesa();
			}
		});
		add(btnIncluir);

		// ------------------------------------------------------------
		// Botão Cancelar
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar Edição");
		btnCancelar.setFont(new Font("", Font.PLAIN, 12));
		btnCancelar.setBounds(160, 150, 140, 25);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarEdicaoDespesa();
			}
		});
		add(btnCancelar);

		// ------------------------------------------------------------
		// Tabela Despesas
		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.addColumn("Código");
		dtm.addColumn("Categoria");
		dtm.addColumn("Descrição");
		dtm.addColumn("Valor");
		dtm.addColumn("Pagamento");

		tblDados = new JTable(dtm);
		tblDados.setRowHeight(21);
		tblDados.getTableHeader().setReorderingAllowed(false);
		tblDados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDados.getColumnModel().getColumn(0).setPreferredWidth(0); // Código
		tblDados.getColumnModel().getColumn(0).setResizable(false);
		tblDados.getColumnModel().getColumn(1).setPreferredWidth(140); // Categoria
		tblDados.getColumnModel().getColumn(1).setResizable(false);
		tblDados.getColumnModel().getColumn(2).setPreferredWidth(220); // Descrição
		tblDados.getColumnModel().getColumn(2).setResizable(false);
		tblDados.getColumnModel().getColumn(3).setPreferredWidth(100); // Valor
		tblDados.getColumnModel().getColumn(3).setResizable(false);
		tblDados.getColumnModel().getColumn(4).setPreferredWidth(100); // Data
																		// Pagamento
		tblDados.getColumnModel().getColumn(4).setResizable(false);
		tblDados.removeColumn(tblDados.getColumnModel().getColumn(0)); // Oculta
																		// a
																		// coluna
																		// Código

		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setViewportView(tblDados);
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTable.getViewport().setBackground(Color.WHITE);
		scrollTable.setBounds(380, 20, 600, 420);
		this.add(scrollTable);

		// ------------------------------------------------------------
		// Botão editar
		btnEditar = new JButton();
		btnEditar.setText("Editar Despesa");
		btnEditar.setFont(new Font("", Font.PLAIN, 12));
		btnEditar.setBounds(690, 450, 140, 25);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editarDespesa();
			}
		});
		add(btnEditar);

		// ------------------------------------------------------------
		// Botão excluir
		btnExcluir = new JButton();
		btnExcluir.setText("Excluir Despesa");
		btnExcluir.setFont(new Font("", Font.PLAIN, 12));
		btnExcluir.setBounds(840, 450, 140, 25);
		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirDespesa();
			}
		});
		add(btnExcluir);

		btnCancelar.setVisible(false);

		controller = new DespesasController();

		preencherTabelaDespesas();
	}

	private void incluirDespesa() {
		// Recupera os dados do formulário de entrada
		String categoriaStr = fldCategoria.getItemAt(fldCategoria.getSelectedIndex());
		String descricaoStr = fldDescricao.getText().trim();
		String valorStr = fldValor.getText().trim();
		String dataPagamentoStr = fldDataPagamento.getText().trim();

		// Verifica se todos os campos foram preenchidos
		if (categoriaStr.equals("--selecione--") || descricaoStr.isEmpty() || valorStr.isEmpty()
				|| dataPagamentoStr.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Verifique se todos os campos assinalados por um asterisco foram preenchidos.",
					"Campos obrigatórios não preenchidos", JOptionPane.ERROR_MESSAGE);
			return;
		}

		DespesaModel despesa = new DespesaModel();
		despesa.setCategoria(categoriaStr);
		despesa.setDescricao(descricaoStr);
		despesa.setValor(Double.parseDouble(valorStr));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data = sdf.parse(dataPagamentoStr);
			despesa.setDataPagamento(data);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// TODO Inserir os dados contidos no objeto no banco de dados

		controller.inserir(despesa);

		// Mostra na tabela os dados da despesa
		DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();
		dtm.addRow(new Object[] { despesa.getCodigo(), categoriaStr, descricaoStr, valorStr, dataPagamentoStr });

		// Limpa os campos do formulário para uma nova entrada
		fldCategoria.setSelectedIndex(0);
		fldDescricao.setText("");
		fldValor.setText("");
		fldDataPagamento.setText("");

		JOptionPane.showMessageDialog(this, "Os dados da despesa foram incluídos com sucesso!",
				"Operação realizada com sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	private void salvarEdicaoDespesa() {
		DespesaModel despesa = new DespesaModel();
		despesa.setCodigo(codigoDespesaEmEdicao);
		despesa.setCategoria((String) fldCategoria.getSelectedItem());
		despesa.setDescricao(fldDescricao.getText());
		despesa.setValor(Double.parseDouble(fldValor.getText()));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

		try {
			despesa.setDataPagamento(sdf.parse(fldDataPagamento.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		controller.alterar(despesa);
		DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();
		dtm.setValueAt(fldCategoria.getSelectedItem(), tblDados.getSelectedRow(), 1);
		dtm.setValueAt(fldDescricao.getText(), tblDados.getSelectedRow(), 2);
		dtm.setValueAt(fldValor.getText(), tblDados.getSelectedRow(), 3);
		dtm.setValueAt(fldDataPagamento.getText(), tblDados.getSelectedRow(), 4);

		// Limpa os campos do formulário para uma nova entrada
		fldCategoria.setSelectedIndex(0);
		fldDescricao.setText("");
		fldValor.setText("");
		fldDataPagamento.setText("");

		btnIncluir.setText("Incluir Despesa");
		btnCancelar.setVisible(false);
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);

		JOptionPane.showMessageDialog(this, "Os dados da despesa foram salvos com sucesso!",
				"Operação realizada com sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	private void cancelarEdicaoDespesa() {
		// Limpa os campos do formulário para uma nova entrada
		fldCategoria.setSelectedIndex(0);
		fldDescricao.setText("");
		fldValor.setText("");
		fldDataPagamento.setText("");

		btnIncluir.setText("Incluir Despesa");
		btnCancelar.setVisible(false);
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);
	}

	private void editarDespesa() {
		if (tblDados.getSelectedRow() > -1) {

			DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();

			int codigo = (Integer) dtm.getValueAt(tblDados.getSelectedRow(), 0);
			String categoria = (String) dtm.getValueAt(tblDados.getSelectedRow(), 1);
			String descricao = (String) dtm.getValueAt(tblDados.getSelectedRow(), 2);
			String valor = (String) dtm.getValueAt(tblDados.getSelectedRow(), 3);
			String data = (String) dtm.getValueAt(tblDados.getSelectedRow(), 4);

			fldCategoria.setSelectedItem(categoria);
			fldDescricao.setText(descricao);
			fldValor.setText(valor);
			fldDataPagamento.setText(data);

			codigoDespesaEmEdicao = codigo;

			btnIncluir.setText("Salvar Edição");
			btnCancelar.setVisible(true);
			btnEditar.setEnabled(false);
			btnExcluir.setEnabled(false);
		}
	}

	private void excluirDespesa() {
		if (tblDados.getSelectedRow() > -1) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir a despesa selecionada?",
					"Excluir despesa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (resposta == JOptionPane.YES_OPTION) {
				DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();
				int codigo = (Integer) dtm.getValueAt(tblDados.getSelectedRow(), 0);

				controller.excluir(codigo);

				System.out.println(codigo);
				dtm.removeRow(tblDados.getSelectedRow());

				JOptionPane.showMessageDialog(null, "Os dados da despesa foram excluídos com sucesso!",
						"Operação realizada com sucesso!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void preencherTabelaDespesas() {
		List despesas = controller.listar();

		DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();
		DespesaModel despesa;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		for (int i = 0; i < despesas.size(); i++) {
			despesa = (DespesaModel) despesas.get(i);
			dtm.addRow(new Object[] { despesa.getCodigo(), despesa.getCategoria(), despesa.getDescricao(),
					String.valueOf(despesa.getValor()), sdf.format(despesa.getDataPagamento()) });
		}
	}

	public static void main(String[] args) {
		new DespesasView().setVisible(true);
	}

}
