package ArrayList;

public class TelcomAccountSystem {
	public static void main(String[] args) {
		//ʵ����һ�������û���TelcomUser
		TelcomUserArrayList telcomUser = new TelcomUserArrayList("13800138000");
		//����ͨ����¼
		telcomUser.generateCommunicateRecord();
		//��ӡͨ���굥
		telcomUser.printDetails();
	}
}
