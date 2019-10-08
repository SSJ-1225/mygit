package carfactory;
import car.*;
public class AodiFactory implements CarFactory{
	public Car createCar(){
		return new Aodi();
	}
}