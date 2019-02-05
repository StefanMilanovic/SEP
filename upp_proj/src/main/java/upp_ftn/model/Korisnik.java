package upp_ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Korisnik implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String username;

    private String ime;

    private String prezime;
    
    private String grad;
    
    private String drzava;

    @Column(unique = true)
    private String email;

    private String lozinka;

    private Boolean potvrdjenMail;
    
    @Column(nullable = false)
	private KorisnikType korisnikType;
	
	@Column(nullable = false)
	private KorisnikStatus korisnikStatus;

    public Korisnik() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }
    
    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Boolean getPotvrdjenMail() {
        return potvrdjenMail;
    }

    public void setPotvrdjenMail(Boolean potvrdjenMail) {
        this.potvrdjenMail = potvrdjenMail;
    }
    
    public KorisnikType getKorisnikType() {
		return korisnikType;
	}

	public void setKorisnikType(KorisnikType userType) {
		this.korisnikType = korisnikType;
	}

	public KorisnikStatus getKorisnikStatus() {
		return korisnikStatus;
	}

	public void setKorisnikStatus(KorisnikStatus korisnikStatus) {
		this.korisnikStatus = korisnikStatus;
	}
}
