package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import beans.Bebida;
import bebidasDAO.Controller;
import bebidasDAO.DAO;

public class BebidaView extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel lblBebida;
	private JTextField edtBebida;

	private JLabel lblMateriaPrima;
	private JTextField edtMateriaPrima;

	private JLabel lblTradicionalidade;
	private JTextField edtTradicionalidade;

	private JLabel lblTeorAlcoolico;
	private JTextField edtTeorAlcoolico;

	private JButton btnAdicionarBebida;
	private JButton btnExcluirBebida;
	private JButton btnAlterarBebida;
	private JButton btnConfirmarBebida;
	private JButton btnCancelarBebida;

	private List<Bebida> bebidas = new ArrayList<Bebida>();

	private DefaultTableModel tableModel;
	private JScrollPane scrollTable;
	private JTable tblDados;

	private Controller contr;

	public BebidaView() {
		// --------------------------------------------------------------------------------
		// Criando os componentes do formulário
		lblBebida = new JLabel();
		lblBebida.setText("Bebida");
		lblBebida.setBounds(10, 10, 130, 20); // 10 = x, 10 = y, 130 = width, 20
												// =
												// height
		edtBebida = new JTextField();
		edtBebida.setBounds(150, 10, 200, 20);

		lblMateriaPrima = new JLabel();
		lblMateriaPrima.setText("Matéria Prima");
		lblMateriaPrima.setBounds(10, 40, 130, 20);
		edtMateriaPrima = new JTextField();
		edtMateriaPrima.setBounds(150, 40, 200, 20);

		lblTradicionalidade = new JLabel();
		lblTradicionalidade.setText("Tradicionalidade");
		lblTradicionalidade.setBounds(10, 70, 130, 20);
		edtTradicionalidade = new JTextField();
		edtTradicionalidade.setBounds(150, 70, 200, 20);

		lblTeorAlcoolico = new JLabel();
		lblTeorAlcoolico.setText("Teor Alcoólico");
		lblTeorAlcoolico.setBounds(10, 100, 130, 20);
		edtTeorAlcoolico = new JTextField();
		edtTeorAlcoolico.setBounds(150, 100, 200, 20);

		btnAdicionarBebida = new JButton();
		btnAdicionarBebida.setText("Adicionar");
		btnAdicionarBebida.setBounds(10, 130, 130, 20);
		btnAdicionarBebida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionarBebida();
			}
		});
		btnExcluirBebida = new JButton();
		btnExcluirBebida.setText("Excluir");
		btnExcluirBebida.setBounds(150, 130, 130, 20);
		btnExcluirBebida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				excluirBebida();
			}
		});
		btnAlterarBebida = new JButton();
		btnAlterarBebida.setText("Alterar");
		btnAlterarBebida.setBounds(10, 160, 130, 20);
		btnAlterarBebida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alterarBebida();
			}
		});
		// OBS: ESTE BOTÃO SERÁ EXIBIDO NA MESMA POSIÇÃO DO BOTÃO 'ALTERAR'
		// APENAS QUANDO O USUÁRIO
		// CLICAR NO BOTÃO 'ALTERAR'
		btnConfirmarBebida = new JButton();
		btnConfirmarBebida.setText("Confirmar");
		btnConfirmarBebida.setBounds(10, 160, 130, 20);
		btnConfirmarBebida.setVisible(false);
		btnConfirmarBebida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmarAlteracao();
			}
		});
		btnCancelarBebida = new JButton();
		btnCancelarBebida.setText("Cancelar");
		btnCancelarBebida.setBounds(150, 160, 130, 20);
		btnCancelarBebida.setEnabled(false);
		btnCancelarBebida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarAlteracao();
			}
		});

		String cols[] = { "Nome", "Matéria Prima", "Tradicionalidade", "Teor Alcoólico" };
		tableModel = new DefaultTableModel(0, cols.length);
		tableModel.setColumnIdentifiers(cols);
		scrollTable = new JScrollPane();
		tblDados = new JTable(tableModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tblDados.getTableHeader().setPreferredSize(new Dimension(scrollTable.getWidth(), 21));
		tblDados.setRowHeight(21);
		tblDados.getTableHeader().setReorderingAllowed(false);
		tblDados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDados.getColumnModel().getColumn(0).setPreferredWidth(60);
		tblDados.getColumnModel().getColumn(0).setResizable(false);
		tblDados.getColumnModel().getColumn(1).setPreferredWidth(150);
		tblDados.getColumnModel().getColumn(1).setResizable(false);
		tblDados.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblDados.getColumnModel().getColumn(2).setResizable(false);
		tblDados.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblDados.getColumnModel().getColumn(3).setResizable(false);

		scrollTable.setViewportView(tblDados);
		scrollTable.setBounds(370, 10, 505, 390);
		scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTable.getViewport().setBackground(Color.WHITE);

		// --------------------------------------------------------------------------------
		// Adicionando os componentes no formulário
		this.getContentPane().add(lblBebida);
		this.getContentPane().add(edtBebida);
		this.getContentPane().add(lblMateriaPrima);
		this.getContentPane().add(edtMateriaPrima);
		this.getContentPane().add(lblTradicionalidade);
		this.getContentPane().add(edtTradicionalidade);
		this.getContentPane().add(lblTeorAlcoolico);
		this.getContentPane().add(edtTeorAlcoolico);
		this.getContentPane().add(btnAdicionarBebida);
		this.getContentPane().add(btnExcluirBebida);
		this.getContentPane().add(btnAlterarBebida);
		this.getContentPane().add(btnConfirmarBebida);
		this.getContentPane().add(btnCancelarBebida);
		this.getContentPane().add(scrollTable);

		// --------------------------------------------------------------------------------
		// Configuração do formulário
		this.setTitle("Cadastro de Bebidas");
		this.setSize(900, 500);
		this.setResizable(false); // Não permite que usuário aumente ou diminua
									// a tela
		this.setLocationRelativeTo(null); // Centraliza a tela no monitor
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null); // Desativa o gerenciado de layout padrão da tela.

		preencherTabela();
	}

	private void adicionarBebida() {
		// Criando um novo objeto (Bebida)
		Bebida bebida = new Bebida();

		// Preenchendo o objeto (Bebida)
		bebida.setBebida(edtBebida.getText());
		bebida.setMateriaPrima(edtMateriaPrima.getText());
		bebida.setTradicionalidade(edtTradicionalidade.getText());
		bebida.setTeorAlcoolico(edtTeorAlcoolico.getText());

		// Adicionando o objeto (Bebida) na lista (Lista de Bebidas)
		bebidas.add(bebida);

		// Obtendo o modelo da tabela (É através do modelo que manipulamos a
		// tabela)
		DefaultTableModel model = (DefaultTableModel) tblDados.getModel();

		// Adicionando o conteúdo nas colunas da tabela através do modelo
		model.addRow(new Object[] { bebida.getBebida(), bebida.getMateriaPrima(), bebida.getTradicionalidade(),
				bebida.getTeorAlcoolico() });

		// Limpando o conteúdo dos campos de entrada de dados.
		edtBebida.setText("");
		edtMateriaPrima.setText("");
		edtTradicionalidade.setText("");
		edtTeorAlcoolico.setText("");

		// Movendo o cursor para o campo 'Bebida'
		edtBebida.requestFocus();

		contr = new Controller();

		contr.inserir(bebida);
	}

	private void excluirBebida() {
		if (tblDados.getSelectedRow() == -1) { // Verificando se tem uma linha
												// selecionada na tabela
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma bebida para exclusão", "Operação inválida",
					JOptionPane.ERROR_MESSAGE);
		} else {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o ítem selecionado?",
					"Excluir ítem", JOptionPane.YES_NO_OPTION);
			if (resposta == JOptionPane.YES_OPTION) {
				// Obtendo a linha selecionada na tabela
				int itemSelecionado = tblDados.getSelectedRow();

				// Obtendo o modelo da tabela (É através do modelo que
				// manipulamos a tabela)
				DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();

				// Excluindo a lina
				dtm.removeRow(itemSelecionado);
				bebidas.remove(itemSelecionado);
				contr = new Controller();
				contr.excluir(itemSelecionado);
			}
		}
	}

	private void alterarBebida() {
		if (tblDados.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma bebida para exclusão", "Operação inválida",
					JOptionPane.ERROR_MESSAGE);
		} else {
			// Obtendo a linha selecionada na tabela
			int itemSelecionado = tblDados.getSelectedRow();

			// Obtendo o modelo da tabela (É através do modelo que manipulamos a
			// tabela)
			DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();

			// Obtendo os dados da linha e armazenando em variáveis
			String bebida = (String) dtm.getValueAt(itemSelecionado, 0);
			String materiaPrima = (String) dtm.getValueAt(itemSelecionado, 1);
			String tradicionalidade = (String) dtm.getValueAt(itemSelecionado, 2);
			String teorAlcoolico = (String) dtm.getValueAt(itemSelecionado, 3);

			// Preenchendo os campos com o conteúdos das variáveis
			edtBebida.setText(bebida);
			edtMateriaPrima.setText(materiaPrima);
			edtTradicionalidade.setText(tradicionalidade);
			edtTeorAlcoolico.setText(teorAlcoolico);

			// Desabilitando os botões
			btnAdicionarBebida.setEnabled(false);
			btnExcluirBebida.setEnabled(false);
			btnAlterarBebida.setVisible(false);
			btnConfirmarBebida.setVisible(true);
			btnCancelarBebida.setEnabled(true);

			// Desabilitando a tabela
			tblDados.setEnabled(false);
		}
	}

	private void confirmarAlteracao() {
		// Obtendo a linha selecionada na tabela
		int itemSelecionado = tblDados.getSelectedRow();

		// Obtendo o modelo da tabela (É através do modelo que manipulamos a
		// tabela)
		DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();

		// Atualizando a tabela com os novos valores
		dtm.setValueAt(edtBebida.getText(), itemSelecionado, 0);
		dtm.setValueAt(edtMateriaPrima.getText(), itemSelecionado, 1);
		dtm.setValueAt(edtTradicionalidade.getText(), itemSelecionado, 2);
		dtm.setValueAt(edtTeorAlcoolico.getText(), itemSelecionado, 3);

		// Atualizando o objeto com os novos valores
		Bebida bebida = bebidas.get(itemSelecionado);
		bebida.setBebida(edtBebida.getText());
		bebida.setMateriaPrima(edtMateriaPrima.getText());
		bebida.setTradicionalidade(edtTradicionalidade.getText());
		bebida.setTeorAlcoolico(edtTeorAlcoolico.getText());

		// Limpando o conteúdo dos campos de entrada de dados.
		edtBebida.setText("");
		edtMateriaPrima.setText("");
		edtTradicionalidade.setText("");
		edtTeorAlcoolico.setText("");

		// Habilitando os botões
		btnAdicionarBebida.setEnabled(true);
		btnExcluirBebida.setEnabled(true);
		btnAlterarBebida.setVisible(true);
		btnConfirmarBebida.setVisible(false);
		btnCancelarBebida.setEnabled(false);

		// Habilitando a tabela
		tblDados.setEnabled(true);
	}

	private void cancelarAlteracao() {
		// Limpando o conteúdo dos campos de entrada de dados.
		edtBebida.setText("");
		edtMateriaPrima.setText("");
		edtTradicionalidade.setText("");
		edtTeorAlcoolico.setText("");

		// Habilitando os botões
		btnAdicionarBebida.setEnabled(true);
		btnExcluirBebida.setEnabled(true);
		btnAlterarBebida.setVisible(true);
		btnConfirmarBebida.setVisible(false);
		btnCancelarBebida.setEnabled(false);

		// Habilitando a tabela
		tblDados.setEnabled(true);
	}

	private void preencherTabela() {
		List beb = contr.listar();

		DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();

		Bebida bebida;

		for (int i = 0; i < beb.size(); i++) {
			bebida = (Bebida) beb.get(i);

			dtm.addRow(new Object[] { bebida.getCodigo(),
									  bebida.getBebida(),
									  bebida.getMateriaPrima(), 
									  bebida.getTradicionalidade(),
									  bebida.getTeorAlcoolico() });
		}

	}

}