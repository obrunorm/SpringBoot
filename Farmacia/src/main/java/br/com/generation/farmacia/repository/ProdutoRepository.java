package br.com.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.farmacia.model.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List <Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	 
	public List <Produto> findByNomeAndLaboratorio(String nome, String laboratorio);

	public List <Produto> findByNomeOrLaboratorio(String nome, String laboratorio);
	

	 
	public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);
	
		 
	public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);

}