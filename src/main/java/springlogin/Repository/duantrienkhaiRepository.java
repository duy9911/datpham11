package springlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springlogin.entities.duantrienkhai;


@Repository
public interface duantrienkhaiRepository extends JpaRepository<duantrienkhai, Integer>{
	
}

