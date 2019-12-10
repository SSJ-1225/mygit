package HashMap;
import java.util.*;
import java.text.*;
public class TelcomUser{
	private String phoneNumber;
	private String callTo;
	private ArrayList communicationRecords;
	private HashMap singleRecord;
	
	public TelcomUser(String phoneNumber) {
		this.phoneNumber=phoneNumber;
		this.communicationRecords= new ArrayList();
		this.singleRecord = new HashMap();
		}
	
	//模拟通话记录的生成
	void generateCommunicateRecord() {
		//随机生成通话记录数目
		int recordNum = new Random().nextInt(10);
		for(int i = 0;i<= recordNum; i++) {
			//随机生成第i条通话记录
			//用Calendar获取当前时间
			//Calendar cal = Calendar.getInstance();
			//随即减去若干小时（10小时以内）
			//cal.add(Calendar.HOUR, - new Random().nextInt(600000));
			//获取对应毫秒
			long timeStart = System.currentTimeMillis()-new Random().nextInt(36000000);
			//long timeStart = cal.getTimeInMillis();
			//结束时间开始后的十秒内随机的一个时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
			//被叫号码
			this.callTo = getCallToPhoneNumber();
			//插入通话记录
			this.singleRecord = new HashMap();
			this.singleRecord.put("主叫", this.phoneNumber);
			this.singleRecord.put("开始时间", simpleDateFormat.format(timeStart));
			this.singleRecord.put("结束时间", simpleDateFormat.format(timeEnd));
			this.singleRecord.put("被叫号码", this.callTo);
			this.singleRecord.put("计费", this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singleRecord);
		}
	}
	public String getCallToPhoneNumber() {
		return "1380372000" + String.valueOf(new Random().nextInt(10));
	}
	
    //模拟计费方法，以字符串的形式返回保留4位小数的计费结果
	public String accountFee(long timeStart,long timeEnd) {
		//每分钟收费*元
		double feePerMinute=0.3;
		//通话分钟数按四舍五入计算
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute*minutes;
		return String.format("%.4f",feeTotal);
	}

	//打印通话记录
    void printDetails() {
    	
    	Iterator itRecords = this.communicationRecords.iterator();
    	while(itRecords.hasNext()) {
    		System.out.println("--------通话记录分割线--------");
    		this.singleRecord = ((HashMap)itRecords.next());
    		Set entrySet = this.singleRecord.entrySet();
    		Iterator itEntry = entrySet.iterator();
    		while(itEntry.hasNext()) {
    			Map.Entry entry = (Map.Entry)itEntry.next();
    			Object key = entry.getKey();
    			Object value = entry.getValue();
    			System.out.println(key + ":" + value);
    		}
    	
    	}
    }
}
