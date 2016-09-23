package UXB;

public abstract class AbstractVideo<T extends AbstractVideo.Builder<T>> extends AbstractPeripheral<T> {

    protected AbstractVideo(Builder<T> builder) {
        super(builder);
    }

    @Override
    //returns Video
    public DeviceClass getDeviceClass() {
        return DeviceClass.VIDEO;
    }

    public static abstract class Builder<T> extends AbstractPeripheral.Builder<T> {
		
        public Builder(Integer version) {
            super(version);
        }
    }
}