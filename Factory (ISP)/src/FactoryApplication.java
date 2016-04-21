public class FactoryApplication {

    public static void main(String[] args) {
        new HumanManager().manage(new HumanWorker());
        new HumanRobotOperator().run(new RobotWorker());
    }
}
