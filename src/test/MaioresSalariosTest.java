package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.DepartamentoEnum;
import model.Funcionario;
import services.CargaDados;
import services.MaioresSalarios;

class MaioresSalariosTest {

	@Test
	void test() {
		
		List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Carlos Eduardo Araújo", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10850.50")));
        funcionarios.add(new Funcionario("Elena Yuto Watanabe", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10850.50")));
        funcionarios.add(new Funcionario("Samuel Campos", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10850")));
        funcionarios.add(new Funcionario("Maurício Pereira Lima", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10850")));
        funcionarios.add(new Funcionario("Thiago Lima", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10800")));
        funcionarios.add(new Funcionario("Thiago Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10800")));
        funcionarios.add(new Funcionario("William Bruno Costa", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10650.10")));
        funcionarios.add(new Funcionario("Yara Yusuke Takahashi", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10650.10")));
        funcionarios.add(new Funcionario("Joana Silva", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10650")));
        funcionarios.add(new Funcionario("Érika Pereira Lima", DepartamentoEnum.ADMINISTRACAO, new BigDecimal("10650")));
        
        MaioresSalarios m = new MaioresSalarios();
        List<Funcionario> funcionariosFiltrado = m.filtraPorSalario(CargaDados.getListaFuncionarios());
        System.out.println(funcionarios);
        System.out.println(funcionariosFiltrado);
		assertEquals(funcionarios.toString(), funcionariosFiltrado.toString());
        
	}

}
