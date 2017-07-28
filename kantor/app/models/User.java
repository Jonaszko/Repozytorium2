package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

//@Entity
public class User extends Model {

	public String addressToUser;  //adres pod ktory nalezy wyslac walute koncowa
	public String addressFromUser;  //adres z ktorego uzytkownik wyslal walute pierwotna

	public String currencyToUser; //nazwa waluty ktora uzytkownik sobie zyczy
	public String currencyFromUser; //nazwa waluty ktora uzytkownik wyslal

	public Double amountToUser;  //wartosc waluty koncowej dla uzytkownika 
	public Double amountFromUser; //wartosc waluty pierwotnej od uzytkownika 

	public Double actualPriceCTU; //aktualna cena waluty koncowej dla uzytkownika 

	public String name;
	public String surName;
	public String email;
	public String password;
	public String passwordRepeat;

	public boolean isAdmin;

	public User(String addressToUser, 
			String addressFromUser, 
			String currencyToUser, 
			String currencyFromUser,
			Double amountToUser,
			Double amountFromUser,
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