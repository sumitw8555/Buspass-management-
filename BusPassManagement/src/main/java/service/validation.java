package service;

public class validation {
	 public boolean Validation(String user, String password) {
			if(user.equals("admin")&& password.equals("123")) {
				return true;
				
			}
			else {
				return false;
			}
	 }
}
