package UXB;

/*
 * @ author Robert Milne code last updated 9.15.16
 * the message being sent across the connector
 */

import java.math.BigInteger;


public class BinaryMessage implements Message {

	private final BigInteger message;
	
	//the value is the bit value sent in the message
	public BigInteger getValue() {
	return message;
}



	public BinaryMessage(BigInteger value){
		
		if (value==null){
			message=BigInteger.ZERO;
		}
		else{
			message=value;
		}
	}
	
	@Override
	
	public boolean equals(Object anObject){
		if (anObject==null||anObject.getClass()!=BinaryMessage.class){
			return false;
		}
		
		// the else is that there is something in the object and thus continues to be checked
		
		if (){
			return message.equals(((BinaryMessage)anObject).getValue());
		}
	}
}
