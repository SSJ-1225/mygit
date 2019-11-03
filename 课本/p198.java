public class p198{
public static void main(String[] args) {
for (int i = 0; i < 10; i++) {
int k = i * 10 + 1;
Add add = new Add(k);
add.start();
}
try {
Thread.sleep(30);
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("10个线程结果相加为：" + Add.sum);
}
}
class Add extends Thread {
static int sum;
private int number;
public Add(int n) {
number = n;
}
public void run() {
int count = 0;
for (int i = 0; i < 10; i++) {
count = count + number + i;
}
System.out.println(number + "+" + (number + 1) + "+" + (number + 2) + "+" + (number + 3) + "+" + (number + 4)
+ "+" + (number + 5) + "+" + (number + 6) + "+" + (number + 7) + "+" + (number + 8) + "+" + (number + 9)
+ "=" + count);
sum = sum + count;
}
}





