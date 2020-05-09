package springlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import springlogin.entities.AppRole;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Integer>{
	@Query(value ="select * from AppRole where ID=?1", nativeQuery = true)
	AppRole findByUserId(Integer id);
}
