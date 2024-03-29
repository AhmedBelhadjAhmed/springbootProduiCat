package com.miniProjet.EPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="categories")
public class Categories {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private String nomg;
	
}
