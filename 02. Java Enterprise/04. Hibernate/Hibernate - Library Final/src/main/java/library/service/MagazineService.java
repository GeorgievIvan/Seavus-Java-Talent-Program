package library.service;

import java.util.List;

import library.business.Magazine;
import library.data_access.PublicationDao;

public class MagazineService {

	private final PublicationDao publicationDao;
	
	public MagazineService(final PublicationDao publicationDao) {
		
		this.publicationDao = publicationDao;
	}
	
	public List<Magazine> getAllMagazines() {
		
		return publicationDao.readAllMagazines();
	}
	
	public void registerMagazine(final String magazineIssn, final String magazineTitle) {
		
		final Magazine magazine = new Magazine();
		magazine.setIssn(magazineIssn);
		magazine.setTitle(magazineTitle);

		publicationDao.insertPublication(magazine);
	}
	
	public void updateMagazine(final Long magazineId, final String newMagazineTitle) {
		
		publicationDao.updateMagazine(magazineId, newMagazineTitle);
	}
	
	public void unregisterMagazine(final Long magazineId) {
		
		publicationDao.deletePublication(magazineId);
	}
}
