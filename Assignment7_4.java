//Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle. Create factories for each
// type of Cycle, and code that uses these factories.
interface Cycle {
    void ride();
}
class Unicycle implements Cycle {
    public void ride() {
        System.out.println("Riding a Unicycle");
    }
}
class Bicycle implements Cycle {
    public void ride() {
        System.out.println("Riding a Bicycle");
    }
}
class Tricycle implements Cycle {
    public void ride() {
        System.out.println("Riding a Tricycle");
    }
}
interface CycleFactory {
    Cycle getCycle();
}
class UnicycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Unicycle();
    }
}
class BicycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Bicycle();
    }
}
class TricycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Tricycle();
    }
}
class Assignment7_4 {
    static void rideCycle(CycleFactory factory) {
        Cycle cycle = factory.getCycle();
        cycle.ride();
    }
    public static void main(String[] args) {
        rideCycle(new UnicycleFactory());
        rideCycle(new BicycleFactory());
        rideCycle(new TricycleFactory());
    }
}
