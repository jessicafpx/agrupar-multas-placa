package multas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void imprimir(List<Entry<String, Object>> listaEntry, Map<String, List<Multa>> map) {

		for (Entry k : listaEntry) {
			String placa = (String) k.getKey();
			int qtdMultas = map.get(placa).size();

			if (qtdMultas == 1) {
				System.out.printf("Placa %s - %d multa\n", placa.toUpperCase(), qtdMultas);
			} else {
				System.out.printf("Placa %s - %d multas\n", placa.toUpperCase(), qtdMultas);
			}

			System.out.println("+------------+---------------+");
			System.out.println("|    Data    |     Valor     |");
			System.out.println("+------------+---------------+");

			double soma = 0;
			for (int i = 0; i < qtdMultas; i++) {
				String data = map.get(placa).get(i).getData();
				double valor = map.get(placa).get(i).getValor();
				soma = soma + valor;

				System.out.printf("| %10s %s %10.2f %s\n", data, "| R$", valor, "|");
			}

			System.out.println("+------------+---------------+");
			System.out.printf("|   TOTAL    %s %10.2f %s\n", "| R$", soma, "|");
			System.out.println("+------------+---------------+\n");
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Multa> lista = new ArrayList<>();

		System.out.println("Digite quantidade de multas: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("MULTA " + (i + 1) + ":");
			System.out.println("Digite a placa: ");
			String placa = sc.next().toUpperCase();
			System.out.println("Digite a data: (dd/mm/aaaa)");
			String data = sc.next().toUpperCase();
			System.out.println("Digite o valor: R$");
			double valor = sc.nextDouble();

			lista.add(new Multa(placa, data, valor));
		}

		MultaUtil mu = new MultaUtil();
		Map<String, List<Multa>> placaMulta = new TreeMap<>();
		placaMulta = mu.agruparMultas(lista);

		List<Entry<String, Object>> listaEntry = new ArrayList<>();
		for (Entry y : placaMulta.entrySet()) {
			listaEntry.add(y);
		}

		listaEntry.sort((o1, o2) -> o1.getKey().toUpperCase().compareTo(o2.getKey().toUpperCase()));

		imprimir(listaEntry, placaMulta);

	}

}
