import java.util.Random;
class Storage {    
    private int[] cells = new int[10];  
    private int inPos,outPos;            
    private int count;  
    public synchronized void put(int num){
		try{
			while(count == cells.length){
				this.wait();
			}
			
		Random r=new Random();
        cells[inPos] = r.nextInt(100);
		//int转换成string : String.valueOf(12)
		String str1=String.valueOf(cells[inPos]);
		System.out.println(str1+"--用户登录  系统在线人数--"+count);
		
                inPos++;
                if(inPos == cells.length)
                    inPos = 0;               
                count++;
                this.notify();
            }catch (Exception e) {
				e.printStackTrace();
			}
	    }
		
        public synchronized void get(){
			try{
				while(count == 0){
				    this.wait();
				}
		String str2=String.valueOf(cells[outPos]);
		System.out.println(str2+"--用户注销  系统在线人数--"+count);
		
                cells[outPos] = 0;
                outPos++;
                if(outPos == cells.length)
                    outPos = 0;
                count--;
                this.notify();
            } catch (Exception e) {
                e.printStackTrace();
			}
		}
}
class Input implements Runnable {
            
    private Storage st;  
    Random l=new Random();	
	private int num;
	Input (Storage st){
		this.st= st;
	}
    public void run() {
		while(true){
			st.put(num++); 	
		}
	}
 }
class Output implements Runnable {
	private Storage st;
	Output(Storage st){                
    	this.st = st;
	}
	public void run() {
        while(true){
			st.get();
		
		}
	}
}

public class ExampleTest01{
	 public static void main(String[] args) {
		 Storage st = new Storage();                
		 Input input = new Input(st);            
		 Output output=new Output(st);            	 
		 new Thread(input).start();                
		 new Thread(output).start();
	 }
 }	 