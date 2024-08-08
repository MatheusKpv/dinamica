package services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import model.Funcionario;

public class ImpactoReajuste {

	public static BigDecimal impactoReajusteFuncionario(List<Funcionario> funcionario) {

		DecimalFormat fmt = new DecimalFormat("0.00");

		BigDecimal somaSalario = funcionario.stream()
				.map(s -> s.getSalario())
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		BigDecimal reajusteSalario = funcionario.stream()
				.map(Funcionario::getSalario)
				.map(value -> value.add(value.multiply(new BigDecimal("0.1"))))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		BigDecimal impactoSalario = reajusteSalario.subtract(somaSalario).setScale(2, RoundingMode.HALF_EVEN);

		return  impactoSalario;
	}
}
