package services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.DepartamentoEnum;
import model.Funcionario;

public class MaiorOrcamento {

	    public DepartamentoEnum getDepartamentoComMaiorOrcamento(List<Funcionario> funcionarios) {
	       
	    	Map<DepartamentoEnum, BigDecimal> calculaPorDepartamento = new HashMap<>();
	        //FAZ O CALCULO DA SOMA DOS SÁLARIOS PARA CADA DEPARTAMENTO
	        for (DepartamentoEnum departamento : DepartamentoEnum.values()) {
	            BigDecimal somaSalarios = funcionarios.stream()
	                .filter(e -> e.getCargo().equals(departamento))
	                .map(s -> s.getSalario())
	                .reduce(BigDecimal.ZERO, BigDecimal::add);
	            
	            calculaPorDepartamento.put(departamento, somaSalarios);
	        }
	        
	        DepartamentoEnum departamentoMaiorSalario = null;
	        BigDecimal maiorSalario = BigDecimal.ZERO;
	        //PERCORRE CADA DEPARTAMENTO COM O SALARIOTOTAL DE CADA UM,
	        //DEPOIS COMPARA O VALORATUAL PELO SALARIOTOTAL
	        for (DepartamentoEnum departamento : calculaPorDepartamento.keySet()) {
	            BigDecimal valorAtual = calculaPorDepartamento.get(departamento);
	            if (valorAtual.compareTo(maiorSalario) > 0) {
	                maiorSalario = valorAtual;
	                departamentoMaiorSalario = departamento;
	            }
	        }
	        
	        return departamentoMaiorSalario;
	    }
	}


