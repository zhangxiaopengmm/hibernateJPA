package pl.mirco.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class JednostkaMiary implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3911238468482845637L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @NotNull
    @Size(min = 2, max = 24)
    private String nazwa;
    @Size(max = 256)
    private String opis;


	@Override
	public String toString() {
		return nazwa;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JednostkaMiary) {
			JednostkaMiary d = (JednostkaMiary) obj;
			if (this == d) {
				return true;
			}
			if (this.id == null || d.id == null) {
				return false;
			}
			return this.id.equals(d.id);
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

}
