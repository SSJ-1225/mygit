interface Car {
	void run ();
		
	
}
class Aodi implements Car{
	public void run(){
		System.out.println("奥迪车在跑");
	}
	
}
class BMW implements Car{
	public void run(){
		System.out.println("宝马车在跑");
	}
}
class CarFactory{
	public static Car create(String str){
		if(str.equals("奥迪")){
			return new Aodi();
		}
		else if(str.equals("宝马")){
			return new BMW();
		}
		return null;
	}
}
public class TestDriver01{
	public static void main (String[] args){
		Car aodi =CarFactory.create("奥迪");
		Car bmw =CarFactory.create("宝马");
		aodi.run();
		bmw.run();
		}
	
}