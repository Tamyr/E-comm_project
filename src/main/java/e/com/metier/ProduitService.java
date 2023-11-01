package e.com.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import e.com.entity.Produit;
import e.com.repo.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	
	
	public List<Produit> getAllProduits(String mc){
		if(mc.equals("")) {
			return produitRepository.findAll(); 
		}else {
			return produitRepository.findByProductTitle(mc);
		}
	}

	
	public void saveProduit(Produit produit) {
		
		produitRepository.save(produit);
		
	}
	
	
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
	}
	
}
