package bankaKupca.DTO;

import java.util.Date;

public class КarticaDTO {

    private String PAN;
    private String PIN;
    private String vlasnikKartice;
    private Date datumIsteka;


    public КarticaDTO(){}

    public КarticaDTO(String PAN, String PIN, String vlasnikKartice, Date datumIsteka) {
        this.PAN = PAN;
        this.PIN = PIN;
        this.vlasnikKartice = vlasnikKartice;
        this.datumIsteka = datumIsteka;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getVlasnikKartice() {
        return vlasnikKartice;
    }

    public void setVlasnikKartice(String vlasnikKartice) {
        this.vlasnikKartice = vlasnikKartice;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }
}
