package com.example.cats.cat;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.bson.BsonBinary;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;

@Service
public class CatService {

    @Autowired
    public CatRepository repository;

    public List<Cat> findAllCats(){
        return repository.findAll();
    }

    public Optional<Cat> findCatByName(String name){
        return repository.findCatByName(name);
    }

    public String addCat(String name, String description, MultipartFile file) throws IOException { 
        Cat cat = new Cat(name, description); 
        cat.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        cat = repository.insert(cat); 
        return cat.getName(); 
    }

    public Cat getCat(String id) { 
        return repository.findById(id).get(); 
    }
    
}
