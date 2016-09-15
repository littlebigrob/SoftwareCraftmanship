package UXB;

import java.util.*;

public class Connector {
	
	
	public enum Type{
	}
	

private final int index;
private final Type type;
private final Device device;
Optional<Connector> peer;


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


public Connector (Device device, int index, Type type){
	this.device=device;
	this.index=index;
	this.type=type;
	this.peer=null;
}
}
