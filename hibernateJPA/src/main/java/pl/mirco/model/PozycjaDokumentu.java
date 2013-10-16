package pl.mirco.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class PozycjaDokumentu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4676635437348429537L;

	public PozycjaDokumentu() {
	}
	
	public PozycjaDokumentu(Integer lp) {
		this.lp = lp;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @NotNull
    @ManyToOne
    private Dokument dokument;
    
    @NotNull
    private Integer lp;
    @Size(min = 2, max = 128)
    @NotNull
    private String nazwa;
    @Size(max = 16)
    private String pkwiu;
    @NotNull
    private Double ilosc;
    @ManyToOne
    private JednostkaMiary jednostkaMiary;
    @NotNull
    private BigDecimal cenaNetto;
    @NotNull
    private StawkaVAT stawkaVAT;
    @Transient
    private BigDecimal wartoscNetto;
    @Transient
    private BigDecimal wartoscVAT;
    @Transient
    private BigDecimal wartoscBrutto;

	@Override
	public String toString() {
		return nazwa;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PozycjaDokumentu) {
			PozycjaDokumentu d = (PozycjaDokumentu) obj;
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

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getPkwiu() {
		return pkwiu;
	}

	public void setPkwiu(String pkwiu) {
		this.pkwiu = pkwiu;
	}

	public Double getIlosc() {
		return ilosc;
	}

	public void setIlosc(Double ilosc) {
		this.ilosc = ilosc;
	}

	public JednostkaMiary getJednostkaMiary() {
		return jednostkaMiary;
	}

	public void setJednostkaMiary(JednostkaMiary jednostkaMiary) {
		this.jednostkaMiary = jednostkaMiary;
	}

	public BigDecimal getCenaNetto() {
		if (cenaNetto != null) {
			return cenaNetto.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return cenaNetto;
	}

	public void setCenaNetto(BigDecimal cenaNetto) {
		if (cenaNetto != null) {
			this.cenaNetto = cenaNetto.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			this.cenaNetto = cenaNetto;
		}
		
	}

	public StawkaVAT getStawkaVAT() {
		return stawkaVAT;
	}

	public void setStawkaVAT(StawkaVAT stawkaVAT) {
		this.stawkaVAT = stawkaVAT;
	}
	
	public BigDecimal getWartoscVAT() {
		if (getWartoscNetto() != null && getStawkaVAT() != null) {
			wartoscVAT = getWartoscNetto().multiply(getStawkaVAT().getWartosc()).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			wartoscVAT = null;
		}
		
		return wartoscVAT;
	}

	public void setWartoscVAT(BigDecimal wartoscVAT) {
		if (wartoscVAT != null) {
			this.wartoscVAT = wartoscVAT.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			this.wartoscVAT = wartoscVAT;
		}
		
	}

	public BigDecimal getWartoscNetto() {
		if (getCenaNetto() != null && getIlosc() != null) {
		   wartoscNetto = getCenaNetto().multiply(new BigDecimal(getIlosc())).setScale(2, BigDecimal.ROUND_HALF_UP);;
		} else {
			wartoscNetto = null;
		}
		
		return wartoscNetto;
	}

	public void setWartoscNetto(BigDecimal wartoscNetto) {
		if (wartoscNetto != null) {
			this.wartoscNetto = wartoscNetto.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			this.wartoscNetto = wartoscNetto;
		}
		
	}

	public BigDecimal getWartoscBrutto() {
		if (getWartoscNetto() != null && getWartoscVAT() != null) {
			wartoscBrutto = getWartoscNetto().add(getWartoscVAT()).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			wartoscBrutto = null;
		}
		
		return wartoscBrutto;
	}

	public void setWartoscBrutto(BigDecimal wartoscBrutto) {
		if (wartoscBrutto != null) {
			this.wartoscBrutto = wartoscBrutto.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			this.wartoscBrutto = wartoscBrutto;
		}
		
	}

	public Integer getLp() {
		return lp;
	}

	public void setLp(Integer lp) {
		this.lp = lp;
	}



}
