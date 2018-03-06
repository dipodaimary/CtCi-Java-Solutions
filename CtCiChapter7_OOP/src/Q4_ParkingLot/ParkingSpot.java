package Q4_ParkingLot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level level, int r, int n, VehicleSize sz) {
        this.level = level;
        row = r;
        spotNumber = n;
        spotSize = sz;
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    public boolean isAvaiable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle v) {
        return isAvaiable() && v.canFitInSpot(this);
    }

    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }

    public void print() {
        if (vehicle == null) {
            if (spotSize == VehicleSize.Compact) {
                System.out.print("c");
            } else if (spotSize == VehicleSize.Large) {
                System.out.print("l");
            } else if (spotSize == VehicleSize.Motorcycle) {
                System.out.print("m");
            }
        } else {
            vehicle.print();
        }
    }

    public int getRow() {
        return row;
    }
}
