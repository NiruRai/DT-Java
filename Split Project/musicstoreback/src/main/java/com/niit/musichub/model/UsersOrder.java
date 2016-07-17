package com.niit.musichub.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class UsersOrder implements Serializable{
	
	@Id
	@GeneratedValue
	private int orderId;
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@OneToOne 
	@JoinColumn(name="userid")
	private Users users;
	
	@OneToOne
	@JoinColumn(name="billsId")
	private BillingAddress billsaddress;
	
	@OneToOne
	@JoinColumn(name="shipId")
	private ShippingAddress shipaddress;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public BillingAddress getBillsaddress() {
		return billsaddress;
	}

	public void setBillsaddress(BillingAddress billsaddress) {
		this.billsaddress = billsaddress;
	}

	public ShippingAddress getShipaddress() {
		return shipaddress;
	}

	public void setShipaddress(ShippingAddress shipaddress) {
		this.shipaddress = shipaddress;
	}
	
	

}
