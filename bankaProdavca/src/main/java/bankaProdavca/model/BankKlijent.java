package bankaProdavca.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BankKlijent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String klijentId;

    @Column()
    private String klijentLozinka;

    @Column()
    private String imeKlijenta;

    @OneToMany(mappedBy = "vlasnik", cascade = CascadeType.ALL)
    private List<Kartica> kartice = new ArrayList<Kartica>();

    public BankKlijent(String klijentId, String klijentLozinka, String imeKlijenta) {
        this.klijentId = klijentId;
        this.klijentLozinka = klijentLozinka;
        this.imeKlijenta = imeKlijenta;
    }

    public BankKlijent(){}

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKlijentId() {
        return klijentId;
    }

    public void setKlijentId(String klijentId) {
        this.klijentId = klijentId;
    }

    public String getKlijentLozinka() {
        return klijentLozinka;
    }

    public void setKlijentLozinka(String klijentLozinka) {
        this.klijentLozinka = klijentLozinka;
    }

    public List<Kartica> getKartice() {
        return kartice;
    }

    public void setKartice(List<Kartica> kartice) {
        this.kartice = kartice;
    }
}
