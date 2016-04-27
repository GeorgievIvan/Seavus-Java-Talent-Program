public class VolcanoApplication {

    public static void main(String[] args) {

        VolcanoRobot dante = new VolcanoRobot();
        dante.status = "exploring";
        dante.speed = 2;
        dante.temperature = 510;
        dante.showAttributes();

        System.out.println("Increasing speed to 3...");
        dante.speed = 3;
        dante.showAttributes();

        System.out.println("Changing temperature to 670...");
        dante.temperature = 670;
        dante.showAttributes();

        System.out.println("Checking the temperature...");
        dante.checkTemperature();
        dante.showAttributes();
        
        VolcanoRobot virgil = new VolcanoRobot();
        
        virgil.status = "overheated";
        virgil.speed = 0;
        virgil.temperature = 1500;
        
        System.out.println("Checking attributes of Virgil...");
        virgil.showAttributes();
    }
}
