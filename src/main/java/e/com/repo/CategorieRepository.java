package e.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import e.com.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
