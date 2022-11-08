package interfaces;

public class MySqlCustomerDal implements ICustomerDal { // Dal : Data Access Layer

	@Override
	public void add() {
		System.out.println("My SQL added.");

	}

}
