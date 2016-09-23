package UXB;

/*
 * @ author Robert Milne code last updated 9.15.16
 * the method stubs are the different values and calls that each device must have
 */

import java.math.BigInteger;
import java.util.*;

public interface Device {
	
	Optional<Integer> getProductCode();
	/*returns the product code of this device. If the product code is unknown, return an empty optional.*/
	
	Optional<BigInteger> getSerialNumber();
	/*returns the serial number of this device. If the serial number is unknown, return an empty optional*/
	
	Integer getVersion();
	/*returns the UXB version that this device supports.*/
	
	DeviceClass getDeviceClass();
	/*returns the class of this UXB device.*/
	
	Integer getConnectorCount();
	/*returns the number of connectors that this device has.*/
	
	List <Connector>  getConnectors();
	/*returns the type of each connector in this device.*/
	
	Connector getConnector(int index);
	/*returns the connector of this device at the given index.*/

    void recv(BinaryMessage message, Connector connector);
	/*recived a BinaryMessage.*/

    
    void recv(StringMessage message, Connector connector);
	/*recived a StringMessage.*/
}
