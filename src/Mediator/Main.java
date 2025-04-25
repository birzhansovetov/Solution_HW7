package Mediator;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        List<Aircraft> aircraftList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int fuel = rand.nextInt(100);
            Aircraft a;
            switch (i % 3) {
                case 0: a = new PassengerPlane("P" + i, fuel); break;
                case 1: a = new CargoPlane("C" + i, fuel); break;
                default: a = new Helicopter("H" + i, fuel); break;
            }
            tower.registerAircraft(a);
            aircraftList.add(a);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            Aircraft a = aircraftList.get(rand.nextInt(aircraftList.size()));
            if (a.fuelLevel < 10 || rand.nextDouble() < 0.05) {
                a.send("MAYDAY", tower);
            } else {
                tower.requestRunway(a);
            }
            tower.tick();
        }, 0, 1, TimeUnit.SECONDS);
    }
}
