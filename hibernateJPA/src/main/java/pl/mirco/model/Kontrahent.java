package pl.mirco.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author mradwan
 */
@Entity
public class Kontrahent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3228250914454701213L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
    @Size(min = 2, max = 24)
	private String nazwa;
	private String nip;
	private String ulica;
	private String kodpocztowy;
	private String miejscowosc;
	private String regon;
	private String telefon;
	private String email;
	private String opis;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@OneToMany(mappedBy = "kontrahent")
    private Set<Dokument> dokuments;
	
	public Kontrahent() {
		this.data = new Date();
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

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getKodpocztowy() {
		return kodpocztowy;
	}

	public void setKodpocztowy(String kodpocztowy) {
		this.kodpocztowy = kodpocztowy;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getRegon() {
		return regon;
	}

	public void setRegon(String regon) {
		this.regon = regon;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return nazwa;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Kontrahent) {
			Kontrahent d = (Kontrahent) obj;
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

	public Set<Dokument> getDokuments() {
		return dokuments;
	}

	public void setDokuments(Set<Dokument> dokuments) {
		this.dokuments = dokuments;
	}

}
