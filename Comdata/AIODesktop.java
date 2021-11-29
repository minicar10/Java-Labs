package Comdata;

public class AIODesktop extends Computer implements TouchScreenDevice {
    double screenSize;
    boolean hasTouchScreen;

    public AIODesktop(String cpuType, int speedMHZ, int ramCapacityGb, SecondaryStorageDevice storageDevice,
            double screenSize, boolean hasTouchScreen) {
        super(cpuType, speedMHZ, ramCapacityGb, new SecondaryStorageDevice[] { storageDevice });

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
        return super.getDescription()
                + String.format(", SCREEN SIZE: %f, HAS TOUCH SCREEN: %s", screenSize, hasTouchScreen ? "Yes" : "No");
    }
}
