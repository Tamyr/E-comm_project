package e.com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import e.com.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

	@Query("select p from Produit p where p.titre_produit like :x")
	public List<Produit> findByProductTitle(@Param("x") String mc);
	
}
