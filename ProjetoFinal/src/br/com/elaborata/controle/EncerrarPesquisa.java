package br.com.elaborata.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.elaborata.dao.PesquisaDAO;
import br.com.elaborata.modelo.Entrevistado;
import br.com.elaborata.modelo.Pesquisa;

public class EncerrarPesquisa implements ActionListener {
	
	private Set entrevistados;
	
	
	public EncerrarPesquisa() {
		
	}
	
	public EncerrarPesquisa(Set entrevistados){
		this.entrevistados = entrevistados;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int confirme = JOptionPane.showConfirmDialog(null, "Deseja realmente encerrar a pesquisa?", "Confirmação",
				JOptionPane.YES_NO_OPTION);
		if (confirme == JOptionPane.YES_OPTION) {
			Pesquisa pesquisa = new Pesquisa();
			pesquisa.setDataPesquisa(new Date());
			pesquisa.setEntrevistados(entrevistados);
			
			
			for(Object obj : entrevistados){
				((Entrevistado)obj).setPesquisa(pesquisa);
			}
			
			PesquisaDAO pesquisaDao = new PesquisaDAO();
			try {
				pesquisaDao.inserir(pesquisa);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			
				return;
			}
			
			
			String [] opcoes = {"Exportar para arquivo", "Enviar por e-mail", "Enviar por SMS"};
			JOptionPane.showOptionDialog(null, "Como deseja enviar a pesquisa? ","Resultado da pesquisa", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
		}

	}

}
