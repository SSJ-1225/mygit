public class Test01{
	public static void main(String[] args){
		Teacher t=new Teacher();
		new Thread(t,"��ʦ1").start();
		new Thread(t,"��ʦ2").start();
		new Thread(t,"��ʦ3").start();
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
			System.out.println(Thread.currentThread().getName() +"---�����ıʼ�"+ notes--);
		}
	}
	
}