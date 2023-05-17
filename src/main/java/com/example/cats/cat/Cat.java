package com.example.cats.cat;
import java.util.List;

import org.bson.BsonBinary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "cats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    // Id of this cat
    @Id
    private String name;

    private String description;

    private BsonBinary image;

    Cat(String name, String description){
        this.name=name;
        this.description=description;
    }
    
}
