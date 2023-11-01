package e.com.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Categorie {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_categorie;
	@NotEmpty
	private String designation_categorie;
	@OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Produit> produits = new HashSet<Produit>();
	
	//private Collection<Produit> produits;
	
	
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(@NotEmpty String designation_categorie, Set<Produit> produits) {
		super();
		this.designation_categorie = designation_categorie;
		this.produits = produits;
	}
	
	public void addProduct(Produit produit) {
		produit.setCategorie(this);
		produits.add(produit);
	}

}
