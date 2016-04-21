public class HumanManager implements Manager {

    @Override
    public void manage(HumanWorker human) {
        human.work();
        human.stopWorking();
        human.eat();
        human.work();
        human.stopWorking();
    }
}
