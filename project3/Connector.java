package UXB;

/*
 * @ author Robert Milne code last updated 9.15.16
 * this code simulates a connection between two different devices in a UXB
 */

import java.util.*;

public class Connector {
	
	
	public enum Type{
		COMPUTER,
		PERIPHERAL
	}
	

private final int index; //the port that the connection runs through
private final Type type; //the type of connection
private final Device device;//the device that the connection comes from
Optional<Connector> peer; //the device that the connection goes to


public int getIndex() {
	return index;
}



public Type getType() {
	return type;
}



public Optional<Connector> getPeer() {
	return peer;
}


public Device getDevice() {
	return device;
}

 public void recv(Message message) {
        if(peer.isPresent()) {
            message.reach(device, peer.get());
        }
    }

public Connector (Device device, int index, Type type){
	this.device=device;
	this.index=index;
	this.type=type;
	this.peer=Optional.empty(); //to set up a connector you do not need it to connect to anything
}

}