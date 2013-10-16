package pl.mirco.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Dokument implements Serializable {

	private static final long serialVersionUID = 6208912114379989617L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @NotNull
    @ManyToOne
    private Typdokumentu typDokumentu;
    @NotNull
    @Size(min = 2, max = 24)
    private String nazwa;
    @NotNull
    @ManyToOne
	private Kontrahent kontrahent;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataWystawienia;
	@NotNull
	@Size(min = 2, max = 128)
	private String miejcsceWystawienia;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataSprzedazy;
	@Temporal(TemporalType.DATE)
	private Date terminPlatnosci;
	private String formaPlatnosci;
	@OneToMany(mappedBy = "dokument", fetch=FetchType.LAZY)
	private Set<PozycjaDokumentu> pozycjaDokumentus = new HashSet<PozycjaDokumentu>(0);
	private boolean wydrukowany;
	@Size(min = 2, max = 1024)
	private String opis;
	
	/*@NotNull
	private Uzytkownik uzytkownik;*/
	

	public Dokument() {
		data = new Date();
		dataWystawienia = new Date();
		dataSprzedazy = new Date();
		terminPlatnosci = new Date();
		wydrukowany = false;
	}

	@Override
	public String toString() {
		return nazwa;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Dokument) {
			Dokument d = (Dokument) obj;
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

	public Typdokumentu getTypDokumentu() {
		return typDokumentu;
	}

	public void setTypDokumentu(Typdokumentu typDokumentu) {
		this.typDokumentu = typDokumentu;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Kontrahent getKontrahent() {
		return kontrahent;
	}

	public void setKontrahent(Kontrahent kontrahent) {
		this.kontrahent = kontrahent;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataWystawienia() {
		return dataWystawienia;
	}

	public void setDataWystawienia(Date dataWystawienia) {
		this.dataWystawienia = dataWystawienia;
	}

	public String getMiejcsceWystawienia() {
		return miejcsceWystawienia;
	}

	public void setMiejcsceWystawienia(String miejcsceWystawienia) {
		this.miejcsceWystawienia = miejcsceWystawienia;
	}

	public Date getDataSprzedazy() {
		return dataSprzedazy;
	}

	public void setDataSprzedazy(Date dataSprzedazy) {
		this.dataSprzedazy = dataSprzedazy;
	}

	public Date getTerminPlatnosci() {
		return terminPlatnosci;
	}

	public void setTerminPlatnosci(Date terminPlatnosci) {
		this.terminPlatnosci = terminPlatnosci;
	}

	public String getFormaPlatnosci() {
		return formaPlatnosci;
	}

	public void setFormaPlatnosci(String formaPlatnosci) {
		this.formaPlatnosci = formaPlatnosci;
	}

	public Set<PozycjaDokumentu> getPozycjaDokumentus() {
		return pozycjaDokumentus;
	}

	public void setPozycjaDokumentus(Set<PozycjaDokumentu> pozycjaDokumentus) {
		this.pozycjaDokumentus = pozycjaDokumentus;
	}

	public boolean isWydrukowany() {
		return wydrukowany;
	}

	public void setWydrukowany(boolean wydrukowany) {
		this.wydrukowany = wydrukowany;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

}
