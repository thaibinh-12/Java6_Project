package com.shopme.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private Type type;	
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	
	@Column(name = "name",columnDefinition = "nvarchar(255)")
	private String name;
	@Column(name = "description", length = 1000,columnDefinition = "nvarchar(max)")
	private String description;
	@Column(name = "date")
	private Date date;
	@Column(name = "image")
	private String image;
	@Column(name = "status")
	private int status;
	
	@OneToMany(mappedBy = "product")
	private List<Variant> variants = new ArrayList<>();
	
	@OneToMany(mappedBy = "product")
	private List<Favorite> favorites = new ArrayList<>();
}
