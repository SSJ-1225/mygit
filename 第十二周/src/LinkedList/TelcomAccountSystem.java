package LinkedList;

public class TelcomAccountSystem {
	public static void main(String[] args) {
		//ʵ����һ�������û���TelcomUser
		TelcomUserLinkedList telcomUser = new TelcomUserLinkedList("13800138000");
		//����ͨ����¼
		telcomUser.generateCommunicateRecord();
		//��ӡͨ���굥
		telcomUser.printDetails();
	}

}
