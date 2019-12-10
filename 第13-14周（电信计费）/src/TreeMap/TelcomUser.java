package TreeMap;
import java.util.*;
import java.text.*;
public class TelcomUser {
	 private String phoneNumber;
     private String callTo;
     private Vector communicationRecords;
     private LinkedHashMap singleRecord;
    private TreeMap treeMapCallToAndFee;
     public TelcomUser(String phoneNumber) {
    	 this.phoneNumber=phoneNumber;
    	 this.communicationRecords=new Vector();
    	 this.singleRecord=new LinkedHashMap();
    	 this.treeMapCallToAndFee=new TreeMap();
    	 
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
 			this.singleRecord = new  LinkedHashMap();
 			this.singleRecord.put("主叫", this.phoneNumber);
 			this.singleRecord.put("开始时间",simpleDateFormat.format(timeStart));
 			this.singleRecord.put("结束时间",simpleDateFormat.format(timeEnd));
 			this.singleRecord.put("被叫号码", this.callTo);
 			this.singleRecord.put("计费", this.accountFee(timeStart,timeEnd));
 			this.communicationRecords.add(this.singleRecord);
 
 		}
     }
     private String getCallToPhoneNumber() {
 		return "1380372000" + String.valueOf(new Random().nextInt(10));
 	}
     private String accountFee(long timeStart, long timeEnd) {
 		double feePerMinute = 0.2;
 		int minutes = Math.round((timeEnd - timeStart)/60000);
 		double feeTotal = feePerMinute * minutes;
 		return String.format("%.4f", feeTotal);
 	}
     void printDetails() {
    	 Iterator itRencords = this.communicationRecords.iterator();
    	 while(itRencords.hasNext()) {
    		 System.out.println("--------"+"通话记录"+"--------");
    		 this.singleRecord = ((LinkedHashMap)itRencords.next());
    		 Set entrySet = this.singleRecord.entrySet();
    		 Iterator itEntry = entrySet.iterator();
    		 while(itEntry.hasNext()){
    			 Map.Entry entry = (Map.Entry)itEntry.next();
    			 Object key = entry.getKey();
    			 Object value = entry.getValue();
    			 System.out.println(key+" : "+value);
    		 }
    	 }
     }
     void printCallToAndFee() {
    	 System.out.println("---"+"被叫号码"+" : "+"话费"+"---");
    	 Iterator it = this.treeMapCallToAndFee.entrySet().iterator();
    	 while(it.hasNext()) {
    		 Map.Entry entry=(Map.Entry)it.next();
    		 System.out.println(entry.getKey()+" : "+entry.getValue());
    	 }
     }
     
}
