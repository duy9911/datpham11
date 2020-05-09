package springlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import springlogin.entities.account;

@Repository
public interface accountRepository extends JpaRepository<account, Integer>{

}
