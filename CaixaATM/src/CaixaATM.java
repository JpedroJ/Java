import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CaixaATM extends JFrame  {
	
	private static final long serialVersionUID = 1L;

	private JComboBox<String> fldConta;
	
	private JButton btnAdicionarConta;
	private JButton btnIniciarCaixaATM;
	private JButton btnSacar;
	private JButton btnDepositar;
	private JButton btnSaldo;
	private JButton btnExtrato;
	private JButton btnFinalizarCaixaATM;
	
	private ContaBancaria conta = null;
	
	private static final String DIRETORIO = "/home/aluno/caixaatm";
	
	public CaixaATM() {
		//------------------------------------------------------------
		// Configuração do Formulário
		setTitle("Caixa ATM");
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//------------------------------------------------------------
		// Campo Conta
		JLabel lblConta = new JLabel();
		lblConta.setText("Conta:");
		lblConta.setFont(new Font("", Font.PLAIN, 12));
		lblConta.setBounds(20, 20, 50, 20);
		add(lblConta);
		
		fldConta = new JComboBox<>();
		fldConta.addItem("--selecione--");
		fldConta.setFont(new Font("", Font.PLAIN, 12));
		fldConta.setBounds(80, 20, 120, 20);
		add(fldConta);
		
		//------------------------------------------------------------
		// Botão adicionar conta
		btnAdicionarConta = new JButton();
		btnAdicionarConta.setText("Nova");
		btnAdicionarConta.setFont(new Font("", Font.PLAIN, 12));
		btnAdicionarConta.setBounds(210, 20, 70, 20);
		btnAdicionarConta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionarConta();
			}
		});
		add(btnAdicionarConta);

		//------------------------------------------------------------
		// Botão iniciar
		btnIniciarCaixaATM = new JButton();
		btnIniciarCaixaATM.setText("Iniciar Caixa ATM");
		btnIniciarCaixaATM.setFont(new Font("", Font.PLAIN, 12));
		btnIniciarCaixaATM.setBounds(20, 50, 260, 30);
		btnIniciarCaixaATM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarCaixaATM();
			}
		});
		add(btnIniciarCaixaATM);


		//------------------------------------------------------------
		// Botão sacar
		btnSacar = new JButton();
		btnSacar.setText("Sacar");
		btnSacar.setFont(new Font("", Font.PLAIN, 12));
		btnSacar.setBounds(20, 100, 120, 50);
		btnSacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				realizarSaque();
			}
		});
		add(btnSacar);

		//------------------------------------------------------------
		// Botão depositar
		btnDepositar = new JButton();
		btnDepositar.setText("Depositar");
		btnDepositar.setFont(new Font("", Font.PLAIN, 12));
		btnDepositar.setBounds(160, 100, 120, 50);
		btnDepositar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				realizarDeposito();
			}
		});
		add(btnDepositar);

		//------------------------------------------------------------
		// Botão saldo
		btnSaldo = new JButton();
		btnSaldo.setText("Saldo");
		btnSaldo.setFont(new Font("", Font.PLAIN, 12));
		btnSaldo.setBounds(20, 160, 120, 50);
		add(btnSaldo);

		//------------------------------------------------------------
		// Botão depositar
		btnExtrato = new JButton();
		btnExtrato.setText("Extrato");
		btnExtrato.setFont(new Font("", Font.PLAIN, 12));
		btnExtrato.setBounds(160, 160, 120, 50);
		btnExtrato.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirExtrato();
				
			}
		});

		add(btnExtrato);
		
		//------------------------------------------------------------
		// Botão finalizar
		btnFinalizarCaixaATM = new JButton();
		btnFinalizarCaixaATM.setText("Finalizar Caixa ATM");
		btnFinalizarCaixaATM.setFont(new Font("", Font.PLAIN, 12));
		btnFinalizarCaixaATM.setBounds(20, 230, 260, 30);
		btnFinalizarCaixaATM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizarCaixaATM();
			}
		});
		add(btnFinalizarCaixaATM);
		
		prepararBotoes(true);
		
		listarContas();
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				gravarConta();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void prepararBotoes(boolean status) {
		btnAdicionarConta.setEnabled(status);
		btnIniciarCaixaATM.setEnabled(status);
		btnSacar.setEnabled(!status);
		btnDepositar.setEnabled(!status);
		btnSaldo.setEnabled(!status);
		btnExtrato.setEnabled(!status);
		btnFinalizarCaixaATM.setEnabled(!status);
	}
	
	private void adicionarConta() {
		String numeroConta = JOptionPane.showInputDialog("Informe o número da conta: ");
		
		if (numeroConta != null) {
			fldConta.addItem(numeroConta);
		}
		
	}
	
	private void iniciarCaixaATM() {
		if (fldConta.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,
					                      "Selecione uma conta",
					                      "Operação inválida",
					                      JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		conta = carregarConta((String)fldConta.getSelectedItem());
		
		// TODO Inicializar um objeto do tipo Conta
		prepararBotoes(false);
	}

	private void realizarDeposito() {
		String valorStr = JOptionPane.showInputDialog("Informe o valor do depósito: ");
		
		if (valorStr == null){
			JOptionPane.showMessageDialog(null,
					                      "Valor do depósito não foi informado",
					                      "Depósito não realizado",
					                      JOptionPane.ERROR_MESSAGE);
		} else {
			double valor = Double.parseDouble(valorStr);

			Operacao operacao = new Operacao();
			operacao.setTipo('D');
			operacao.setData(new Date());
			operacao.setValor(valor);
			operacao.setSaldoAnterior(conta.getSaldo());

			conta.setSaldo(conta.getSaldo() + valor);
			operacao.setSaldoAtual(conta.getSaldo());

			conta.getOperacoes().add(operacao);
		}
		
	}

	private void realizarSaque() {
		String valorStr = JOptionPane.showInputDialog("Informe o valor do saque: ");
		
		if (valorStr == null){
			JOptionPane.showMessageDialog(null,
					                      "Valor do saque não foi informado",
					                      "Saque não realizado",
					                      JOptionPane.ERROR_MESSAGE);
		} else {
			double valor = Double.parseDouble(valorStr);

			if (conta.getSaldo() < valor) {
				JOptionPane.showMessageDialog(null,
						                      "Saldo atual insuficiente para realizar a operação",
						                      "Saldo insuficiente",
						                      JOptionPane.ERROR_MESSAGE);
				return;
			}

			Operacao operacao = new Operacao();
			operacao.setTipo('S');
			operacao.setData(new Date());
			operacao.setValor(valor);
			operacao.setSaldoAnterior(conta.getSaldo());

			conta.setSaldo(conta.getSaldo() - valor);
			operacao.setSaldoAtual(conta.getSaldo());
			
			conta.getOperacoes().add(operacao);
		}
		
	}

	private void exibirExtrato() {
		new Extrato(conta).setVisible(true);
	}
	
	private void finalizarCaixaATM() {
		gravarConta();
		
		prepararBotoes(true);
		
		fldConta.setSelectedIndex(0);
	}

	private void gravarConta() {
		try (
			FileOutputStream fos = new FileOutputStream(DIRETORIO + "/" + conta.getNumero());
			ObjectOutputStream out = new ObjectOutputStream(fos);
			)
		{
			out.writeObject(conta);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private ContaBancaria carregarConta(String numeroConta) {
		ContaBancaria contaBancaria = null;
		try (
			FileInputStream fis = new FileInputStream(DIRETORIO + "/" + numeroConta);
			ObjectInputStream in = new ObjectInputStream(fis);
			)
		{
			contaBancaria = (ContaBancaria)in.readObject();
		} catch (FileNotFoundException e) {
			contaBancaria = new ContaBancaria();
			contaBancaria.setNumero(numeroConta);
			contaBancaria.setSaldo(0);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contaBancaria;
	}
	
	private void listarContas() {
		File dir = new File(DIRETORIO);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				fldConta.addItem(file.getName());
			}
		}
		
	}
	
	public static void main(String[] args) {
		new CaixaATM().setVisible(true);
	}

}







