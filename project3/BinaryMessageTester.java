

import static org.junit.Assert.*;

import java.math.BigInteger;

import junit.framework.Assert;

import org.junit.Test;

import UXB.BinaryMessage;


public class BinaryMessageTester {
	
	
	BinaryMessage nullMessage=new BinaryMessage (null);
	BinaryMessage oneMessage=new BinaryMessage (BigInteger.valueOf(1));
	
	@Test
	public void binaryMessageValueTester() throws Exception{
		Assert.assertTrue(BigInteger.ZERO.equals(nullMessage.getValue()));
	}
	
	@Test
	public void binaryMessageEqualValid() throws Exception{
		Assert.assertTrue(oneMessage.equals(oneMessage));
	}

	@Test 
	public void binaryMessageEqualInvalid() throws Exception{
		Assert.assertFalse(oneMessage.equals(nullMessage));
		
	}
}
