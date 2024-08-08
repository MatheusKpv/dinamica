package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.DepartamentoEnum;
import model.Funcionario;

class MaiorOrcamentoTest {


	    @Test
	    void deveRetornarDepartamentoComMaiorOrcamento() {
	    	Funcionario funcionario1 = new Funcionario("Joana", DepartamentoEnum.DESENVOLVIMENTO, BigDecimal.valueOf(2700));
	        Funcionario funcionario2 = new Funcionario("Paulo", DepartamentoEnum.DESENVOLVIMENTO, BigDecimal.valueOf(2400));
	        Funcionario funcionario3 = new Funcionario("Lucas", DepartamentoEnum.RH, BigDecimal.valueOf(2500));
	        Funcionario funcionario4 = new Funcionario("Marcos", DepartamentoEnum.RH, BigDecimal.valueOf(2450));
	        Funcionario funcionario5 = new Funcionario("Ana", DepartamentoEnum.RH, BigDecimal.valueOf(3000));
	        Funcionario funcionario6 = new Funcionario("Joaquim", DepartamentoEnum.VENDAS, BigDecimal.valueOf(40000));
	        
	        List<Funcionario> funcionarios = new ArrayList<>();
	        funcionarios.add(funcionario1);
	        funcionarios.add(funcionario2);
	        funcionarios.add(funcionario3);
	        funcionarios.add(funcionario4);
	        funcionarios.add(funcionario5);
	        funcionarios.add(funcionario6);
	        
	        MaiorOrcamento mediaCargo = new MaiorOrcamento();
	        DepartamentoEnum departamentoAtual = mediaCargo.getDepartamentoComMaiorOrcamento(funcionarios);
	        System.out.println(departamentoAtual);
	  
	        DepartamentoEnum departamentoEsperado = DepartamentoEnum.VENDAS;
	        System.out.println(departamentoEsperado);
	        
	        assertEquals(departamentoEsperado, departamentoAtual);
	    }
	}
