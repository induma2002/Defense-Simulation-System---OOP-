public class Main {
    public static void main(String[] args) {
//        Tank tank = new Tank();
//        tank.buttonHideer(10);
//        new MainController();

        Obsever obsever = new Obsever();
        obsever.setComponents(new Tank());
        obsever.setComponents(new Hellicopter());
        new MainController(obsever);

    }
}