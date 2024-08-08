package services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Funcionario;

public class MaioresSalarios {

	// 1 - Pegar os lista de 10 funcionarios com maior salário

	

	public static List<Funcionario> filtraPorSalario(List<Funcionario> funcionarios) {

		List<Funcionario> funcionariosFiltrados = new ArrayList<Funcionario>();

		return funcionariosFiltrados = funcionarios.stream()
				.sorted(Comparator.comparing(Funcionario::getSalario).reversed())
				.limit(10)
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
