package controllers;

import java.util.List;
import java.util.stream.Collectors;

import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void welcome() {
    	render();
    }
    
    
 // SAVE USER
 	public static void saveUser( User user) {

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
 			
 			
 			//URL url = new URL("https://coinmarketcap.com/currencies/bitcoin/#markets");
 			//Scanner buff = new Scanner(url.openStream());
 			//String url_data = buff.nextLine();
 			//buff.close();
 			
 			user.save();

 			welcome();
 			
 		} else {
 			flash.error("błędne powtórzenie hasła");
 			index();
 		}

 	}
}

