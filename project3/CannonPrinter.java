package UXB;

import java.math.BigInteger;
import java.util.Optional;

public class CannonPrinter extends AbstractPrinter<CannonPrinter.Builder> {


    public CannonPrinter(Builder builder) {
        super(builder);
    }

	public void recv(StringMessage message, Connector connector) {
		validateRecv(message,connector);
        System.out.println("Cannon printer has printed the string: "+ message.getMessage()+ "\nSerial number: " + getSerialNumber().toString());
    }

    public void recv(BinaryMessage message, Connector connector) {
		validateRecv(message,connector);
        BigInteger returnedMessage = calculateReturnedMessage(message.getMessage(), getProductCode());
        System.out.println("Cannon printer has printed the binary message: "+ returnedMessage.toString());
    }

    private BigInteger calculateReturnedMessage(BigInteger message, Optional<Integer> productCode) {
        if(productCode.isPresent()){
			return message+new BigInteger(productCode.get().toString());
		}
		else{
			return message;
		}
    }
	
	protected void validateRecv(StringMessage message,Connector connector){
		if (message==null||connector==null){
			throw new NullPointerException("message or connector is null");
		}
		if(connector.getDevice()!=this) {
                throw new IllegalStateException("connector doesn't belong to this device");
            }
	}
	
	public static class Builder extends AbstractPrinter.Builder<Builder> {

        public Builder(Integer version) {
            super(version);
        }

        public CannonPrinter build() {
            super.validate();
            return new CannonPrinter(this);
        }

        protected Builder getThis() {
            return this;
        }
    }
}
	