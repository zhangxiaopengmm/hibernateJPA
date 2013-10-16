package pl.mirco.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Typdokumentu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -691500986860384310L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String nazwa;
	@NotNull
	@Size(min = 2, max = 24)
	private String skrot;
	private String opis;
	@NotNull
	private boolean domyslny;
	
	@OneToMany(mappedBy = "typDokumentu")
    private Set<Dokument> dokuments;
	
	@Override
	public String toString() {
		return skrot;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Typdokumentu) {
			Typdokumentu td = (Typdokumentu) obj;
			if (this == td) {
				return true;
			}
			if (this.id == null || td.id == null) {
				return false;
			}
			return this.id.equals(td.id);
		}

		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getSkrot() {
		return skrot;
	}

	public void setSkrot(String skrot) {
		this.skrot = skrot;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public boolean isDomyslny() {
		return domyslny;
	}

	public void setDomyslny(boolean domyslny) {
		this.domyslny = domyslny;
	}

	public Set<Dokument> getDokuments() {
		return dokuments;
	}

	public void setDokuments(Set<Dokument> dokuments) {
		this.dokuments = dokuments;
	}

}
