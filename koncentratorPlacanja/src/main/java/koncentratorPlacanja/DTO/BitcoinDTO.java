package koncentratorPlacanja.DTO;

public class BitcoinDTO {

    private String kolicina;
    private String naziv;

    public BitcoinDTO(){}

    public BitcoinDTO(String kolicina, String naziv) {
        this.kolicina = kolicina;
        this.naziv = naziv;
    }

    public String getKolicina() {
        return kolicina;
    }

    public void setKolicina(String kolicina) {
        this.kolicina = kolicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
