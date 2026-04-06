import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("======================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";
        boolean found = false;

        System.out.println("Searching for Bogie ID: " + searchKey);

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Result: Bogie " + searchKey + " found in the consist.");
        } else {
            System.out.println("Result: Bogie " + searchKey + " not found.");
        }

        System.out.println("\nUC18 search completed...");
    }

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                if (this.shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + this.cargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + this.shape + " bogie");
            }
        }
    }

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }
}