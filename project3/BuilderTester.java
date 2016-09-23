
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
import UXB.SisterPrinter;
import UXB.SisterPrinter.Builder;
import UXB.CannonPrinter;
import UXB.CannonPrinter.Builder;
import UXB.GoAmature;
import UXB.GoAmature.Builder;
import UXB.Hub;
import UXB.Hub.Builder;


public class BuilderTester {

	SisterPrinter.Builder sisterPrinterBuilder;
	CannonPrinter.Builder cannonPrinterBuilder;
	GoAmature.Builder goAmatureBuilder;
	Hub.Builder testBuilder;
	
	SisterPrinter.Builder sisterPrinterBuilderFail;
	CannonPrinter.Builder cannonPrinterBuilderFail;
	GoAmature.Builder goAmatureBuilderFail;
	Hub.Builder failTestBuilder;
	
	@Before
	public void builderSetUP() throws Exception{
		sisterPrinterBuilder=new SisterPrinter.Builder(1);
		cannonPrinterBuilder=new CannonPrinter.Builder(1);
		goAmatureBuilder=new GoAmature.Builder(1);
		testBuilder=new Hub.Builder(1);
		
		sisterPrinterBuilderFail=new SisterPrinter.Builder(null);
		cannonPrinterBuilderFail=new CannonPrinter.Builder(null);
		goAmatureBuilderFail=new GoAmature.Builder(null);
		failTestBuilder=new Hub.Builder(null);
	}
	
	@Test
	public void validSisterPrinterTester(){
		sisterPrinterBuilder.build();
	}
	
	@Test (expected=IllegalStateException.class)
	public void invalidSisterPrinterTester(){
		sisterPrinterBuilderFail.build();
	}
	
	@Test
	public void validCannonPrinterTester(){
		cannonPrinterBuilder.build();
	}
	
	@Test (expected=IllegalStateException.class)
	public void invalidCannonPrinterTester(){
		cannonPrinterBuilderFail.build();
	}
	
	@Test
	public void validGoAmatureTester(){
		goAmatureBuilder.build();
	}
	
	@Test (expected=IllegalStateException.class)
	public void invalidGoAmatureTester(){
		goAmatureBuilderFail.build();
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
