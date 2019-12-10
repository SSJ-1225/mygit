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
	
	//ģ��ͨ����¼������
	void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum = new Random().nextInt(10);
		for(int i = 0;i<= recordNum; i++) {
			//������ɵ�i��ͨ����¼
			//��Calendar��ȡ��ǰʱ��
			//Calendar cal = Calendar.getInstance();
			//�漴��ȥ����Сʱ��10Сʱ���ڣ�
			//cal.add(Calendar.HOUR, - new Random().nextInt(600000));
			//��ȡ��Ӧ����
			long timeStart = System.currentTimeMillis()-new Random().nextInt(36000000);
			//long timeStart = cal.getTimeInMillis();
			//����ʱ�俪ʼ���ʮ���������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			//���к���
			this.callTo = getCallToPhoneNumber();
			//����ͨ����¼
			this.singleRecord = new HashMap();
			this.singleRecord.put("����", this.phoneNumber);
			this.singleRecord.put("��ʼʱ��", simpleDateFormat.format(timeStart));
			this.singleRecord.put("����ʱ��", simpleDateFormat.format(timeEnd));
			this.singleRecord.put("���к���", this.callTo);
			this.singleRecord.put("�Ʒ�", this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singleRecord);
		}
	}
	public String getCallToPhoneNumber() {
		return "1380372000" + String.valueOf(new Random().nextInt(10));
	}
	
    //ģ��Ʒѷ��������ַ�������ʽ���ر���4λС���ļƷѽ��
	public String accountFee(long timeStart,long timeEnd) {
		//ÿ�����շ�*Ԫ
		double feePerMinute=0.3;
		//ͨ���������������������
		int minutes=Math.round((timeEnd-timeStart)/60000);
		double feeTotal=feePerMinute*minutes;
		return String.format("%.4f",feeTotal);
	}

	//��ӡͨ����¼
    void printDetails() {
    	
    	Iterator itRecords = this.communicationRecords.iterator();
    	while(itRecords.hasNext()) {
    		System.out.println("--------ͨ����¼�ָ���--------");
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
