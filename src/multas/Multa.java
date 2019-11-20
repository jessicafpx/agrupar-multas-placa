package multas;

public class Multa {

	private String placa;
	private String data;
	private Double valor;

	public Multa(String placa, String data, Double valor) {
		this.placa = placa;
		this.data = data;
		this.valor = valor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
