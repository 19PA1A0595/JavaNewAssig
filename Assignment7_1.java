//1. Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc.
// In the base class, provide methods that are common to all Rodents, and override these in the derived classes to
// perform different behaviors depending on the specific type of Rodent. Create an array of Rodent, fill it with different
// specific types of Rodents, and call your base-class methods to see what happens. Make the methods of Rodent abstract
// whenever possible and all classes should have default constructors that print a message about that class.
abstract class Animal {
    abstract void eat();
    abstract void sleep();
}
abstract class Rodent extends Animal {
    abstract void gnaw();
}
class Mouse extends Rodent {
    Mouse() {
        System.out.println("Mouse created");
    }
    void eat() {
        System.out.println("Mouse is eating");
    }
    void sleep() {
        System.out.println("Mouse is sleeping");
    }
    void gnaw() {
        System.out.println("Mouse is gnawing");
    }
}

class Gerbil extends Rodent {
    Gerbil() {
        System.out.println("Gerbil created");
    }
    void eat() {
        System.out.println("Gerbil is eating");
    }
    void sleep() {
        System.out.println("Gerbil is sleeping");
    }
    void gnaw() {
        System.out.println("Gerbil is gnawing");
    }
}
class Hamster extends Rodent {
    Hamster() {
        System.out.println("Hamster created");
    }
    void eat() {
        System.out.println("Hamster is eating");
    }
    void sleep() {
        System.out.println("Hamster is sleeping");
    }
    void gnaw() {
        System.out.println("Hamster is gnawing");
    }
}

public class Assignment7_1 {
    public static void main(String[] args) {
        Rodent[] rodents = { new Mouse(), new Gerbil(), new Hamster() };
        for (Rodent rodent : rodents) {
            rodent.eat();
            rodent.sleep();
            rodent.gnaw();
            System.out.println();
        }
    }
}
