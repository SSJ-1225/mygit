package TreeSet;

public class TelcomAccountSystem {
	public static void main(String[] args) {
		//ʵ����һ�������û���TelcomUser
		TelcomUserTreeSet telcomUser = new TelcomUserTreeSet("13800138000");
		//����ͨ����¼
		telcomUser.generateCommunicateRecord();
		//��ӡͨ���굥
		telcomUser.printCallToNumber();
	}


}
