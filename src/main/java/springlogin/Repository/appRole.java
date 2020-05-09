package springlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import springlogin.entities.AppRole;

@Repository
public interface appRole extends JpaRepository<AppRole, Integer>{
	@Query(value ="select * from app_role a where a.role_Name=?1", nativeQuery = true)
	AppRole findByRoleName(String roleName);
}
