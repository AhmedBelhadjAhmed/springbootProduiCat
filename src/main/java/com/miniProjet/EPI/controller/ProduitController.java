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
import com.miniProjet.EPI.model.Produit;
import com.miniProjet.EPI.service.CategorieService;
import com.miniProjet.EPI.service.ProduitService;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/produits")
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private CategorieService categorieService;
	@GetMapping("/list")
	public ResponseEntity<List<Produit>> listProduits(){
		return new ResponseEntity<>(produitService.findAll(),HttpStatus.OK);
	}
	@GetMapping("/categories")
	public ResponseEntity<List<Categories>> listCategories(){
		return new ResponseEntity<>(categorieService.findAll(),HttpStatus.OK);
	}
	@PostMapping("/creer")
	public ResponseEntity<Produit> creerProduit(@RequestBody Produit produit) {
		return new ResponseEntity<>(produitService.save(produit) , HttpStatus.CREATED );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produit> getProduct(@PathVariable Long id){
		return new ResponseEntity<>(produitService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Produit> editProduit(@PathVariable Long id, @RequestBody Produit produit){
		 Produit produitTrouve = produitService.findById(id);
		 if(produitTrouve == null) {
			 return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
		 try {
			 produitTrouve.setNomp(produit.getNomp());
			 produitTrouve.setPrix(produit.getPrix());
			 produitTrouve.setImage(produit.getImage());
			 produitTrouve.setQuantite(produit.getQuantite());
			 produitTrouve.setCategories(produit.getCategories());
			 return new  ResponseEntity<>(produitService.save(produitTrouve), HttpStatus.CREATED);
		} catch (Exception e) {
			return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("supprimer/{id}")
	public ResponseEntity<?> supprimerProduit(@PathVariable Long id){
		produitService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
