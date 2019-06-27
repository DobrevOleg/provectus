package com.dobrev.bookshop.repo;
import com.dobrev.bookshop.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

    @Query("SELECT b FROM BookEntity b WHERE b.genres LIKE CONCAT('%',:genre,'%')")
    List<BookEntity> getBooksbygenre(@Param("genre") String genre);
    @Query("SELECT b FROM BookEntity b WHERE b.authors LIKE CONCAT('%',:auth,'%')")
    List<BookEntity> getBooksbyauth(@Param("auth") String auth);
}

