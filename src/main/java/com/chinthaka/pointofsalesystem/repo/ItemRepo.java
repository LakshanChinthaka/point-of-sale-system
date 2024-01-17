package com.chinthaka.pointofsalesystem.repo;

import com.chinthaka.pointofsalesystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Long> {
}
