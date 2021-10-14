package br.com.ufpb.labs2.Entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

public class Disciplinas implements Comparable<Disciplinas> {
	
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private int likes;
	
	private double notas ;
	
	
	
	public Disciplinas(@JsonProperty("nome") String nome) {
		this.nome = nome;
	}
	
	
	
	
	
	
	
	
	/*public static Comparator<Disciplinas> getComparatorIdadeDescNomeCresc() {
		return new Comparator<Disciplinas>() {
			@Override
			public int compare(Disciplinas o1, Disciplinas o2) {
				int valor = o1.media.compareTo(o2.media) * -1; //idade decrescente

				//se for igual, comparar por nome
				if (valor == 0){
					return o1.nome.compareTo(o2.nome);
				}
				return valor;
			}
		};
	}*/

	public Disciplinas(String nome, int likes, double notas) {
		super();
		this.nome = nome;
		this.likes = likes;
		this.notas = notas;
	}

	public Disciplinas(Disciplinas disciplina) {
		
	}

	
	public Disciplinas() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public double getNotas() {
		return notas;
	}

	public void setNotas(double notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + likes;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(notas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplinas other = (Disciplinas) obj;
		if (id != other.id)
			return false;
		if (likes != other.likes)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(notas) != Double.doubleToLongBits(other.notas))
			return false;
		return true;
	}

	@Override
	public int compareTo(Disciplinas o) {
		// TODO Auto-generated method stub
		return 0;
	}





	

	

	/*
	 * 
	 * public int compareTo(Item o) {
	if ( this.valor < o.getValor())	return -1;
	if ( this.valor > o.getValor()) return 1;
	return 0;
}
	 */

	/*@Override
	public int compareTo(Disciplinas o) {
		
		if(this.media > o.getMedia()) return -1;
		if(this.media < o.getMedia()) return 1;
		return 0;
	}
*/
	
	
	

}
