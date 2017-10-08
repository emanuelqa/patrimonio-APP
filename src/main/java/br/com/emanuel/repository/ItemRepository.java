package br.com.emanuel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emanuel.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
