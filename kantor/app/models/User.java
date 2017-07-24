package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class User extends Model {
 
    public String addressToUser;  //adres pod ktory nalezy wyslac walute koncowa
    public String addressFromUser;  //adres z ktorego uzytkownik wyslal walute pierwotna
    
    public String currencyToUser; //nazwa waluty ktora uzytkownik sobie zyczy
    public String currencyFromUser; //nazwa waluty ktora uzytkownik wyslal
    
    public Double amountToUser;  //wartosc waluty koncowej dla uzytkownika 
    public Double amountFromUser; //wartosc waluty pierwotnej od uzytkownika 

    
	public String email;
    public String password;
    public String fullname;
    public boolean isAdmin;
    
    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
 
}