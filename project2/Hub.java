package UXB;

import java.math.BigInteger;
import java.util.*;

import UXB.AbstractDevice.Builder;


public class Hub extends AbstractDevice<Hub.Builder> {
	private Optional<Integer> productCode;
	private Optional<BigInteger> serialNumber;
	private Integer version;
	private List<Connector> connectorList;
	private List<Connector.Type> connectorTypeLists;
	
	public Hub(Builder builder){
		super(builder);
		
		
	}

    
	public static class Builder extends AbstractDevice.Builder<Builder> {
    	private Optional<Integer> productCode;
    	private Optional<BigInteger> serialNumber;
    	private Integer version;
    	private List<Connector> connectorList;
    	private List<Connector.Type> connectorTypeLists;
    	static Builder builder;
    	
    	
    	
    	public Builder (Integer version){
    	    
    		this.version = version;
            productCode = null;
            serialNumber = null;
            connectorList = new ArrayList<>();
            connectorTypeLists = new ArrayList<>();    }
    	
    	public Hub build(){
			return null;
    		
    	}
    	
    	
		@Override
		protected Builder getThis() {
			// TODO Auto-generated method stub
			return null;
		}
    	
    }
}