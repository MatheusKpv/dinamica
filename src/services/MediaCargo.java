package services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import aula6.outros.Evento;
import aula6.outros.TipoDeEvento;
import model.DepartamentoEnum;
import model.Funcionario;

public class MediaCargo {
	//chave: cargo, valor: media
	public Map<DepartamentoEnum, List<Funcionario>> filtrarMediaPorCargo(DepartamentoEnum cargo) {
		
		List<Funcionario> funcionarios = new CargaDados().getListaFuncionarios();
		List<Funcionario> listaFuncionario = funcionarios.stream()
				.filter(e -> e.getCargo().equals(cargo))
				.collect(Collectors.toList());
		
		Double media = funcionarios.stream().filter(e -> e.getCargo().equals(cargo)).;
//		Map<DepartamentoEnum, List<Funcionario>> mapa = new HashMap<>();
//		mapa.put(cargo, listaFuncionario);
//		return mapa;
	} 
	
}
