package e.com.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e.com.entity.Categorie;
import e.com.repo.CategorieRepository;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	
	public List<Categorie> getAllCategories(){
		return categorieRepository.findAll(); 
	}
	
	
	public Categorie updateCategorie(Categorie categorie) {
		
		Categorie categorieUpdate = categorieRepository.findById(categorie.getId_categorie()).get();
		categorieUpdate.setDesignation_categorie(categorie.getDesignation_categorie());
		return categorieRepository.save(categorieUpdate);
	}
	
	public void saveCategorie(Categorie categorie) {
		
			categorieRepository.save(categorie);
		
	}

	public Categorie getCategorieById(Long id) {
		Optional<Categorie> optional = categorieRepository.findById(id);
		Categorie cat = null;
		if(optional.isPresent()) {
			cat = optional.get();
		}else {
			throw new RuntimeException("Categorie not found ::"+id);
		}
		return cat;
	}
	
	
	public void deleteCategorie(Long id) {
		categorieRepository.deleteById(id);
	}
	
}
