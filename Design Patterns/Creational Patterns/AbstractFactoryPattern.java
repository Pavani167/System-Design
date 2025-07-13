// Product Interface
interface Vehicle {
    void start();

    void stop();
}

// Concrete Products for Honda
class HondaCar implements Vehicle {
    public void start() {
        System.out.println("Honda Car starting");
    }

    public void stop() {
        System.out.println("Honda Car stopping");
    }
}

class HondaBike implements Vehicle {
    public void start() {
        System.out.println("Honda Bike starting");
    }

    public void stop() {
        System.out.println("Honda Bike stopping");
    }
}

class HondaScooter implements Vehicle {
    public void start() {
        System.out.println("Honda Scooter starting");
    }

    public void stop() {
        System.out.println("Honda Scooter stopping");
    }
}

// Concrete Products for BMW
class BMWCar implements Vehicle {
    public void start() {
        System.out.println("BMW Car starting");
    }

    public void stop() {
        System.out.println("BMW Car stopping");
    }
}

class BMWBike implements Vehicle {
    public void start() {
        System.out.println("BMW Bike starting");
    }

    public void stop() {
        System.out.println("BMW Bike stopping");
    }
}

class BMWScooter implements Vehicle {
    public void start() {
        System.out.println("BMW Scooter starting");
    }

    public void stop() {
        System.out.println("BMW Scooter stopping");
    }
}

// Abstract Factory Interface
interface VehicleFactory {
    Vehicle createCar();

    Vehicle createBike();

    Vehicle createScooter();
}

// Concrete Factory for Honda
class HondaFactory implements VehicleFactory {
    public Vehicle createCar() {
        return new HondaCar();
    }

    public Vehicle createBike() {
        return new HondaBike();
    }

    public Vehicle createScooter() {
        return new HondaScooter();
    }
}

// Concrete Factory for BMW
class BMWFactory implements VehicleFactory {
    public Vehicle createCar() {
        return new BMWCar();
    }

    public Vehicle createBike() {
        return new BMWBike();
    }

    public Vehicle createScooter() {
        return new BMWScooter();
    }
}

// Client Code
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        System.out.println("Using Honda Factory:");
        VehicleFactory hondaFactory = new HondaFactory();
        Vehicle hondaCar = hondaFactory.createCar();
        Vehicle hondaBike = hondaFactory.createBike();
        Vehicle hondaScooter = hondaFactory.createScooter();

        hondaCar.start();
        hondaCar.stop();
        hondaBike.start();
        hondaBike.stop();
        hondaScooter.start();
        hondaScooter.stop();

        System.out.println("\nUsing BMW Factory:");
        VehicleFactory bmwFactory = new BMWFactory();
        Vehicle bmwCar = bmwFactory.createCar();
        Vehicle bmwBike = bmwFactory.createBike();
        Vehicle bmwScooter = bmwFactory.createScooter();

        bmwCar.start();
        bmwCar.stop();
        bmwBike.start();
        bmwBike.stop();
        bmwScooter.start();
        bmwScooter.stop();
    }
}
