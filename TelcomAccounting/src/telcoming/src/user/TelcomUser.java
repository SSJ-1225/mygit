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
	//ģ��ͨ����¼������
	public void generateCommunicateRecord() {
		//�������ͨ����¼����Ŀ
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//������ɵ�i��ͨ����¼
			//��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			//��ʼʱ�俪ʼ���ʮ������ĳ�����ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			//���к���
			this.callTo = getCallToPhoneNumber();
			//����ͨ����¼
			this.communicationRecords.append(this.phoneNumber + 
					"," + timeStart + 
					"," + timeEnd + 
					"," + this.callTo+
					";");
		}
	}
		//������ɱ��к��루����λ�����������
	public String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
	}
  //ģ��Ʒѷ��������ַ�������ʽ���ر�����λС���ļƷѽ��
	public String accountFee(long timeStart, long timeEnd) {
		//ÿ�����շ�*Ԫ
		double feePerMinute =S.feePerMinute();
		//ͨ���������������������
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%f", feeTotal);
	}		
	//��ӡͨ����¼
	public void printDetails() {
		//��ȡȫ��ͨ����¼
		String allRecords = this.communicationRecords.toString();
		//�ָ�ͨ����¼
		String [] recordArray = allRecords.split(";");
		//ѭ���ָ��¼�ڵ�ÿһ����
		for(int i = 0; i < recordArray.length; i++) {
            System.out.println("---------ͨ����¼�ָ���--------");
			String [] recordField = recordArray[i].split(",");
			System.out.println("����" + recordField[0]);
			System.out.println("����" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");		
			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			System.out.println("�Ʒѣ�"
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ "Ԫ��");
		}
	}       
}		