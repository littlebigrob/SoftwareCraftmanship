package UXB;

import java.math.BigInteger;
import java.util.Optional;

public class GoAmature extends AbstractVideo<GoAmature.Builder> {


    public GoAmature(Builder builder) {
        super(builder);
    }

	public void recv(StringMessage message, Connector connector) {
		validateRecv(message,connector);
        System.out.println("GoAmature does not understand Strings");
    }

    public void recv(BinaryMessage message, Connector connector) {
		validateRecv(message,connector);
        System.out.println("GoAmature is not yet active"+ message.toString());
    }
	
	protected void validateRecv(StringMessage message,Connector connector){
		if (message==null||connector==null){
			throw new NullPointerException("message or connector is null");
		}
		if(connector.getDevice()!=this) {
                throw new IllegalStateException("connector doesn't belong to this device");
            }
			
	}
	
	public static class Builder extends AbstractVideo.Builder<Builder> {

        public Builder(Integer version) {
            super(version);
        }

        public GoAmature build() {
            super.validate();
            return new GoAmature(this);
        }

        protected Builder getThis() {
            return this;
        }
    }
	