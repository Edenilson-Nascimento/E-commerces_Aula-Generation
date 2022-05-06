package com.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository <Produtos, Long>{
	
	public List<Produtos> findAllByMedicamentoContainingIgnoreCase(@Param("medicamento")String medicamento);

	public List<Produtos> findByPrecoGreaterThan(BigDecimal preco);

	public List<Produtos> findByPrecoLessThan(BigDecimal preco);

	public List<Produtos> findAllByMedicamentoEndingWithIgnoreCase(String medicamento);

}
