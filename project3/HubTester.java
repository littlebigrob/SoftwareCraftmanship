
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import UXB.Connector;
import UXB.Hub;
import UXB.Hub.Builder;


public class HubTester {

	Hub.Builder testBuilder;
	Hub.Builder failTestBuilder;
	@Before
	public void builderSetUP() throws Exception{
		testBuilder=new Hub.Builder(1);
		failTestBuilder=new Hub.Builder(null);
	}
	
	@Test
	public void validHubTester(){
		testBuilder.build();
	}
	
	@Test (expected=IllegalStateException.class)
	public void invalidHubTester(){
		failTestBuilder.build();
	}
}
