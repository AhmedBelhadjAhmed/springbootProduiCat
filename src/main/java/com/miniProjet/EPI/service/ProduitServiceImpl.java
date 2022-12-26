package com.miniProjet.EPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniProjet.EPI.dao.ProduitDao;
import com.miniProjet.EPI.model.Produit;

@Service
public class ProduitServiceImpl implements ProduitService{
 @Autowired
 private ProduitDao produitDao;
	@Override
	public Produit save(Produit produit) {
		// TODO Auto-generated method stub
		return produitDao.save(produit);
	}

	@Override
	public Produit findById(Long id) {
		// TODO Auto-generated method stub
		return produitDao.findById(id).orElse(null);
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return produitDao.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		produitDao.deleteById(id);
	}

}
