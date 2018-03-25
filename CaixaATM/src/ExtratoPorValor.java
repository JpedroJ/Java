import java.util.Comparator;

public class ExtratoPorValor implements Comparator<Operacao> {

	@Override
	public int compare(Operacao o1, Operacao o2) {
		return Double.compare(o1.getValor(), o2.getValor());
	}

}
