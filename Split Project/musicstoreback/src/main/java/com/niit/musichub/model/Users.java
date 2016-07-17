package com.niit.musichub.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class Users implements Serializable{
	
	@Id
	private int userid;
	private String username;
	private String usernumber;
	private String useremail;
	private String userloginname;
	private String userloginpassword;
	


    @OneToOne
    @JoinColumn(name = "billsId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shipId")
    private ShippingAddress shippingAddress;
    
    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserloginname() {
		return userloginname;
	}

	public void setUserloginname(String userloginname) {
		this.userloginname = userloginname;
	}

	public String getUserloginpassword() {
		return userloginpassword;
	}

	public void setUserloginpassword(String userloginpassword) {
		this.userloginpassword = userloginpassword;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


    
    
}
