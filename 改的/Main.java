package �ĵ�;

public class Main {
 	public static void main(String[] args) {
		 Customer customer = new Customer("С��");
		 Movie movie = new Movie("��Ӱ",2);
		 Rental rental =new Rental(movie,8);
		 customer.addRental(rental);
		 System.out.println("�����嵥:\n"+customer.statement());
		    
	}
}
