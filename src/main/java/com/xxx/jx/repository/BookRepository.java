package com.xxx.jx.repository;

import com.xxx.jx.data.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
    Optional<BookEntity> findById(Long id);
}
