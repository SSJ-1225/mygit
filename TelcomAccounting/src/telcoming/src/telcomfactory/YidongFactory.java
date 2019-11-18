package telcomfactory;

import telcom.Yidong;
import telcom.Telcom;

public class YidongFactory implements TelcomFactory{


	public Telcom produceTelcom() {
		return new Yidong();
	}

}
