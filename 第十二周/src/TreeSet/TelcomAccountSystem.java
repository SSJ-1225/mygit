package TreeSet;

public class TelcomAccountSystem {
	public static void main(String[] args) {
		//实例化一个电信用户类TelcomUser
		TelcomUserTreeSet telcomUser = new TelcomUserTreeSet("13800138000");
		//生成通话记录
		telcomUser.generateCommunicateRecord();
		//打印通话详单
		telcomUser.printCallToNumber();
	}


}
