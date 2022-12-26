package com.miniProjet.EPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProjet.EPI.model.Produit;

public interface ProduitDao  extends JpaRepository<Produit, Long>{

}
