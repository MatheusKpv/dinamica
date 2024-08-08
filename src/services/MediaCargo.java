package services;

import java.math.BigDecimal;

import java.math.MathContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.DepartamentoEnum;
import model.Funcionario;

public class MediaCargo {

    public Map<DepartamentoEnum, BigDecimal> getMediaSalarioPorCargo(List<Funcionario> funcionarios) {
        Map<DepartamentoEnum, BigDecimal> mapa = new HashMap<>();
        
        for (DepartamentoEnum departamento : DepartamentoEnum.values()) {
            int numeroFuncionarios = (int) funcionarios.stream()
                .filter(f -> f.getCargo().equals(departamento))
                .count();
            // CALCULA A SOMA DOS SÁLARIOS POR DEPARTAMENTO
            BigDecimal somaSalarios = funcionarios.stream()
                .filter(f -> f.getCargo().equals(departamento))
                .map(f -> f.getSalario())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            // CALCULA Á MÉDIA, SE TIVER FUNCIONAÁRIO NO DEPARTAMENTO
            BigDecimal media = numeroFuncionarios > 0 ? somaSalarios
                .divide(BigDecimal.valueOf(numeroFuncionarios),
                //GARANTE PRECISÃO NA HORA DE DIVIDIR	
                MathContext.DECIMAL64)
                : BigDecimal.ZERO;
      
            mapa.put(departamento, media);
        }
        
        return mapa;
    }
}

