package e.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import e.com.entity.Categorie;
import e.com.entity.Produit;
import e.com.repo.CategorieRepository;
import e.com.repo.ProduitRepository;

@SpringBootApplication
public class ECommApplication implements CommandLineRunner {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Categorie cat1 = categorieRepository.save(new Categorie("Téléphone & Tablette"));
		Categorie cat2 = categorieRepository.save(new Categorie("TV & Hi Tech"));
		Categorie cat3 = categorieRepository.save(new Categorie("Informatique"));
		Categorie cat4 = categorieRepository.save(new Categorie("Jeux vidéos & Consoles"));
		

		
		
		produitRepository.save(new Produit("Samasung Galaxy A04","RAM: 4GB, ROM: 64GB, Caméra principale: 50 MP, f/1.8, (large)",1169.0,500, cat1));
		produitRepository.save(new Produit("Tapis de souris ROG Neon", "800 x 300 MM Tapis gamer souris et clavier Gaming Mouse Pad", 79, 230, cat3));
		produitRepository.save(new Produit("Cable HDMI 15 mètre", "Câble HDMI Haute Qualité : 15 mètres, Câble dynamique audio/vidéo, Bande passante: 10,2 Gbps, Vidéo 4K: 24 Hz / 1080p: 60 Hz", 159, 220, cat2));
		produitRepository.save(new Produit("Apple iPhone 14 Pro Max", "Taille de l'écran 6.7 pouces, Mémoire 256Go, Processeur A16 Bionic, RAM 8 Gb", 15579, 100, cat1));
		produitRepository.save(new Produit("Samsung 32 - Smart TV", "TV 32 pouces, HD, Smart tv, récepteur intégré, 2 HDMI, 1 port USB", 1459, 120, cat2));
		produitRepository.save(new Produit("Hp Elitebook 820 G3", "i5 6eme, 8RAM, 500G SSD", 3700, 100, cat3));
		produitRepository.save(new Produit("Sony PlayStation 5", "SKU: SO298EC1C6JJ4NAFAMZ, Modèle: CFI-1216A, Poids (kg): 8, Couleur: white", 7999, 90, cat4));
		produitRepository.save(new Produit("XBOX Series X", "Plateforme Xbox Series X, Capacité de stockage (Go) 1000 Go, Coloris Noir", 7999, 100, cat4));
		*/
		
	}

}
