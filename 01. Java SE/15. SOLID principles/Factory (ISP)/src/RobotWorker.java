public class RobotWorker implements Worker {

    @Override
    public void work() {
        System.out.println("RobotWorker.work");
    }

    @Override
    public void stopWorking() {
        System.out.println("RobotWorker.stopWorking");
    }
    
    /*
    @Override
    public void eat() {
        System.out.println("RobotWorker.eat - Degenerate implementation");
    }
    */
}
