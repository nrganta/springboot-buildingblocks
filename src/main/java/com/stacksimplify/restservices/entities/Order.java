package com.stacksimplify.restservices.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	public Long orderid;
	public Long getOrderid() {
		return orderid;
	}


	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}


	public String getOrderdescription() {
		return orderdescription;
	}


	public void setOrderdescription(String orderdescription) {
		this.orderdescription = orderdescription;
	}

	public String orderdescription;


	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
