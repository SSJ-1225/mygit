package HashSet;

public class TelcomAccountSystem {
	public static void main(String[] args) {
		//ʵ����һ�������û���TelcomUser
		TelcomUserHashSet telcomUser = new TelcomUserHashSet("13800138000");
		//����ͨ����¼
		telcomUser.generateCommunicateRecord();
		//��ӡͨ���굥
		telcomUser.printCallToNumber();
	}

}
