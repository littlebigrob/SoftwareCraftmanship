package UXB;

/*
 * @ author Robert Milne code last updated 9.15.16
 * this code acts as a meeting point for all of the different connectors and devices to join
 * hubs must have at least one computer or peripheral to run
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;
import java.lang.IllegalStateException;


public class Hub extends AbstractDevice<Hub.Builder> {

	
	public Hub(Builder builder){
		super(builder);

	}

	
	@Override
	public DeviceClass getDeviceClass(){
		return DeviceClass.HUB;
	}
	
	public void recv(StringMessage message, Connector connector) {
		validateRecv(message,connector);
        System.out.println("Recv not yet supported");
    }

    public void recv(BinaryMessage message, Connector connector) {
		validateRecv(message,connector);
        System.out.println("Recv not yet supported");
    }
	
	protected void validateRecv(StringMessage message,Connector connector){
		if (message==null||connector==null){
			throw new NullPointerException("message or connector is null");
		}
		if(connector.getDevice()!=this) {
                throw new IllegalStateException("connector doesn't belong to this device");
            }
	}
    
	public static class Builder extends AbstractDevice.Builder<Builder> {
    	
    	
    	public Builder (Integer version){
    	    super(version);
    	    }
    	
    	public Hub build(){
    		validate();
    		return new Hub(this);
    		
    	}
    	
    	private boolean hasNull() {
            return getConnectors()==null||getVersion()==null;
        }
    	
		@Override
		protected Builder getThis() {
			// TODO Auto-generated method stub
			return this;
		}
    	
		@Override 
    	protected void validate() {

            super.validate();

            if(false==hasBothConnectors()) {
                throw new IllegalStateException("The hub has no connectors to computers or peripherals");
            }
		}
		
		
		private boolean hasBothConnectors(){
			return computerConnector&&peripheralConnector;
		}
		
		
		private boolean computerConnector(){
			List<Connector> connectorTypeLists=super.getConnectors();
			ListIterator<Connector> iterator=new ListIterator();
			while (iterator.hasNext(){
				if iterator.next().getType().equals(Connector.Type.COMPUTER){
					return true;
				}
			}
		}
		
		private boolean peripheralConnector(){
			List<Connector> connectorTypeLists=super.getConnectors();
			ListIterator<Connector> iterator=new ListIterator();
			while (iterator.hasNext(){
				if iterator.next().getType().equals(Connector.Type.PERIPHERAL){
					return true;
				}
			}
		}
		
		
	}
}
