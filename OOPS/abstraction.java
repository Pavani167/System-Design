// Abstraction is the process of hiding all implementation details and showing
// only the required objects
// It can be done using two methods abstraction class and abstraction interface

/*Using abstract class */

//In real life we can also use this Payment Methods like credit card and  phone pe,debit card
abstract class Shape {
    String colour;

    abstract void area();

    public Shape(String colour) {
        this.colour = colour;
        System.out.println(colour + "triangle color");

    }

    // this is a concrete method-meaning which has complete implementation of
    // everything
    public String getColor() {
        return colour;
    }

}

public class tri extends Shape {
    double radius;
    double area;

    public tri(String colour, double radius) {
        super(colour);
        this.radius = radius;
        System.out.println("Constructor called");
    }

    @Override
    void area() {
        System.out.println(0.5 * radius);
        area = 0.5 * radius;
    }

    @Override
    public String toString() {
        return "Color: " + colour + ", Area: " + area;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape tri = new tri("blue", 0.50);
        tri.area();
        System.out.println(tri);
    }
}

// We can use interface as well
public interface Animal {

    void eats();
}

public class dog implements Animal {
    // Always use public when implementing interface methods, or you'll get a
    // compile-time error.
    public void eats() {
        System.out.print("Milk and Fish");
    }
}
