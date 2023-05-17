package com.example.cats.cat;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends MongoRepository<Cat, String>{
    Optional<Cat> findCatByName(String name);
}
