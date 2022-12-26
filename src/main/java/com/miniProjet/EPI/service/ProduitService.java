package com.miniProjet.EPI.service;

import java.util.List;

import com.miniProjet.EPI.model.Produit;

public interface ProduitService {
 public Produit save(Produit produit );
 public Produit findById(Long id);
 public List<Produit> findAll();
 public void delete(Long id);
}
