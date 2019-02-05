package upp_ftn.service;

import java.util.List;

import upp_ftn.model.Korisnik;


public interface KorisnikService {
	public Korisnik findByUsername(Korisnik k);
	public boolean register(Korisnik k);
//	public List<Korisnik> getNotAcctivated();
//	public List<Korisnik> getAcctivated();
//	public boolean delete(long id);
//	public boolean setStatus(String id, KorisnikStatus userStatus);
}
