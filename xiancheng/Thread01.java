public class Thread01{
     public static void main(String[] args) {
    	  new MyThread("Thread1").start();
    	  new MyThread("Thread2").start();
       }
}
class MyThread extends Thread{
    public MyThread(String name) {
 	   super(name);
    }
    public void run() {
 	   System.out.println(this.getName());
    }
}