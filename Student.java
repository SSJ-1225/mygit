public class student{
	public static void main(String[] args){
		System.out.println("1,添加学生信息");
		add();
		System.out.println("2,删除学生信息");
		remove();
		System.out.println("3,修改学生信息");
		alter();
		System.out.println("4,查找学生信息");
		find();
	}
	public static void add(){
		StringBuffer sb=new StringBuffer();
		sb.append("184805001 小李；184805002 小王");
		System.out.println("append添加结果："+sb);
		sb.insert(13,"184805005 小时; ");
		System.out.println("insert添加结果："+sb);
	}
	public static void remove(){
		StringBuffer sb=new StringBuffer("184805001小李；184805002 小王; 184805055 小飞");
		sb.delete(0,12);
		System.out.println("删除指定位置学生："+sb);
		sb.deleteCharAt(12);
		System.out.println("删除指定位置学生："+sb);
		sb.delete(0,sb.length());
		System.out.println("清空所有学生:"+sb);
	}
	public static void alter(){
		StringBuffer sb=new StringBuffer("184805001 小李；184805002 小王");
		sb.setCharAt(8,'6');
		System.out.println("修改指定位置信息："+sb);
		sb.replace(10,12,"娃娃");
		System.out.println("替换指定位置信息："+sb);
		System.out.println("信息翻转结果："+sb.reverse());
	}
	public static void find() {
	StringBuffer sb=new StringBuffer("184805001 小李；184805002 小王");
	sb.toString();
	System.out.println("第一名学生信息："+sb.substring(0,12));
}
}