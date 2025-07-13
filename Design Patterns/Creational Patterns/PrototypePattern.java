/*
 * This pattern is used to cloning existing objects effectively.
 * 
 */

//Traditionally we do this

class Mobile {
    String ModelName;
    int ModelNumber;
    int ModelYear;
    int ModelSpace;
    int ModelRAM;

    Mobile() {
    }

    Mobile(String ModelName, int ModelNumber, int ModelYear, int ModelSpace, int ModelRAM) {
        this.ModelName = ModelName;
        this.ModelNumber = ModelNumber;
        this.ModelYear = ModelYear;
        this.ModelSpace = ModelSpace;
        this.ModelRAM = ModelRAM;
    }
}

// Now if we want to update create new object of another onject for same model
// but of different space and RAM we have to clone that and do that

// TRADITIONALLY WE HAVE to create new files for evrything

public class MobileFactory {

    public Mobile newSpace(int Space)

    {
        return new Mobile("realme", 11, 2021, Space, 4);
    }

    public Mobile newRAM(int RAM) {
        return new Mobile("realme", 11, 2021, 256, RAM);
    }

}

public class PrototypePattern {
    public static void main(String[] args) {
        Mobile st = new Mobile("Realme 11", 11, 2021, 128, 4);
        Mobile clone = new Mobile();
        st.ModelName = "Realme 11"; // Have to do thid manually

    }
}

// USING PROTOTYPE PATTERN

// Prototype Pattern Example: Cloning Mobile Objects

// Mobile class must implement java.lang.Cloneable
class Mobile implements Cloneable {
    String modelName;
    int modelNumber;
    int modelYear;
    int modelSpace;
    int modelRAM;

    Mobile(String modelName, int modelNumber, int modelYear, int modelSpace, int modelRAM) {
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.modelYear = modelYear;
        this.modelSpace = modelSpace;
        this.modelRAM = modelRAM;
    }

    @Override
    public Mobile clone() {
        try {
            return (Mobile) super.clone(); // shallow copy is okay for primitives
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return modelName + " " + modelNumber + " - " + modelYear + " - " + modelSpace + "GB / " + modelRAM + "GB RAM";
    }
}

// Factory that uses Prototype pattern
class MobileFactory {
    private Mobile prototypeMobile;

    public MobileFactory() {
        prototypeMobile = new Mobile("Realme", 11, 2021, 128, 4); // base prototype
    }

    public Mobile newSpace(int space) {
        Mobile clone = prototypeMobile.clone();
        clone.modelSpace = space;
        return clone;
    }

    public Mobile newRAM(int ram) {
        Mobile clone = prototypeMobile.clone();
        clone.modelRAM = ram;
        return clone;
    }

    public Mobile getPrototype() {
        return prototypeMobile;
    }
}

// Main class to demonstrate
public class PrototypePattern {
    public static void main(String[] args) {
        MobileFactory factory = new MobileFactory();

        Mobile base = factory.getPrototype();
        System.out.println("Base: " + base);

        Mobile upgradedSpace = factory.newSpace(256);
        System.out.println("Space Upgrade: " + upgradedSpace);

        Mobile upgradedRAM = factory.newRAM(8);
        System.out.println("RAM Upgrade: " + upgradedRAM);
    }
}
