package dataprocessinganalysisformats.dominio;

import java.io.Serializable;

public class Transacao implements Serializable {

	private static final long serialVersionUID = 4178588482437107318L;

	public String id;
	public String descricao;
	public Double valor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Transacao{" + "id='" + id + "'" + ", descricao='" + descricao + "'" + ", valor='" + valor + "'" + '}';
	}
}
