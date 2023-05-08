//Create three new types of exceptions. Write a class with a method that throws all three. In main( ),
// call the method but only use a single catch clause that will catch all three types of exceptions.
// Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown.
public class Assign8 {
    public static void main(String[] args) {
        ExceptionThrower thrower = new ExceptionThrower();
        try {
            thrower.throwExceptions();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
class CustomException1 extends Exception {
    public CustomException1(String message) {

        super(message);
    }
}

class CustomException2 extends Exception {
    public CustomException2(String message) {

        super(message);
    }
}

class CustomException3 extends Exception {
    public CustomException3(String message) {
        super(message);
    }
}
class ExceptionThrower {
    public void throwExceptions() throws CustomException1, CustomException2, CustomException3 {
        // Throw three different types of exceptions
        try {
            throw new CustomException1("Custom Exception 1");
        } catch (CustomException1 ex) {
            System.out.println("Caught Exception: " + ex.getMessage());
        }

        try {
            throw new CustomException2("Custom Exception 2");
        } catch (CustomException2 ex) {
            System.out.println("Caught Exception: " + ex.getMessage());
        }

        try {
            throw new CustomException3("Custom Exception 3");
        } catch (CustomException3 ex) {
            System.out.println("Caught Exception: " + ex.getMessage());
        }
    }
}