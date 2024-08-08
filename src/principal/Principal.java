package principal;

import java.util.Comparator;
import java.util.List;

import model.Funcionario;
import services.CargaDados;

public class Principal {
	public static void main(String[] args) {
		List<Funcionario> ads = new CargaDados().getListaFuncionarios();
		ads.stream().map(e -> e.getSalario().doubleValue()).forEach(System.out::println);
	}
}
