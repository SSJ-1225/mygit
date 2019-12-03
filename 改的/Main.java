package 改的;

public class Main {
 	public static void main(String[] args) {
		 Customer customer = new Customer("小李");
		 Movie movie = new Movie("电影",2);
		 Rental rental =new Rental(movie,8);
		 customer.addRental(rental);
		 System.out.println("租用清单:\n"+customer.statement());
		    
	}
}
