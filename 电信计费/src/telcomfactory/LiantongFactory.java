package telcomfactory;
import telcom.Liantong;
import telcom.Telcom;
public class LiantongFactory implements TelcomFactory{
	public Telcom produceTelcom() {
		
		return new Liantong();
	}

}
