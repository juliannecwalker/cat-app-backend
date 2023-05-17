package com.example.cats.cat;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService service;

    @GetMapping
    public ResponseEntity<List<Cat>> getAllCats(){
        return new ResponseEntity<List<Cat>>(service.findAllCats(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public String getSingleCat(@PathVariable String name, Model model) {
        Cat cat= service.getCat(name);
        model.addAttribute("name", cat.getName());
        model.addAttribute("description", cat.getDescription());
        model.addAttribute("image", 
        Base64.getEncoder().encodeToString(cat.getImage().getData()));
        return "cats";
    }

    @PostMapping("/new")
    public String addPhoto(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("image") MultipartFile image, Model model) 
    throws IOException {
        String id = service.addCat(name, description, image);
        return "redirect:/" + id;
    }
    
}
