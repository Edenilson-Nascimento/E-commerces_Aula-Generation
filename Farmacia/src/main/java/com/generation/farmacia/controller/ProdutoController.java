package com.generation.farmacia.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.model.Produtos;
import com.generation.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity <List<Produtos>> getById(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Produtos> getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("medicamento/{medicamento}")
	public ResponseEntity <List<Produtos>>getByMedicamento(@PathVariable String medicamento){
		return ResponseEntity.ok(produtoRepository.findAllByMedicamentoContainingIgnoreCase(medicamento));
	}
	
	@GetMapping("/preco_menor/{preco}")
	public ResponseEntity<List<Produtos>> getByPrecoMenor(@PathVariable BigDecimal preco){
		return ResponseEntity.ok(produtoRepository.findByPrecoLessThan(preco));
	}
	
	@GetMapping("/preco_maior/{preco}")
	public ResponseEntity<List<Produtos>> getByPrecoMaior(@PathVariable BigDecimal preco){
		return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThan(preco));
	}
	
	@GetMapping("/medicamento_end/{medicamento}")
	public ResponseEntity<List<Produtos>> getByMedicamentoEnd(@PathVariable String medicamento){
		return ResponseEntity.ok(produtoRepository.findAllByMedicamentoEndingWithIgnoreCase(medicamento));
	}	
	
	@PostMapping
	public ResponseEntity<Produtos> postProdutos(@Valid @RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtos));
	}
	
	@PutMapping
	public ResponseEntity<Produtos> putProdutos(@Valid @RequestBody Produtos produtos){
		return produtoRepository.findById(produtos.getId())
				.map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produtos)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProdutos(@PathVariable Long id) {
		return produtoRepository.findById(id)
				.map(resposta -> {
					produtoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}