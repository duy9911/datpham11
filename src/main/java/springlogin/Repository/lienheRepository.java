package springlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springlogin.entities.lienhe;

@Repository
public interface lienheRepository extends JpaRepository<lienhe, String>{

}
