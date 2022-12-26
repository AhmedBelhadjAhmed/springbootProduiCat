package com.miniProjet.EPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miniProjet.EPI.model.Categories;
import com.miniProjet.EPI.service.CategorieService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/categories")
public class CategorieController {
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Categories>> listCategories(){
		return new ResponseEntity<>(categorieService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/creer")
	public ResponseEntity<Categories> creerCategorie(@RequestBody Categories categories) {
		return new ResponseEntity<>(categorieService.save(categories) , HttpStatus.CREATED );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categories> getCategorie(@PathVariable Long id){
		return new ResponseEntity<>(categorieService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Categories> editCategorie(@PathVariable Long id, @RequestBody Categories categories){
		Categories categorieTrouve = categorieService.findById(id);
		 if(categorieTrouve == null) {
			 return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
		 try {
			 categorieTrouve.setNomg(categories.getNomg());
	
			 return new  ResponseEntity<>(categorieService.save(categorieTrouve), HttpStatus.CREATED);
		} catch (Exception e) {
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("supprimer/{id}")
	public ResponseEntity<?> supprimercategorie(@PathVariable Long id){
		categorieService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
