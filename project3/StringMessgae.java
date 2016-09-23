package UXB;

public final class StringMessage implements Message {

    private final String stringMessage;

    public StringMessage(String string) {
        if(string=null){
			stringMessage="";
		}
		else{
			stringMessage=string;
		}
    }

	public String getString(){
		return stringMessage;
	}	
	
    
    public void reach(Device device, Connector connector) {
        device.recv(this, connector);
    }

   @Override
	
	public boolean equals(Object anObject){
		if (anObject==null||anObject.getClass()!=StringMessage.class){
			return false;
		}
		
		// the else is that there is something in the object and thus continues to be checked
		
		if (){
			return stringMessage.equals(((StringMessage)anObject).getValue());
		}
	}

    public int length() {
        return stringMessage.length();
    }

    public char charAt(int i) {
        return stringMessage.charAt(i);
    }

    public boolean contains(CharSequence charSequence) {
        return stringMessage.contains(charSequence);
    }

    public boolean endsWith(String suffix) {
        return stringMessage.endsWith(suffix);
    }

    public boolean startsWith(String prefix) {
        return stringMessage.startsWith(prefix);
    }

    public int indexOf(int ch) {
        return stringMessage.indexOf(ch);
    }

    public int indexOf(int ch, int fromIndex) {
        return stringMessage.indexOf(ch, fromIndex);
    }

    public int indexOf(String str) {
        return stringMessage.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        return stringMessage.indexOf(str, fromIndex);
    }

    public int lastIndexOf(int ch) {
        return stringMessage.lastIndexOf(ch);
    }

    public int lastIndexOf(int ch, int fromIndex) {
        return stringMessage.lastIndexOf(ch, fromIndex);
    }

    public int lastIndexOf(String str) {
        return stringMessage.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return stringMessage.lastIndexOf(str, fromIndex);
    }

    public boolean isEmpty() {
        return stringMessage.isEmpty();
    }

    public int hashCode() {
        return stringMessage.hashCode();
    }
}