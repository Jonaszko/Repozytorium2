package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;


@Entity
public class User extends Model {
	
	
	@Required(message="@message.enterValidaddress")
	public String addressToUser;  //adres pod ktory nalezy wyslac walute koncowa
	@Required(message="@message.enterValidaddress")
	public String addressFromUser;  //adres z ktorego uzytkownik wyslal walute pierwotna

	public String currencyToUser; //nazwa waluty ktora uzytkownik sobie zyczy
	public String currencyFromUser; //nazwa waluty ktora uzytkownik wyslal

	@Required(message="@message.enterCurrencyValueToReceive")
	public String amountToUser;  //wartosc waluty koncowej dla uzytkownika 
	@Required(message="@message.enterCurrencyValueForExchange")
	public String amountFromUser; //wartosc waluty pierwotnej od uzytkownika 

	public Double actualPriceCTU; //aktualna cena waluty koncowej dla uzytkownika 

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