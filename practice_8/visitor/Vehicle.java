package practice_8.visitor;

public interface Vehicle {
    int accept(VehicleInspector vehicleInspector);
}
