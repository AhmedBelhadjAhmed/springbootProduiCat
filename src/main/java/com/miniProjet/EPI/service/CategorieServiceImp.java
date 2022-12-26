package com.miniProjet.EPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniProjet.EPI.dao.CategorieDao;
import com.miniProjet.EPI.model.Categories;
@Service
public class CategorieServiceImp implements CategorieService{
   @Autowired
   private CategorieDao categorieDao;
	@Override
	public List<Categories> findAll() {
		// TODO Auto-generated method stub
		return categorieDao.findAll();
	}
	@Override
	public Categories save(Categories categories) {
		// TODO Auto-generated method stub
		return categorieDao.save(categories);
	}
	@Override
	public Categories findById(Long id) {
		// TODO Auto-generated method stub
		return categorieDao.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categorieDao.deleteById(id);
	}

}
