public class HumanRobotOperator implements RobotOperator {

    @Override
    public void run(RobotWorker robot) {
        robot.work();
        robot.stopWorking();
        //robot.eat(); // The compiler doesn't mind but it doesn't make sense.
    }
}
