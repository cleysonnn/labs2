package br.com.ufpb.labs2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufpb.labs2.Entity.Disciplinas;
import br.com.ufpb.labs2.Repository.DisciplinasRepository;

@Service
public class DisciplinasService {

	@Autowired
	private DisciplinasRepository repo;

	public Disciplinas addDisciplinas(Disciplinas disciplina) {

		return repo.save(disciplina);

	}
	
	public List<Disciplinas> getListaDasDisciplinas(){
		return repo.findAll();
	}

	public Disciplinas getByid(int id) {
		return repo.getById(id);

	}
	
	public Disciplinas atualizarLikes(Disciplinas disciplina ,int id) {
		Disciplinas dis = repo.getById(id);
		int like = dis.getLikes();
		dis.setLikes(like ++);
		repo.save(dis);
		return dis;
		
	}

	public Disciplinas atualizarLNota(Disciplinas disciplina ,int id) {
		Disciplinas dis = repo.getById(id);
		dis.setNotas(disciplina.getNotas());
		repo.save(dis);
		return dis;
		
	}
	
	
	
	public List<Disciplinas> rankNotas(){
		return repo.rankNota();
	}
	
public List<Disciplinas> rankLikes(){
	return repo.rankLikes();
		
	}
	
	
}
