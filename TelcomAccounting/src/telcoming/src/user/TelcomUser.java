package user;
import java.text.*;
import utility.Utility;
import java.util.*;

import telcom.Telcom;
import telcomfactory.TelcomFactory;

public class TelcomUser {
	public String phoneNumber;
	public String callTo;
	public StringBuffer communicationRecords;
	public Telcom  S;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new StringBuffer();
		
		TelcomFactory telcomfactory=(TelcomFactory)Utility.getBean();
		S=telcomfactory.produceTelcom();
		
	}
	//模拟通话记录的生成
	public void generateCommunicateRecord() {
		//随机生成通话记录的数目
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//随机生成第i条通话记录
			//开始时间，当前时间之前的某个随机时间
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			//开始时间开始后的十分钟内某个随机时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			//被叫号码
			this.callTo = getCallToPhoneNumber();
			//插入通话记录
			this.communicationRecords.append(this.phoneNumber + 
					"," + timeStart + 
					"," + timeEnd + 
					"," + this.callTo+
					";");
		}
	}
		//随机生成被叫号码（后四位随机）并返回
	public String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
	}
  //模拟计费方法，以字符串的形式返回保留四位小数的计费结果
	public String accountFee(long timeStart, long timeEnd) {
		//每分钟收费*元
		double feePerMinute =S.feePerMinute();
		//通话分钟数以四舍五入计算
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%f", feeTotal);
	}		
	//打印通话记录
	public void printDetails() {
		//获取全部通话记录
		String allRecords = this.communicationRecords.toString();
		//分割通话记录
		String [] recordArray = allRecords.split(";");
		//循环分割记录内的每一项并输出
		for(int i = 0; i < recordArray.length; i++) {
            System.out.println("---------通话记录分割线--------");
			String [] recordField = recordArray[i].split(",");
			System.out.println("主叫" + recordField[0]);
			System.out.println("被叫" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");		
			System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
			System.out.println("计费："
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ "元。");
		}
	}       
}		