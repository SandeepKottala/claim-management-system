package com.findit.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findit.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
