package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void welcome(double price) {
    	render("@welcome", price);
    }
    
    // download form url
    public static String takeHTML(URL url, String phrase) throws Exception {

        BufferedReader pobierz = new BufferedReader(
                              new InputStreamReader(
                               url.openStream()   // zwraca InputStream związany z URLem
                               )
                               );
        String temp;
        String s = "";
        
        while ((temp = pobierz.readLine()) != null) {
        	if((temp.indexOf(phrase) != -1)) {
              s +=(temp + "\n");
        	}
              }

        pobierz.close();

       // wyciecie tylko wartosci liczbowej ze stringa
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
 				flash.error("Istnieje użytkownik o podanym loginie, wybierz inny");
 				index();
 			}
 		}
 		
 		if (user.password.equals(user.passwordRepeat)) {
 			if (validation.hasErrors()) {
 				String text = validation.errors().stream().map(x -> x.getMessageKey())
 						.collect(Collectors.joining(", "));
 				flash.error(text);
 				index();

 			}
 			
 			
 			String link1="";
 			List <String> nameCurrency = new ArrayList<String>();
 			nameCurrency.add("bitcoin");
 			nameCurrency.add("litecoin");
 			
 			URL url=  new URL("https://coinmarketcap.com/currencies/"+nameCurrency.get(1));
 			List <String> phrase = new ArrayList<String>();
 			phrase.add("(BTC)  $");	
 			phrase.add("(LTC)  $");
 			link1 = takeHTML(url, phrase.get(1));
 			
 			double price1 = Double.parseDouble(link1);
 			System.out.println(price1);
 			
 			user.save();

 			welcome(price1);
 			
 		} else {
 			flash.error("błędne powtórzenie hasła");
 			index();
 		}

 	}
}

