package domainPackage;

import presentationPackage.Person;

public class Login {
	
	// throws InvalidLoginException
	
	// Login class implementing singleton pattern
	
	// Connect to database controller
	
	static Login instance;
	
	public static Login getInstance() {
		if(instance == null) {
			instance = new Login();
		}
		return instance;
	}

	private Login() {
		
	}
	
	public void logInUser(Person p) {
		// Accesses database with person credentials
		
	}
	
}
