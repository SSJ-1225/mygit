package carfactory;
import car.*;
public class BMWFactory implements CarFactory{
	public Car createCar(){
		return new BMW();
	}
}