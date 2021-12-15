package com.capg.hollywood.beans;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Movies {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message="Name should not be null")
	private String name;
	
	@Min(value=1000,message="Amount Should not less than 1000")
	@Max(value=10000,message="Amount Should not more than 10000")
	private double cost;

	public Movies() {
		
	}
	
	public Movies(int id, @NotNull(message = "Name should not be null") String name,
			@Min(value = 1000, message = "Amount Should not less than 1000") @Max(value = 10000, message = "Amount Should not more than 10000") double cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}

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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	


	
	
}
