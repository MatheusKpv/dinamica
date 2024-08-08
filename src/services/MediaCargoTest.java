package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.DepartamentoEnum;
import model.Funcionario;

class MediaCargoTest {


	    @Test
	    void deveRetornarUmMapCasoRecebaListaCorreta() {
	        Funcionario funcionario1 = new Funcionario("Lucas", DepartamentoEnum.RH, BigDecimal.valueOf(2500));
	        Funcionario funcionario2 = new Funcionario("Paulo", DepartamentoEnum.DESENVOLVIMENTO, BigDecimal.valueOf(2400));
	        Funcionario funcionario3 = new Funcionario("Marcos", DepartamentoEnum.RH, BigDecimal.valueOf(2450));
	 
	        List<Funcionario> funcionarios = new ArrayList<>();
	        funcionarios.add(funcionario1);
	        funcionarios.add(funcionario2);
	        funcionarios.add(funcionario3);
	        MediaCargo mediaSalarioCargo = new MediaCargo();
	        
	        Map<DepartamentoEnum, BigDecimal> mapaAtual = mediaSalarioCargo.getMediaSalarioPorCargo(funcionarios);
	        Map<DepartamentoEnum, BigDecimal> mapaEsperado = new HashMap<>();
	        mapaEsperado.put(DepartamentoEnum.RH, new BigDecimal("2475."));
	        mapaEsperado.put(DepartamentoEnum.ADMINISTRACAO, BigDecimal.ZERO);
	        mapaEsperado.put(DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal("2400."));
	        mapaEsperado.put(DepartamentoEnum.SUPORTE, BigDecimal.ZERO);
	        mapaEsperado.put(DepartamentoEnum.QUALIDADE, BigDecimal.ZERO);
	        mapaEsperado.put(DepartamentoEnum.VENDAS, BigDecimal.ZERO);

	        assertEquals(mapaEsperado, mapaAtual);
	    }
	}


