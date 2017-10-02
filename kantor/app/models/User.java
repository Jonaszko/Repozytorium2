package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;


@Entity
public class User extends Model {
	
	
	@Required(message="@message.enterValidaddress")
	public String addressToUser; 
	@Required(message="@message.enterValidaddress")
	public String addressFromUser; 

	public String currencyToUser; 
	public String currencyFromUser; 

	@Required(message="@message.enterCurrencyValueToReceive")
	public String amountToUser;  
	@Required(message="@message.enterCurrencyValueForExchange")
	public String amountFromUser; 

	public Double actualPriceCTU;

	@Required(message="@message.giveName")
	public String name;
	public String surName;
	public String email;
	public String password;
	public String passwordRepeat;

	public boolean isAdmin;

	public User() {
       super();
    }
	
	public User(String addressToUser, 
			String addressFromUser, 
			String currencyToUser, 
			String currencyFromUser,
			String amountToUser,
			String amountFromUser,
			Double actualPriceCTU,
			String name,
			String surName,
			String email,
			String password,
			String passwordRepeat,
			boolean isAdmin) 
	{
	this.addressToUser = addressToUser;	
	this.addressFromUser = addressFromUser;
	this.currencyToUser = currencyToUser;
	this.currencyFromUser = currencyFromUser;
	this.amountToUser = amountToUser;
	this.amountFromUser = amountFromUser;
	this.actualPriceCTU = actualPriceCTU;
	this.name = name;
	this.surName = surName;
	this.email = email;
	this.password = password;
	this.passwordRepeat = passwordRepeat;
	this.isAdmin = isAdmin;
	}

}