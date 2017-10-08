package br.com.emanuel.resource;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.emanuel.model.Item;
import br.com.emanuel.repository.ItemRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class ItemResource {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/itens")
	public List<Item> lista(){
		return this.itemRepository.findAll();
	}
	@PostMapping("/item")
	public ResponseEntity<?> add(@RequestBody @Valid Item item){
		return new ResponseEntity<>(this.itemRepository.save(item), HttpStatus.CREATED);
	}
	
	@PutMapping("/item")
	public ResponseEntity<?> editar(@RequestBody Item item){
		return new ResponseEntity<>(this.itemRepository.save(item), HttpStatus.OK);
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		this.itemRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
