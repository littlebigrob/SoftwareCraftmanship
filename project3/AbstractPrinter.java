package UXB;

public abstract class AbstractPrinter<T extends AbstractPrinter.Builder<T>> extends AbstractPeripheral<T> {

    protected AbstractPrinter(Builder<T> builder) {
        super(builder);
    }

    @Override
    //returns Printer
    public DeviceClass getDeviceClass() {
        return DeviceClass.PRINTER;
    }

    public static abstract class Builder<T> extends AbstractPeripheral.Builder<T> {
		
        public Builder(Integer version) {
            super(version);
        }
    }
}