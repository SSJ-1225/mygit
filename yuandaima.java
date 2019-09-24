interface Car {
	void run();
	
}
class Aodi implements Car {
	public void run (){
		System.out.println("°ÂµÏÔÚÅÜ");
	}
}
class BMW implements Car{
	public void run (){
		System.out.println("±¦ÂíÔÚÅÜ");
	}
}
public class TestDriver {
	public static void main(String[] args){
		Car aodi = new Aodi();
		Car bmw  =  new BMW();
		
	   aodi.run();
       bmw.run();
	}
	
}