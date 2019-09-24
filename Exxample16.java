class Outer{
	private int num=4;
	public void test(){
		Inner inner=new Inner();
		inner.show();
	}
	class Inner {
		void show(){
			System.out.println("num="+num);
		}
	}
}
public class Example16{
	public static void main(String[] args){
		Outer outer=new Outer();
		outer.test();
	}
}
