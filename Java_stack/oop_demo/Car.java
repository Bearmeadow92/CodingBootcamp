public class Car{
    // MEMBER VARIABLES or ATTRIBUTES
    String suspension;
    int cylinder;
    boolean automatic;
    String color;
    //METHODS

    //CONSTRUCTOR METHODS
    public Car(String suspension, int cylinder, boolean automatic, String color){
        System.out.println("YOUR CAR IS BEING MADE");
        this.suspension = suspension;
        this.cylinder = cylinder;
        this.automatic = automatic;
        this.color = color;
    }

}