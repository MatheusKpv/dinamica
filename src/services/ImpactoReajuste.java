package services;

import java.math.BigDecimal;
import java.util.List;

import model.Funcionario;

public class ImpactoReajuste {

	public static void main(String[] args) {
		CargaDados c = new CargaDados();
		System.out.println(impactoReajusteFuncionario(c.getListaFuncionarios()));
	}
	
	public static double impactoReajusteFuncionario(List<Funcionario> funcionario) {
		
		double somaSalario = funcionario.stream()
		.map(s -> s.getSalario())
		.mapToDouble(BigDecimal::doubleValue)
		.sum();
		
		return somaSalario;
		
		
		
	}
}
