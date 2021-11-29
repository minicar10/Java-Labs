package Comdata;

import Comdata.SecondaryStorageDevice.secondaryStorageDeviceTypes;

public class Main {
    public static void main(String[] args) {
        RegularDesktop regularDesktop = new RegularDesktop("Intel", 2400, 64,
                new SecondaryStorageDevice[] { new SecondaryStorageDevice(secondaryStorageDeviceTypes.HDD, 10000),
                        new SecondaryStorageDevice(secondaryStorageDeviceTypes.NVME_SSD, 1000),
                        new SecondaryStorageDevice(secondaryStorageDeviceTypes.SSD, 4000) },
                RegularDesktop.formFactors.ATX);

        AIODesktop aioDesktop = new AIODesktop("Intel", 2400, 8,
                new SecondaryStorageDevice(secondaryStorageDeviceTypes.HDD, 1000), 24, true);
        Laptop laptop = new Laptop("AMD Ryzen", 1800, 12,
                new SecondaryStorageDevice(secondaryStorageDeviceTypes.SSD, 1000), "WIRELESS 802.11AC", 18, true);

        System.out.println(regularDesktop.getDescription());
        System.out.println(aioDesktop.getDescription());
        System.out.println(laptop.getDescription());
    }
}
