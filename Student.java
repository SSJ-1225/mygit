public class student{
	public static void main(String[] args){
		System.out.println("1,���ѧ����Ϣ");
		add();
		System.out.println("2,ɾ��ѧ����Ϣ");
		remove();
		System.out.println("3,�޸�ѧ����Ϣ");
		alter();
		System.out.println("4,����ѧ����Ϣ");
		find();
	}
	public static void add(){
		StringBuffer sb=new StringBuffer();
		sb.append("184805001 С�184805002 С��");
		System.out.println("append��ӽ����"+sb);
		sb.insert(13,"184805005 Сʱ; ");
		System.out.println("insert��ӽ����"+sb);
	}
	public static void remove(){
		StringBuffer sb=new StringBuffer("184805001С�184805002 С��; 184805055 С��");
		sb.delete(0,12);
		System.out.println("ɾ��ָ��λ��ѧ����"+sb);
		sb.deleteCharAt(12);
		System.out.println("ɾ��ָ��λ��ѧ����"+sb);
		sb.delete(0,sb.length());
		System.out.println("�������ѧ��:"+sb);
	}
	public static void alter(){
		StringBuffer sb=new StringBuffer("184805001 С�184805002 С��");
		sb.setCharAt(8,'6');
		System.out.println("�޸�ָ��λ����Ϣ��"+sb);
		sb.replace(10,12,"����");
		System.out.println("�滻ָ��λ����Ϣ��"+sb);
		System.out.println("��Ϣ��ת�����"+sb.reverse());
	}
	public static void find() {
	StringBuffer sb=new StringBuffer("184805001 С�184805002 С��");
	sb.toString();
	System.out.println("��һ��ѧ����Ϣ��"+sb.substring(0,12));
}
}