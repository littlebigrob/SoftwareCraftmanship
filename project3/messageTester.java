
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import UXB.Connector;
import UXB.SisterPrinter;
import UXB.SisterPrinter.Builder;
import UXB.CannonPrinter;
import UXB.CannonPrinter.Builder;
import UXB.GoAmature;
import UXB.GoAmature.Builder;
import UXB.Hub;
import UXB.Hub.Builder;
import UXB.StringMessage;
import UXB.BinaryMessage;
import UXB.Message;


import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;


public class MessageTester{
	List<Device> deviceList;
	List<Message> messageList;
	
	SisterPrinter.Builder sisterPrinterBuilder=new SisterPrinter.Builder(1);
	CannonPrinter.Builder cannonPrinterBuilder=new CannonPrinter.Builder(1);
	GoAmature.Builder goAmatureBuilder=new GoAmature.Builder(1);
	Hub.Builder hubBuilder=new Hub.Builder(1);
	
	StringMessage stringMessage=new StringMessage("Hello World");
	BinaryMessage binaryMessage=new BinaryMessage(BigInteger.valueOf(796));
	
	@Before
	public void listSetUp(){
		deviceList=new ArrayList<Device>();
		messageList=new ArrayList<Message>();
	
		deviceList.add(sisterPrinterBuilder.build());
		deviceList.add(cannonPrinterBuilder.build());
		deviceList.add(goAmatureBuilder.build());
		deviceList.add(hubBuilder.build());
		
		messageList.add(stringMessage);
		messageList.add(binaryMessage);
		messageList.add(null);
	}
	//checks that the 8 messages goes through	
	@Test 
	public void messageTester(){
		for (int i=0, deviceList.size(), i++){
			Connector connector=new Connector(deviceList[i],0,PERIPHERAL);
			for (int index=0, messageList.size(), i++){
				deviceList[i].recv(messageList[index],connector);
			}
		}
	}
	
	//checks that the connection is correct
	
	@Test (expected=IllegalStateException.class)
	public void messageExeptionTester(){
		Connector connector=new Connector(deviceList[1],0,PERIPHERAL);
		deviceList[0].recv(messageList[0],connector);
	}
	
	@Test (expected=IllegalStateException.class)
	public void messageExeptionTester(){
		Connector connector=new Connector(deviceList[0],0,PERIPHERAL);
		deviceList[1].recv(messageList[0],connector);
	}
	
	@Test (expected=IllegalStateException.class)
	public void messageExeptionTester(){
		Connector connector=new Connector(deviceList[1],0,PERIPHERAL);
		deviceList[2].recv(messageList[0],connector);
	}
	
	@Test (expected=IllegalStateException.class)
	public void messageExeptionTester(){
		Connector connector=new Connector(deviceList[1],0,PERIPHERAL);
		deviceList[3].recv(messageList[0],connector);
	}
	
	//checks that a message is present
	@Test (expected=NullPointerException.class)
	public void messageExeptionTester(){
		Connector connector=new Connector(deviceList[0],0,PERIPHERAL);
		deviceList[0].recv(messageList[3],connector);
	}
	
	@Test (expected=NullPointerException.class)
	public void messageExeptionTester(){
		Connector connector=new Connector(deviceList[1],0,PERIPHERAL);
		deviceList[1].recv(messageList[3],connector);
	}
	
	@Test (expected=NullPointerException.class)
	public void messageExeptionTester(){
		Connector connector=new Connector(deviceList[2],0,PERIPHERAL);
		deviceList[2].recv(messageList[3],connector);
	}
	
	@Test (expected=NullPointerException.class)
	public void messageExeptionTester(){
		Connector connector=new Connector(deviceList[3],0,PERIPHERAL);
		deviceList[3].recv(messageList[3],connector);
	}
}