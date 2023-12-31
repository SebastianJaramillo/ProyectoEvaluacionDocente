package ec.edu.espe.microservicioformulario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "res_id")
	private long id;

	@Column(name = "res_texto")
	private String texto;

	@Column(name = "pre_id")
	private long preId;

	@OneToOne
	@JoinColumn(name = "pre_id", referencedColumnName = "pre_id", insertable = false, updatable = false)
	private Pregunta pregunta;

	public Respuesta() {
	}

	public Respuesta(long id, String texto, long preId, Pregunta pregunta) {
		this.id = id;
		this.texto = texto;
		this.preId = preId;
		this.pregunta = pregunta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public long getPreId() {
		return preId;
	}

	public void setPreId(long preId) {
		this.preId = preId;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Respuesta other = (Respuesta) obj;
		if (id != other.id)
			return false;
		return true;
	}
}