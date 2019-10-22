public class Test01{
	public static void main(String[] args){
		Teacher t=new Teacher();
		new Thread(t,"老师1").start();
		new Thread(t,"老师2").start();
		new Thread(t,"老师3").start();
	}
}
class Teacher implements Runnable{
	private int notes =80;
	public void run(){
		while(true){
			dispatchNotes();
			if(notes<=0){
				break;
			}
		}
	}
	private synchronized void dispatchNotes(){
		if(notes>0){
			try{
			Thread.sleep(10);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +"---发出的笔记"+ notes--);
		}
	}
	
}