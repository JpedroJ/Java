package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.BuscarActionListener;
import Controller.Controller;
import Controller.SairActionListener;
import Model.Cliente;

public class ClienteView extends JFrame {

	private static final long serialVersionUID = -8221397679719287496L;

	//class da view do programa com toda a interface feita em JFRAME
	private JTextField edtNome;
	private JTextField edtIdade;
	private JTextField edtTelefone;
	private JButton btnCadastrar;
	private JButton btnBuscar;
	private JButton btnSair;
	private Controller controller;

	JTable tblDados;
	public ClienteView() {
		setTitle("Cadastro de Cliente");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel nome = new JLabel();
		nome.setText("NOME: ");
		nome.setBounds(20, 20, 50, 20);
		add(nome);

		JLabel idade = new JLabel();
		idade.setText("IDADE: ");
		idade.setBounds(20, 60, 50, 20);
		add(idade);

		JLabel telefone = new JLabel();
		telefone.setText("TELEFONE: ");
		telefone.setBounds(20, 100, 100, 20);
		add(telefone);

		edtNome = new JTextField();
		edtNome.setBounds(100, 20, 200, 20);
		add(edtNome);

		edtIdade = new JTextField();
		edtIdade.setBounds(100, 60, 200, 20);
		add(edtIdade);

		edtTelefone = new JTextField();
		edtTelefone.setBounds(100, 100, 200, 20);
		add(edtTelefone);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(20, 150, 100, 50);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeStr = edtNome.getText();
				String idadeStr = edtIdade.getText();
				String telefoneStr = edtTelefone.getText();
				
				if(nomeStr.isEmpty() || telefoneStr.isEmpty()){
					JOptionPane.showMessageDialog(null,"Alguns campos nao foram preenchidos",
							"Campos obrigatorios", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Cliente c = new Cliente();
				c.setNome(nomeStr);
				c.setIdade(idadeStr);
				c.setTelefone(telefoneStr);
				
				controller.inserir(c);
				
				DefaultTableModel dtm = (DefaultTableModel)tblDados.getModel();
				dtm.addRow(new Object[]{c.getIdCLiente(), nomeStr, idadeStr, telefoneStr});
				
				JOptionPane.showMessageDialog(null,
		                "Cliente Cadastrado",
		                "Operação realizada com sucesso",
		                JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(btnCadastrar);
		
		btnBuscar = new JButton("Buscar Clientes");
		btnBuscar.setBounds(150, 150, 130, 50);
		btnBuscar.addActionListener(new BuscarActionListener(this));
		add(btnBuscar);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(20, 220, 100, 50);
		btnSair.addActionListener(new SairActionListener(this));
		add(btnSair);
		
		
		
		
	}
}
