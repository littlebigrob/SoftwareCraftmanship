package UXB;
import java.math.BigInteger;


public class BinaryMessage implements Message {

	private final BigInteger message;
	
	
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
		if (anObject==null){
			return false;
		}
		
		// the else is that there is something in the object and thus continues to be checked
		
		if (anObject.getClass()==BinaryMessage.class){
			return message.equals(((BinaryMessage)anObject).getValue());
		}
		
		else{
			return false;
		}
	}
}
