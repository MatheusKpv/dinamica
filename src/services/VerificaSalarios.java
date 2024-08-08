package services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import model.DepartamentoEnum;
import model.Funcionario;

public class VerificaSalarios {

	public static void main(String[] args) {
		System.out.println(menorSalarioDepartamentos(CargaDados.getListaFuncionarios()));
		System.out.println(maiorSalarioDepartamentos(CargaDados.getListaFuncionarios()));
		System.out.println(mediaSalarioDepartamentos(CargaDados.getListaFuncionarios()));
		System.out.println(medianaSalarioDepartamentos(CargaDados.getListaFuncionarios()));
	}

	public static Map<DepartamentoEnum, Double> menorSalarioDepartamentos(List<Funcionario> funcionarios) {

		Map<DepartamentoEnum, Double> mapaMenorSalario = new HashMap<DepartamentoEnum, Double>();

		for (DepartamentoEnum departamento : DepartamentoEnum.values()) {

			mapaMenorSalario.put(departamento, funcionarios.stream().filter(f -> f.getCargo().equals(departamento))
					.map(m -> m.getSalario()).mapToDouble(value -> value.doubleValue()).min().orElse(0.0));
		}

		return mapaMenorSalario;
	}

	public static Map<DepartamentoEnum, Double> maiorSalarioDepartamentos(List<Funcionario> funcionarios) {

		Map<DepartamentoEnum, Double> mapaMaiorSalario = new HashMap<DepartamentoEnum, Double>();

		for (DepartamentoEnum departamento : DepartamentoEnum.values()) {

			mapaMaiorSalario.put(departamento, funcionarios.stream().filter(f -> f.getCargo().equals(departamento))
					.mapToDouble(m -> m.getSalario().doubleValue()).max().orElse(0.0));
		}
		return mapaMaiorSalario;
	}

	public static Map<DepartamentoEnum, BigDecimal> mediaSalarioDepartamentos(List<Funcionario> funcionarios) {

		Map<DepartamentoEnum, BigDecimal> mapaMediaSalario = new HashMap<DepartamentoEnum, BigDecimal>();

		for (DepartamentoEnum departamento : DepartamentoEnum.values()) {

			Map<BigDecimal, Long> frequencias = funcionarios.stream().filter(f -> f.getCargo().equals(departamento))
					.map(Funcionario::getSalario)
					.collect(Collectors.groupingBy(salario -> salario, Collectors.counting()));

			Optional<Map.Entry<BigDecimal, Long>> entrada = frequencias.entrySet().stream()
					.max(Map.Entry.comparingByValue());

			if (entrada.isPresent()) {
				BigDecimal moda = entrada.get().getKey().setScale(2, RoundingMode.HALF_EVEN);
				mapaMediaSalario.put(departamento, moda);
			}
		}
		return mapaMediaSalario;
	}

	public static Map<DepartamentoEnum, BigDecimal> modaSalarioDepartamentos(List<Funcionario> funcionarios) {
		Map<DepartamentoEnum, BigDecimal> modaSalarioDepartamentos = new HashMap<>();

		for (DepartamentoEnum departamento : DepartamentoEnum.values()) {
			Map<BigDecimal, Long> frequencias = funcionarios.stream().filter(f -> f.getCargo().equals(departamento))
					.map(Funcionario::getSalario)
					.collect(Collectors.groupingBy(salario -> salario, Collectors.counting()));

			Optional<Map.Entry<BigDecimal, Long>> modaEntry = frequencias.entrySet().stream()
					.max(Map.Entry.comparingByValue());

			if (modaEntry.isPresent()) {
				BigDecimal moda = modaEntry.get().getKey().setScale(2, RoundingMode.HALF_EVEN);
				modaSalarioDepartamentos.put(departamento, moda);
			} else {
				modaSalarioDepartamentos.put(departamento, BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN));
			}
		}
		return modaSalarioDepartamentos;
	}

	public static Map<DepartamentoEnum, Double> medianaSalarioDepartamentos(List<Funcionario> funcionarios) {

		Map<DepartamentoEnum, Double> mapaMedianaSalario = new HashMap<DepartamentoEnum, Double>();

		for (DepartamentoEnum departamento : DepartamentoEnum.values()) {

			List<Double> salarioFuncionario = funcionarios.stream().filter(f -> f.getCargo().equals(departamento))
					.map(value -> value.getSalario().doubleValue()).sorted().collect(Collectors.toList());
			;

			double mediana;
			if (salarioFuncionario.size() % 2 == 1) {

				mediana = salarioFuncionario.get(salarioFuncionario.size() / 2);

			} else {
				double meio1 = salarioFuncionario.get((salarioFuncionario.size() / 2) - 1);
				double meio2 = salarioFuncionario.get(salarioFuncionario.size() / 2);
				mediana = (meio1 + meio2) / 2.0;
			}
			mapaMedianaSalario.put(departamento, mediana);
		}
		return mapaMedianaSalario;
	}
}