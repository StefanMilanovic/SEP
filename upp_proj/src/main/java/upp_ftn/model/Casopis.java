package upp_ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Casopis implements Serializable{
	@Column(unique = true)
	private String issn;
	
	private String naziv;
	
	private String oblast;
	
	public Casopis() {
		
	}
	
	public String getIssn() {
		return issn;
	}
	
	public void setIssn(String issn) {
		this.issn = issn;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getOblast() {
		return oblast;
	}
	
	public void setOblast(String oblast) {
		this.oblast = oblast;
	}

}
