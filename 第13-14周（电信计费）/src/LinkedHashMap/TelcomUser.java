package LinkedHashMap;
import java.util.*;
import java.text.*;
public class TelcomUser {
	private String phoneNumber;
    private String callTo;
    private Vector communicationRecords;
    private LinkedHashMap singleRecord;

    public TelcomUser(String phoneNumber) {
   	 this.phoneNumber=phoneNumber;
   	 this.communicationRecords=new Vector();
   	 this.singleRecord=new LinkedHashMap();
      }

    void generateCommunicateRecord() {
    	
   	 int recordNum=new Random().nextInt(10);
   	 
   	 for(int i = 0; i <= recordNum; i++) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			long timeStart = cal.getTimeInMillis();
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
			this.callTo = getCallToPhoneNumber();
			this.singleRecord=new LinkedHashMap();
			this.singleRecord.put("主叫", this.phoneNumber);
			this.singleRecord.put("开始时间",simpleDateFormat.format(timeStart));
			this.singleRecord.put("结束时间",simpleDateFormat.format(timeEnd));
			this.singleRecord.put("被叫号码", this.callTo);
			this.singleRecord.put("计费", this.accountFee(timeStart,timeEnd));
			this.communicationRecords.add(this.singleRecord);
	
		}
    }
    private String getCallToPhoneNumber() {
		return "1380372010" + String.valueOf(new Random().nextInt(10));
	}
    private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.5;
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
    
    void printDetails() {
   	 Iterator itRecord = this.communicationRecords.iterator();
		 while(itRecord.hasNext()) {
			System.out.println("---------"+"通话记录分割线"+"---------");
			this.singleRecord = ((LinkedHashMap)itRecord.next());
			Set keySet = this.singleRecord.keySet();
			Iterator itKey = keySet.iterator();
			while(itKey.hasNext()) {
				Object key = itKey.next();
				Object value = this.singleRecord.get(key);
				System.out.println(key+":"+value);
			}
		}
    }   
}
