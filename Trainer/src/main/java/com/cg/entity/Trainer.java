package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "trainer")
@GenericGenerator(name = "trainerid", strategy = "increment")
@NamedQuery(name = "findall", query = "Select t from Trainer t")
@NamedQuery(name = "findbyname", query = "Select t from Trainer t where t.name=:tname")
public class Trainer {
	public Trainer(int id, String name, String stream, int fees) {
		super();
		this.id = id;
		this.name = name;
		this.stream = stream;
		this.fees = fees;
	}
	public Trainer() {
	}
	@Id
	@GeneratedValue(generator = "trainerid", strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(length = 20)
	private String name ;
	@Column(length = 20)
	private String stream;
	private int fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	
	
	
	

}
