import car.*;
import carfactory.*;

public class TestDriver{
	public static void main (String [] args){
		Car c1 = new AodiFactory().createCar();
		Car c2 = new BMWFactory().createCar();
		c1.run();
		c2.run();
	}
}