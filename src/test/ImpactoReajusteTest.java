package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import services.CargaDados;
import services.ImpactoReajuste;

class ImpactoReajusteTest {

	@Test
	void mostraImpactoComAumentoDe10Porcento() {
		
		BigDecimal valor = new BigDecimal(273785.85).setScale(2,RoundingMode.HALF_EVEN);
		
		ImpactoReajuste imp = new ImpactoReajuste();
		
		BigDecimal impacto = imp.impactoReajusteFuncionario(CargaDados.getListaFuncionarios());
		
		assertEquals(valor, impacto);
	}

}
