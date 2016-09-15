package UXB;

import java.math.BigInteger;
import java.util.*;

public interface Device {
	Optional<Integer> getProductCode();

	Optional<BigInteger> getSerialNumber();
	
	Integer getVersion();
	
	DeviceClass getDeviceClass();
	
	Integer getConnectorCount();
	
	List <Connector.Type>  getConnectors();
	
	Connector getConnector(int index);
}
