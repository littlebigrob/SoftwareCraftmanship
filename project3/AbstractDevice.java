package UXB;

/*
 * @ author Robert Milne code last updated 9.15.16
 * this code simulates a device that can work on the UXB
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.NullPointerException;
import UXB.Connector.Type;


public class AbstractDevice<T extends AbstractDevice.Builder<T>> implements Device {

private final Optional<Integer> productCode;
private final Optional<BigInteger> serialNumber;
private final Integer version;
private final List<Connector.Type> connectorTypeLists;
private final ArrayList<Connector> connectorList;


protected AbstractDevice(Builder<T> builder) {
    this.productCode = builder.productCode;
    this.serialNumber = builder.serialNumber;
    this.version = builder.version;
    this.connectorTypeLists = builder.connectorTypeLists;
	this.connectorList = new ArrayList<>();
        for(int i = 0; i < connectorTypeLists.size(); i++) {
            if(connectorTypeLists.get(i) == null){
				break;
			}
            connectorList.add( Connector(this, i,connectorTypeLists.get(i));
        }
}


@Override
public Optional<Integer> getProductCode() {
	return productCode;
}

@Override
public Optional<BigInteger> getSerialNumber() {
	return serialNumber;
}

@Override
public Integer getVersion() {
	return version;
}

@Override
public List<Connector> getConnectors() {
	return connectorList;
}

@Override
public Connector getConnector(int index) {
	return connectorList.get(index);
}
	
public static abstract class Builder<T> {
	private Optional<Integer> productCode;
	private Optional<BigInteger> serialNumber;
	private Integer version;
	private List<Connector.Type> connectorTypeLists;

	
	public Builder (Integer version){
		this.version = version;
        productCode = Optional.empty();
        serialNumber = Optional.empty();
        connectorTypeLists = new ArrayList<>();    }
	
	
	public T productCode (Optional<Integer> productCode){
		if (productCode.equals(null)||productCode.equals(Optional.empty())){
			this.productCode=Optional.empty();
		} 	
		this.productCode=productCode;
		return getThis();
	}
	
	
	public T serialNumber (Optional<BigInteger> serialNumber){
		if (serialNumber.equals(null)||serialNumber.equals(Optional.empty())){
			this.serialNumber=Optional.empty();
		} 	
		this.serialNumber=serialNumber;
		return getThis();
	}
	
	public T connectors(List<Connector.Type> connectors){
		if (connectors==null){
			this.connectorTypeLists=new ArrayList<Connector.Type>();
		}
		List<Connector.Type> connectorTypeLists=new ArrayList<Connector.Type>(connectors);
		return getThis();
	}
	
	protected abstract T getThis();
	
	
	protected List<Connector.Type> getConnectors(){
		List<Connector.Type> returnTypeList=new ArrayList<Connector.Type>(connectorTypeLists);
		return returnTypeList;
	}
	
	protected void validate (){
		if (version==null){
			throw new NullPointerException("The version number was not attached to this device");
		}
	}
	protected Integer getVersion(){
		return version;
	}
	
}

@Override
public DeviceClass getDeviceClass() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Integer getConnectorCount() {
	return connectorTypeLists.size();
}
}
