package pl.mirco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Uzytkownik implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2233437015224404315L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 24)
    @Column(nullable = false)
	private String login;
	private String haslo;
	@Size(min = 1, max = 256)
	private String opis;
	private String email;
	private String imie;
	private String nazwisko;
	private boolean aktywny;
	
	public Uzytkownik() {
		//login = "Nowy login";
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Uzytkownik) {
            Uzytkownik u = (Uzytkownik) obj;
            if (this == u) {
                return true;
            }
            if (this.id == null || u.id == null) {
                return false;
            }
            return this.id.equals(u.id);
        }

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public boolean isAktywny() {
		return aktywny;
	}

	public void setAktywny(boolean aktywny) {
		this.aktywny = aktywny;
	}

}
