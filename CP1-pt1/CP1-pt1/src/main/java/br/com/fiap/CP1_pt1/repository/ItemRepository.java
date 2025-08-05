package br.com.fiap.CP1_pt1.repository;

import br.com.fiap.CP1_pt1.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}