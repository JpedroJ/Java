package Controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import OrdenarPorNome.ClienteOrdenadoPorNome;
import View.ClienteView;

public class BuscarActionListener implements ActionListener {

	ClienteView cliente;
	JTable tblDados;
	private Controller controller;
	private JButton btnExcluir;
	private JButton btnOrdenacaoNome;
	private JList<Cliente> clientes;
	public BuscarActionListener(ClienteView clienteView) {
		this.cliente = clienteView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JFrame j = new JFrame("Lista de clientes");
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		j.setSize(700, 400);
		j.setResizable(false);
		j.setLocationRelativeTo(null);
		j.setLayout(null);
		
		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		dtm.addColumn("ID");
		dtm.addColumn("NOME");
		dtm.addColumn("IDADE");
		dtm.addColumn("TELEFONE");
		
		tblDados = new JTable(dtm);
	    tblDados.setRowHeight(15);
	    tblDados.getTableHeader().setReorderingAllowed(false);
	    tblDados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDados.getColumnModel().getColumn(0).setPreferredWidth(100); // ID
		tblDados.getColumnModel().getColumn(0).setResizable(false);
		tblDados.getColumnModel().getColumn(1).setPreferredWidth(100); // NOME
		tblDados.getColumnModel().getColumn(1).setResizable(false);
		tblDados.getColumnModel().getColumn(2).setPreferredWidth(120);  // IDADE
		tblDados.getColumnModel().getColumn(2).setResizable(false);
		tblDados.getColumnModel().getColumn(3).setPreferredWidth(100);  // TELEFONE
		tblDados.getColumnModel().getColumn(3).setResizable(false);
		 
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setViewportView(tblDados);
	    scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scrollTable.getViewport().setBackground(Color.WHITE);
	    scrollTable.setBounds(200, 20, 440, 150);
		j.add(scrollTable);
		
		btnOrdenacaoNome = new JButton("Listar por nome");
		btnOrdenacaoNome.setBounds(20, 20, 150, 50);
		btnOrdenacaoNome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Collections.sort(controller.listar(), new ClienteOrdenadoPorNome());
				//for (Cliente a : clientes) {
					
				}
				
			
		});
		j.add(btnOrdenacaoNome);
		
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(20, 80, 150, 50);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tblDados.getSelectedRow() > -1) {
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o cliente selecionado?",
							"Excluir despesa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (resposta == JOptionPane.YES_OPTION) {
						DefaultTableModel dtm = (DefaultTableModel) tblDados.getModel();
						int codigo = (Integer) dtm.getValueAt(tblDados.getSelectedRow(), 0);

						controller.excluir(codigo);

						System.out.println(codigo);
						dtm.removeRow(tblDados.getSelectedRow());

						JOptionPane.showMessageDialog(null, "Os dados do cliente foram exclui­dos com sucesso!",
								"Operação realizada com sucesso!", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		j.add(btnExcluir);
		
	}
	
	

}
