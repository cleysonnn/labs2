package br.com.ufpb.labs2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ufpb.labs2.Entity.Disciplinas;

@Repository
public interface DisciplinasRepository extends  JpaRepository<Disciplinas ,Integer > {
	
	@Query( value="select * from Disciplinas dis ORDER BY dis.notas " , nativeQuery = true)
	List<Disciplinas> rankNota();
	
	@Query( value ="select * from Disciplinas dis ORDER BY dis.likes " , nativeQuery = true)
	List<Disciplinas> rankLikes();

}
