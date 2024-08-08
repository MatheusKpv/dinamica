package principal;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {

		StringBuilder menuInicial = new StringBuilder();
		menuInicial.append("1 - Quais os 10 maiores salários da empresa? ")
				.append("\n2 - Qual a media de salário por cargo? ")
				.append("\n3 - Qual seria o impacto, em reais, de oferecer um reajuste de 10% a todos os funcionários? ")
				.append("\n4 - Qual o percentual de cada cargo em relação ao total de funcionários? ")
				.append("\n5 - Qual o menor salário, o maior salário, a média, a moda, e a mediana de salrio por cargo? ")
				.append("\n6 - Qual departamento possui o maior orçamento? ")
				.append("\n7 - Qual departamento passui a maior media salarial? ")
				.append("\n0 - SAIR");
		int op = 1;
		while (op != 0) {
			op = Integer.parseInt(JOptionPane.showInputDialog(menuInicial));
			switch (op) {
			case 1:
				
				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 6:

				break;

			case 7:

				break;
			}

		}

	}
}
