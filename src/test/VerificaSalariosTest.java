package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.DepartamentoEnum;
import services.CargaDados;
import services.VerificaSalarios;

class VerificaSalariosTest {

	@Test
	void menorSalario() {

		Map<DepartamentoEnum, Double> menorSalario = new HashMap<DepartamentoEnum, Double>();

		menorSalario.put(DepartamentoEnum.RH, 8000.0);
		menorSalario.put(DepartamentoEnum.VENDAS, 7500.0);
		menorSalario.put(DepartamentoEnum.ADMINISTRACAO, 9000.0);
		menorSalario.put(DepartamentoEnum.SUPORTE, 6000.0);
		menorSalario.put(DepartamentoEnum.QUALIDADE, 5500.0);
		menorSalario.put(DepartamentoEnum.DESENVOLVIMENTO, 7000.0);

		VerificaSalarios verifica = new VerificaSalarios();
		Map<DepartamentoEnum, Double> teste = verifica.menorSalarioDepartamentos(CargaDados.getListaFuncionarios());

		assertEquals(menorSalario, teste);

	}

	@Test
	void maiorSalario() {

		Map<DepartamentoEnum, Double> maiorSalario = new HashMap<DepartamentoEnum, Double>();

		maiorSalario.put(DepartamentoEnum.RH, 9600.0);
		maiorSalario.put(DepartamentoEnum.VENDAS, 8400.0);
		maiorSalario.put(DepartamentoEnum.ADMINISTRACAO, 10850.5);
		maiorSalario.put(DepartamentoEnum.SUPORTE, 6950.75);
		maiorSalario.put(DepartamentoEnum.QUALIDADE, 6400.0);
		maiorSalario.put(DepartamentoEnum.DESENVOLVIMENTO, 8200.0);

		VerificaSalarios verifica = new VerificaSalarios();
		Map<DepartamentoEnum, Double> teste = verifica.maiorSalarioDepartamentos(CargaDados.getListaFuncionarios());

		assertEquals(maiorSalario, teste);

	}

	@Test
	void mediaSalario() {

		Map<DepartamentoEnum, BigDecimal> mediaSalario = new HashMap<DepartamentoEnum, BigDecimal>();

		mediaSalario.put(DepartamentoEnum.RH, new BigDecimal(9150.90).setScale(2,RoundingMode.HALF_EVEN));
		mediaSalario.put(DepartamentoEnum.VENDAS,new BigDecimal( 7550.00).setScale(2,RoundingMode.HALF_EVEN));
		mediaSalario.put(DepartamentoEnum.ADMINISTRACAO, new BigDecimal(9850.10).setScale(2,RoundingMode.HALF_EVEN));
		mediaSalario.put(DepartamentoEnum.SUPORTE, new BigDecimal(6050.30).setScale(2,RoundingMode.HALF_EVEN));
		mediaSalario.put(DepartamentoEnum.QUALIDADE, new BigDecimal(5950.00).setScale(2,RoundingMode.HALF_EVEN));
		mediaSalario.put(DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal(7450.25).setScale(2,RoundingMode.HALF_EVEN));

		VerificaSalarios verifica = new VerificaSalarios();
		Map<DepartamentoEnum, BigDecimal> teste = verifica.mediaSalarioDepartamentos(CargaDados.getListaFuncionarios());

		assertEquals(mediaSalario, teste);

	}

	@Test
	void modaSalario() {

		Map<DepartamentoEnum, BigDecimal> modaSalario = new HashMap<DepartamentoEnum, BigDecimal>();

		modaSalario.put(DepartamentoEnum.RH, new BigDecimal(9150.90).setScale(2,RoundingMode.HALF_EVEN));
		modaSalario.put(DepartamentoEnum.VENDAS, new BigDecimal(7550.00).setScale(2,RoundingMode.HALF_EVEN));
		modaSalario.put(DepartamentoEnum.ADMINISTRACAO, new BigDecimal(9850.10).setScale(2,RoundingMode.HALF_EVEN));
		modaSalario.put(DepartamentoEnum.SUPORTE, new BigDecimal(6050.30).setScale(2,RoundingMode.HALF_EVEN));
		modaSalario.put(DepartamentoEnum.QUALIDADE, new BigDecimal(5950.00).setScale(2,RoundingMode.HALF_EVEN));
		modaSalario.put(DepartamentoEnum.DESENVOLVIMENTO, new BigDecimal(7450.250).setScale(2,RoundingMode.HALF_EVEN));

		VerificaSalarios verifica = new VerificaSalarios();
		Map<DepartamentoEnum, BigDecimal> teste = verifica.modaSalarioDepartamentos(CargaDados.getListaFuncionarios());

		assertEquals(modaSalario, teste);

	}

	@Test
	void medianaSalario() {

		Map<DepartamentoEnum, Double> medianaSalario = new HashMap<DepartamentoEnum, Double>();

		medianaSalario.put(DepartamentoEnum.RH, 8950.55);
		medianaSalario.put(DepartamentoEnum.VENDAS, 7950.0);
		medianaSalario.put(DepartamentoEnum.ADMINISTRACAO, 9925.05);
		medianaSalario.put(DepartamentoEnum.SUPORTE, 6475.35);
		medianaSalario.put(DepartamentoEnum.QUALIDADE, 5950.0);
		medianaSalario.put(DepartamentoEnum.DESENVOLVIMENTO, 7550.0);

		VerificaSalarios verifica = new VerificaSalarios();
		Map<DepartamentoEnum, Double> teste = verifica.medianaSalarioDepartamentos(CargaDados.getListaFuncionarios());

		assertEquals(medianaSalario, teste);

	}

}
