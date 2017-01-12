package serverpackage;

import com.sample.*;

public class ServerClass {

	public static TransactionDetails userdetail = new TransactionDetails();
	
	public static void fetchdetails(long cardnum, String city, int amount)
	{
			userdetail.setCardNumber(cardnum);
			userdetail.setCity(city);
			userdetail.setAmount(amount);
	}

	public static int main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println("Card Number : " + userdetail.getCardNumber());
		System.out.println("City : " + userdetail.getCity());
		System.out.println("Amount : " + userdetail.getAmount());
		System.out.println("Initial Max Limit : " + userdetail.getMaxLimit());
		
		new DroolsTest().RunDrools(userdetail);
		//DroolsTest.main(null);
		
		System.out.println("Maximum limit set to - " + userdetail.getMaxLimit());
		
		//Validating the transaction
		
		if(userdetail.getAmount() > userdetail.getMaxLimit()) {
			return 1;
		}
		else {
			return 0;
		}		
	}
}