package simulador;

import java.util.Random;

import javax.swing.JButton;

public class AtendenteThread extends Thread {

	private SimuladorFilaAtendimento sfa = null;
	private JButton btnAtendente = null;

	public AtendenteThread(SimuladorFilaAtendimento sfa, JButton btnAtendente) {
		this.sfa = sfa;
		this.btnAtendente = btnAtendente;
	}

	@Override
	public void run() {
		Random tempoAtendimento = new Random();
		int tempoMinimo = 8000;   // 8 segundos
		int tempoMaximo = 15000;  // 15 segundos
		int tempo;
		
		String pessoa;
		String rotuloBotaoOriginal = btnAtendente.getText();
		while (!isInterrupted()) {
			pessoa = sfa.obterPessoa();
			if (pessoa == null) {
				btnAtendente.setText(rotuloBotaoOriginal);
				break;
			}
			btnAtendente.setText("<html>Atendendo " + pessoa + "</html>");
			try {
				tempo = tempoAtendimento.nextInt(tempoMaximo-tempoMinimo) + tempoMinimo;
				
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}










