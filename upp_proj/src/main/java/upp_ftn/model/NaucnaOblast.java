package upp_ftn.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NaucnaOblast implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String naslov;
	
	public NaucnaOblast() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	
	
}
