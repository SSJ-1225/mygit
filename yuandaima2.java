interface Car{
	void run();
}
class Aodi implements Car{
	public void run(){
		System.out.println("奥迪车在跑");
	}
}
class BMW implements Car {
	public void run(){
		System.out.println("宝马车在跑");
		
	}
}
interface CarFactory{
	Car createCar();
}
class AodiFactory implements CarFactory{
	public Car createCar(){
		return new Aodi();
	}
}
class BMWFactory implements CarFactory{
	public Car createCar(){
		return new BMW();
	}
}
public class TestDriver02{
	public static void main (String [] args){
		Car c1 = new AodiFactory().createCar();
		Car c2 = new BMWFactory().createCar();
		c1.run();
		c2.run();
	}
}