package Comdata;

abstract class Computer extends Machine {
    String cpuType;
    int speedMHZ;
    int ramCapacityGb;
    SecondaryStorageDevice[] secondaryStorageDevices;

    Computer(String cpuType, int speedMHZ, int ramCapacityGb, SecondaryStorageDevice[] secondaryStorageDevices) {
        this.cpuType = cpuType;
        this.speedMHZ = speedMHZ;
        this.ramCapacityGb = ramCapacityGb;
        this.secondaryStorageDevices = secondaryStorageDevices;
    }

    public String getDescription() {
        return String.format(
                "COMPUTER INFORMATION: CPU Type: %s, CPU Speed MHZ: %d, RAM Capacity Gb: %d and its storage devices are as follows: ",
                cpuType, speedMHZ, ramCapacityGb) + secondaryStorageDevices;
    }
}

class SecondaryStorageDevice {
    enum secondaryStorageDeviceTypes {
        SSD, HDD, NVME_SSD
    }

    secondaryStorageDeviceTypes type;
    int capacity;

    public SecondaryStorageDevice(secondaryStorageDeviceTypes type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }
}

interface TouchScreenDevice {
    double screenSize();

    boolean hasTouchScreen();
}