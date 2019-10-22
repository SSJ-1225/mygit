public class car01{
	public static void main(String[] args){
		Taxi ta = new Taxi();
		new Thread (ta,"出租车1").start();
		new Thread (ta,"出租车2").start();
		new Thread (ta,"出租车3").start();
		new Thread (ta,"出租车4").start();
		new Thread (ta,"出租车5").start();
	} 
}
class Taxi implements Runnable{
	private int passenger =100;
	public void run(){
		while(true){
			if (passenger>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"正在接送第"+passenger--+"个客人");
			}
		}
	}
}
