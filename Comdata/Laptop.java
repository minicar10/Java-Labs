package Comdata;

public class Laptop extends Computer implements TouchScreenDevice {
    String wifiCardType;

    double screenSize;
    boolean hasTouchScreen;

    public Laptop(String cpuType, int speedMHZ, int ramCapacityGb, SecondaryStorageDevice storageDevice,
            String wifiCardType, double screenSize, boolean hasTouchScreen) {
        super(cpuType, speedMHZ, ramCapacityGb, new SecondaryStorageDevice[] { storageDevice });

        this.wifiCardType = wifiCardType;
        this.screenSize = screenSize;
        this.hasTouchScreen = hasTouchScreen;
    }

    public double screenSize() {
        return this.screenSize;
    }

    public boolean hasTouchScreen() {
        return this.hasTouchScreen;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format(", WIFI CARD TYPE: %s, SCREEN SIZE: %f, HAS TOUCH SCREEN: %s",
                wifiCardType, screenSize, hasTouchScreen ? "Yes" : "No");
    }
}
