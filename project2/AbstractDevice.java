package UXB;

import java.math.BigInteger;
import java.util.*;
//import java.lang.*;

import UXB.Connector.Type;

public class AbstractDevice<T extends AbstractDevice.Builder<T>> implements Device {

private final Optional<Integer> productCode;
private final Optional<BigInteger> serialNumber;
private final Integer version;
private final List<Connector> connectorList;
private final List<Connector.Type> connectorTypeLists;


protected AbstractDevice(Builder<T> builder) {
    this.productCode = builder.productCode;
    this.serialNumber = builder.serialNumber;
    this.version = builder.version;
    this.connectorList=builder.connectorList;
    this.connectorTypeLists = builder.connectorTypeLists;
}


@Override
public Optional<Integer> getProductCode() {
	if(productCode==null){
		return Optional.empty();
	}
	return productCode;
}

@Override
public Optional<BigInteger> getSerialNumber() {
	if(serialNumber==null){
		return Optional.empty();
	}
	return serialNumber;
}

@Override
public Integer getVersion() {
	return version;
}

@Override
public List<Type> getConnectors() {
	return connectorTypeLists;
}

@Override
public Connector getConnector(int index) {
	
	Connector currentConnector;
	int currentConnectorsIndex;
	Iterator <Connector> iterator=(Iterator<Connector>) connectorList.iterator();
	
	while(iterator.hasNext()){
		currentConnector=iterator.next();
		currentConnectorsIndex=currentConnector.getIndex();
		
		if (currentConnectorsIndex==index){
			return currentConnector;
		}//the else case is that the connector is not the correct index and thus
		//the program continues to run
			
	}
	return null;
	
}
	
public static abstract class Builder<T> {
	private Optional<Integer> productCode;
	private Optional<BigInteger> serialNumber;
	private Integer version;
	private List<Connector> connectorList;
	private List<Connector.Type> connectorTypeLists;
	
	public Builder (Integer version){
		this.version = version;
        productCode = null;
        serialNumber = null;
        connectorList = new ArrayList<>();
        connectorTypeLists = new ArrayList<>();    }
	
	
	public T productCode (Optional<Integer> productCode){
		if (productCode==null){
			this.productCode=Optional.empty();
		} 	
		this.productCode=productCode;
		return getThis();
	}
	
	
	
	public T serialNumber (Optional<BigInteger> serialNumber){
		if (serialNumber==null){
			this.serialNumber=Optional.empty();
		} 	
		this.serialNumber=serialNumber;
		return getThis();
	}
	
	public T connectors(List<Connector.Type> connectors){
		this.connectorTypeLists=connectors;
		return getThis();
	}
	
	protected abstract T getThis();
	
	
	protected List<Connector.Type> getConnectors(){
		return connectorTypeLists;
	}
	
	protected void validate (){
		if (version==null){
			//throw NullPointerExeption
		}
	}
	
	
}

@Override
public DeviceClass getDeviceClass() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Integer getConnectorCount() {
	// TODO Auto-generated method stub
	return null;
}
}
