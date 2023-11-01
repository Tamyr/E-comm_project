package e.com.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Produit {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_produit;
	private String titre_produit;
	private String designation_produit;
	private double prix_produit;
	private int stock_produit;
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIE")
	private Categorie categorie;
	
	public Produit(String titre_produit, String designation_produit, double prix_produit, int stock_produit,
			Categorie categorie) {
		super();
		this.titre_produit = titre_produit;
		this.designation_produit = designation_produit;
		this.prix_produit = prix_produit;
		this.stock_produit = stock_produit;
		this.categorie = categorie;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
