package services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.DepartamentoEnum;
import model.Funcionario;

public class MaiorMediaSalarial {
	        
	        public DepartamentoEnum getDepartamentoComMaiorMediaSalarial(List<Funcionario> funcionarios) {
	            Map<DepartamentoEnum, BigDecimal> mediaSalarialPorDepartamento = new HashMap<>();

	          //FAZ O CALCULO DA SOMA DOS SÁLARIOS PARA CADA DEPARTAMENTO
	            for (DepartamentoEnum departamento : DepartamentoEnum.values()) {
	                BigDecimal somaSalarios = funcionarios.stream()
	                    .filter(e -> e.getCargo().equals(departamento))
	                    .map(Funcionario::getSalario)
	                    .reduce(BigDecimal.ZERO, BigDecimal::add);
	       
	              //CONTA A QUANTIDADE DE FUNCIONARIOS DO DEPARTAMENTO ATUAL
	                long count = funcionarios.stream()
	                    .filter(e -> e.getCargo().equals(departamento))
	                    .count();

	              //CALCULA A MEDIA SALARIA, SE HOUVER FUNCIONARIO NO DEPARTAMENTO ATUAL
	                if (count > 0) {
	                    BigDecimal mediaSalarial = somaSalarios.divide(BigDecimal.valueOf(count),2, RoundingMode.HALF_EVEN);
	                    mediaSalarialPorDepartamento.put(departamento, mediaSalarial);
	                }
	            }
	        
	        DepartamentoEnum departamentoMaiorMediaSalarial = null;
	        BigDecimal maiorMediaSalarial = BigDecimal.ZERO;
	        //PERCORRE CADA DEPARTAMENTO COM A MAIORMEDIA DE CADA UM,
	        //DEPOIS COMPARA O MEDIAATUAL PELO MAIORMEDIA
	        for (DepartamentoEnum departamento : mediaSalarialPorDepartamento.keySet()) {
	            BigDecimal mediaAtual = mediaSalarialPorDepartamento.get(departamento);
	            if (mediaAtual.compareTo(maiorMediaSalarial) > 0) {
	                maiorMediaSalarial = mediaAtual;
	                departamentoMaiorMediaSalarial = departamento;
	            }
	        }

	        return departamentoMaiorMediaSalarial;
	    }
	}

