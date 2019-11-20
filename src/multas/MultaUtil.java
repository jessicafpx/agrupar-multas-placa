package multas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultaUtil {

	public static Map<String, List<Multa>> agruparMultas(List<Multa> l) {
		Map<String, List<Multa>> m = new HashMap<>();

		for (Multa multa : l) {

			String placaMulta = multa.getPlaca();

			if (!m.containsKey(placaMulta)) {
				// placa não está no mapa

				List<Multa> multasCarro = new ArrayList<>();
				multasCarro.add(multa);
				m.put(placaMulta, multasCarro);

				// m.get(PlacaMulta).add(multa);

			} else {
				// já tem a placa no mapa
				m.get(multa.getPlaca()).add(multa);
			}
		}

		return m;
	}
}
