package Comdata;

public class RegularDesktop extends Computer {
    enum formFactors {
        ATX, MICRO_ATX, MINI_ITX
    }

    formFactors formFactor;

    public RegularDesktop(String cpuType, int speedMHZ, int ramCapacityGb,
            SecondaryStorageDevice[] secondaryStorageDevices, formFactors formFactor) {
        super(cpuType, speedMHZ, ramCapacityGb, secondaryStorageDevices);
        this.formFactor = formFactor;
    }

    public String getDescription() {
        String formFactorString = "";

        switch (this.formFactor) {
            case ATX -> formFactorString = "ATX";
            case MICRO_ATX -> formFactorString = "MICRO-ATX";
            case MINI_ITX -> formFactorString = "MINI-ITX";
        }

        return super.getDescription() + ", and it has a " + formFactorString + " form factor";
    }
}
