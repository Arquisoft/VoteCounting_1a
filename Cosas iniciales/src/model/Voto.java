package model;

public class Voto {
	private Partidos partido;
	private Integer codColegio;
	
	
	public Partidos getPartido() {
		return partido;
	}
	public Voto setPartido(Partidos partido) {
		this.partido = partido;
		return this;
	}
	public Integer getCodColegio() {
		return codColegio;
	}
	public Voto setCodColegio(Integer codColegio) {
		this.codColegio = codColegio;
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codColegio == null) ? 0 : codColegio.hashCode());
		result = prime * result + ((partido == null) ? 0 : partido.hashCode());
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
		Voto other = (Voto) obj;
		if (codColegio == null) {
			if (other.codColegio != null)
				return false;
		} else if (!codColegio.equals(other.codColegio))
			return false;
		if (partido != other.partido)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Voto [partido=" + partido + ", codColegio=" + codColegio + "]";
	}
}
