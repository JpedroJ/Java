package br.com.elaborata.visao;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import br.com.elaborata.controle.EncerrarPesquisa;
import br.com.elaborata.controle.SairActionListener;
import br.com.elaborata.controle.SobreActionListener;

public class JanelaPrincipal extends JFrame {
	
	
	
	private static final long serialVersionUID = 1L;

	
	private Set entrevistados = new HashSet<>();
	
	
	
	public JanelaPrincipal() {
		super("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Integer tolerancia = 10;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(tolerancia, tolerancia, (screenSize.width - tolerancia * 2), (screenSize.height - tolerancia * 2));

		// criar os menus
		JMenuBar menuBar = new JMenuBar();
		JMenu arquivo = new JMenu("Arquivo");
		JMenuItem encerrar = new JMenuItem("Encerrar pesquisa...");
		JSeparator separator = new JSeparator();
		JMenuItem sair = new JMenuItem("Sair...");

		JMenu ajuda = new JMenu("Ajuda");
		JMenuItem sobre = new JMenuItem("Sobre...");

		// adiciona os menus
		menuBar.add(arquivo);
		arquivo.add(encerrar);
		arquivo.setMnemonic(KeyEvent.VK_R);
		arquivo.add(separator);
		arquivo.add(sair);
		menuBar.add(ajuda);
		ajuda.add(sobre);
		setJMenuBar(menuBar);

		sobre.addActionListener(new SobreActionListener());
		sair.addActionListener(new SairActionListener());
		encerrar.addActionListener(new EncerrarPesquisa(entrevistados));
		
		// container para os componentes
		JDesktopPane desktopPane = new JDesktopPane();

		// criar o frame do formulario
		JanelaFormulario janelaFormulario = new JanelaFormulario(entrevistados);
		janelaFormulario.setVisible(true);
		desktopPane.add(janelaFormulario);

		// criar o frame do resusltado
		JanelaResultado janelaResultado = new JanelaResultado();
		janelaResultado.setVisible(true);
		desktopPane.add(janelaResultado);

		// adiciona ao frame
		setContentPane(desktopPane);

		janelaFormulario.setResultado(janelaResultado);

		// torna visivel
		setVisible(true);
	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}

}
