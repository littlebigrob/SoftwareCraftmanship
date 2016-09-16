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
		 this.productCode = builder.productCode;
		 this.serialNumber = builder.serialNumber;
		 this.version = builder.version;
		 this.connectorList=builder.connectorList;
		 this.connectorTypeLists = builder.connectorTypeLists;
		
	}

	
	@Overides
	public DeviceClass getDeviceClass(){
		return DeviceClass.HUB;
	}
    
	public static class Builder extends AbstractDevice.Builder<Builder> {
    	private Optional<Integer> productCode;
    	private Optional<BigInteger> serialNumber;
    	private Integer version;
    	private List<Connector> connectorList;
    	private List<Connector.Type> connectorTypeLists;
    	static Integer builder;
    	
    	
    	
    	public Builder (Integer version){
    	    super(version);
    		this.version = version;
            this.productCode = null;
            this.serialNumber = null;
            this.connectorList = new ArrayList<>();
            this.connectorTypeLists = new ArrayList<>();    }
    	
    	public Hub build(){
			if (version==null||connectorList==null){
				//IllegalStateExeption()
			}
    		Hub newHub=new Hub(this);
    		return newHub;
    	}
    	
    	
		@Override
		protected Builder getThis() {
			// TODO Auto-generated method stub
			return null;
		}
    	
		protected void validate (){
			if (version==null){
				//throw NullPointerExeption
			}
		}
    }
}