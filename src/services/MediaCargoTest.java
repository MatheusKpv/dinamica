package services;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.DepartamentoEnum;
import model.Funcionario;

class MediaCargoTest {

	@Test
	void test() {
		List<Funcionario> funcionarios = new ArrayList<>();
		
		funcionarios.add(new Funcionario("João Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("9000")));
        funcionarios.add(new Funcionario("Maria Oliveira", DepartamentoEnum.RH, new BigDecimal("8000")));
        
        funcionarios
	}

}
