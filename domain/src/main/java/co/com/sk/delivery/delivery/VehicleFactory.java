package co.com.sk.delivery.delivery;

import co.com.sk.delivery.delivery.values.Vehicle;

import java.util.HashSet;
import java.util.Set;

/**
 * Vehicle class - Factory
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
public class VehicleFactory {

    private final Set<Vehicle> vehicles;

    private VehicleFactory() {
        this.vehicles = new HashSet<>();
    }

    public VehicleFactory addVehicles(Vehicle vehicle) {
        vehicles.add(vehicle);
        return this;
    }

    /**
     * Builder's factory
     *
     * @return Factory
     */
    public static VehicleFactory builder() {
        return new VehicleFactory();
    }

    /**
     * All vehicles
     *
     * @return Set<Vehicle>
     */
    public Set<Vehicle> vehicles() {
        return vehicles;
    }
}
