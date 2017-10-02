package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void welcome(double price1, double price2, String name1, String name2) {
    	render("@welcome", price1, price2, name1, name2);
    }
    
    // download form url
    public static String takeHTML(URL url, String phrase) throws Exception {

        BufferedReader take = new BufferedReader(
                              new InputStreamReader(
                               url.openStream()
                               )
                               );
        String temp;
        String s = "";
        
        while ((temp = take.readLine()) != null) {
        	if((temp.indexOf(phrase) != -1)) {
              s +=(temp + "\n");
        	}
              }

        take.close();

      
        int beginIndex;	
        beginIndex = s.indexOf("$");
        s=s.substring(beginIndex);
        int endIndex = s.indexOf(" ");
        s=s.substring(1,endIndex);		
        
        return s;
     }
    
    
 // SAVE USER
 	public static void saveUser( User user) throws Exception {

 		List<User> users = User.findAll();
 		
 		for(int i=0; i<users.size(); i++) {
 			if(users.get(i).name.equals(user.name)) {
 				flash.error("@message.existUserWithSpecifiedLogin");
 				index();
 			}
 		}
 		
 		if (user.password.equals(user.passwordRepeat)) {
 			if (validation.hasErrors()) {
 				String text = validation.errors().stream().map(x -> x.getMessageKey()).collect(Collectors.joining(", "));
 				flash.error(text);
 				index();
 			}
 			
 			
 			
 			user.save();
 			
 			String link1="";
 			String link2="";
 			
 			int beginIndex1;	
 			int beginIndex2;
 			
 	        beginIndex1 = user.currencyFromUser.indexOf("(");
 	        beginIndex2 = user.currencyToUser.indexOf("(");
 	        
 			String phrase1 = user.currencyFromUser.substring(beginIndex1);
 			String phrase2 = user.currencyToUser.substring(beginIndex2);
 			
 			user.currencyFromUser = user.currencyFromUser.substring(0,beginIndex1);
 			user.currencyToUser = user.currencyToUser.substring(0,beginIndex2);
 			
 			URL urlToPriceCurrencyFromUser =  new URL("https://coinmarketcap.com/currencies/"+user.currencyFromUser);
 			URL urlToPriceCurrencyToUser =  new URL("https://coinmarketcap.com/currencies/"+user.currencyToUser);
 			
 			link1 = takeHTML(urlToPriceCurrencyFromUser, phrase1);
 			link2 = takeHTML(urlToPriceCurrencyToUser, phrase2);
 			
 			double price1 = Double.parseDouble(link1);
 			double price2 = Double.parseDouble(link2);
 			
 			System.out.println(price1);
 			System.out.println(price2);

 			welcome(price1,price2,user.currencyFromUser,user.currencyToUser);
 			
 		} else {
 			flash.error("@message.incorrectPasswordRepetition");
 			index();
 		}

 	}
 	
 	public static void saveTransaction(User user) {
 		
 	}
 	
}

