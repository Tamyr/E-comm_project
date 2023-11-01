package e.com.entity;

import java.util.Collection;

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
	@OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY)
	private Collection<Produit> produits;
	
	public Categorie(String designation_categorie) {
		super();
		this.designation_categorie = designation_categorie;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
