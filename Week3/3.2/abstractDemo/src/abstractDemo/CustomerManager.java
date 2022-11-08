package abstractDemo;

public class CustomerManager {
	
	// Bu base sinifi strateji gorevi goruyor.
	BaseDatabaseManager databaseManager;
	
	public void getCustomers() {
		databaseManager.getData();
	}
}