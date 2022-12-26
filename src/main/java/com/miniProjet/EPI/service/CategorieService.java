package com.miniProjet.EPI.service;

import java.util.List;



import com.miniProjet.EPI.model.Categories;



public interface CategorieService {

  public List<Categories> findAll();
  public Categories save(Categories categories );
  public Categories findById(Long id);
  public void delete(Long id);
  
}
