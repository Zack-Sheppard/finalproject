package domainPackage;

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
	
}
