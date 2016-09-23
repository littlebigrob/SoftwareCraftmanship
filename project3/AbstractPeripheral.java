package UXB;

import java.util.ListIterator;


public abstract class AbstractPeripheral<T extends AbstractPeripheral.Builder<T>> extends AbstractDevice<T> {

    protected AbstractPeripheral(Builder<T> builder) {
        super(builder);
    }



    public static abstract class Builder<T> extends AbstractDevice.Builder<T> {

        public Builder(Integer version) {
            super(version);
        }

        @Override 
    	protected void validate() {

            super.validate();

            if(false==peripheralConnectorx()) {
                throw new IllegalStateException("The hub has no connectors to computers or peripherals");
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