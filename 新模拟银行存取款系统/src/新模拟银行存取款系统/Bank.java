package 新模拟银行存取款系统;
import java.util.*;
public class Bank {
	int account;  //金额
	private static User user;  //用户
	private Scanner in;
	private Scanner in2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = new Bank();
		b.login();
		b.operate();
	}
	
	//账户金额存入、取出和查询操作
	public void operate() {
		Bank b = new Bank();
		while(true) {
			System.out.println("请输入您要进行的操作类型，按回车键结束");
			System.out.println("存款：1" + "\t" + "取款：2" + "\t" + "余额：3" + "\t" + "退出：0" );
		    in = new Scanner(System.in);
		    String s = in.nextLine(); //输入的操作类型
		    if("1".equals(s)||"2".equals(s)) {
		    	int num = 0;
		    	try {
		    		System.out.println("输入存取金额：");
		    		num = Integer.parseInt(in.nextLine());
		    	}catch(Exception e) {
		    		System.out.println("金额输入错误！");
		    		continue;
		    	}
		    	switch(s) {
		    	case "1": //存款
		    		b.income(num);
		    		break;
		    	case "2": //取款
		    		b.takeout(num);
		    		break;
		    	}
		    }else if("3".equals(s)) {
		    	b.show();
		    }else if("0".equals(s)) {
		    	System.out.println("退出系统！");
		    	return;
		    }else {
		    	System.out.println("请输入0~3之间的数字选择相关操作！");
		    }
		}
	}
	
	//登录
	public  void login() {
		DBUtil dbutil = DBUtil.getInstance();
		Bank b = new Bank();
		System.out.println("欢迎进入网上银行系统！");
		System.out.println("请选择是否注册用户");
		System.out.println("开户请按4  退出请按0");
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		if("4".equals(s)) {
			b.register();
			b.save();
			System.out.println("注册成功！");		
		}
		while(true) {
			in2 = new Scanner(System.in);
			System.out.println("请输入银行卡号：");
			String cardId = in2.nextLine();
			System.out.println("请输入银行卡密码：");
			String cardPwd = in2.nextLine();
			user = dbutil.getUser(cardId);
			
			//登录
			if(dbutil.getUsers().containsKey(cardId)&&user.getCardPwd().equals(cardPwd)) {
				System.out.println("登录成功！欢迎" + user.getUserName() + "先生");
				break;
			}else {
				System.out.println("银行卡号或密码错误！");
				continue;
			}
		}
	}
	
	//存款
	public void income(int num) {
		account = user.getAccount() + num;
		user.setAccount(account);
		System.out.println("存入金额" + num + "元成功");
	}
	
	//取款
	public void takeout(int num) {
		if(user.getAccount()>=num) {
			account = user.getAccount() - num;
			user.setAccount(account);
			System.out.println("取出金额" + num + "元成功");
		}else {
			System.out.println("余额不足，取款失败");
		}
		
	}
	
	//余额查询
	public void show() {
		account = user.getAccount();
		System.out.println("账户余额为" + account + "元");
	}
	
	private void save() {
		DBUtil dbutil = DBUtil.getInstance();
		dbutil.update();
	}
	
	//创建用户
	private void register() {
		User u = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入卡号：");
		u.setCardId(scanner.nextLine());
		System.out.println("输入用户名：");
		u.setUserName(scanner.nextLine());
		System.out.println("输入密码：");
		u.setCardPwd(scanner.nextLine());
		System.out.println("输入手机号：");
		u.setCall(scanner.nextLine());
		System.out.println("输入余额：");
		u.setAccount(scanner.nextInt());
		DBUtil dbUtil=DBUtil.getInstance();	
		dbUtil.addUser(u);
	}
}
