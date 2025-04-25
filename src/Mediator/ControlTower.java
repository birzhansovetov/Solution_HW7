package Mediator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ControlTower implements TowerMediator{
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();
    private final List<Aircraft> allAircraft = new ArrayList<>();
    private Aircraft runwayOccupiedBy = null;

    public void registerAircraft(Aircraft a) {
        allAircraft.add(a);
    }
    @Override
    public void broadcast(String msg, Aircraft sender) {
        if (msg.equalsIgnoreCase("MAYDAY")){
            sender.setEmergency(true);
            System.out.println("🚨 EMERGENCY: " + sender.getId() + " has sent MAYDAY!");
            clearRunway();
            notifyAllExcept(sender, "Hold position. Emergency landing in progress.");
            System.out.println("Tower: Runway cleared for emergency aircraft " + sender.getId());
            runwayOccupiedBy = sender;
        }else {
            System.out.println(sender.getId() + " broadcasts: " + msg);
        }
    }
    private void clearRunway() {
        runwayOccupiedBy = null;
    }
    private void notifyAllExcept(Aircraft exclude, String msg) {
        for (Aircraft aircraft : allAircraft) {
            if (!aircraft.equals(exclude)) {
                aircraft.receive(msg);
            }
        }
    }


    @Override
    public boolean requestRunway(Aircraft a) {
        if (a.isEmergency()){
            System.out.println("Tower: Emergency aircraft " + a.getId() + " granted immediate landing.");
            runwayOccupiedBy = a;
            return true;
        }
        if (runwayOccupiedBy == null){
            runwayOccupiedBy = a;
            System.out.println("Tower: Runway granted to " + a.getId());
            return true;
        }else {
            System.out.println("Tower: Runway busy. " + a.getId() + " added to queue.");
            landingQueue.add(a);
            return false;
        }
    }
    public void tick() {
        if (runwayOccupiedBy == null && !landingQueue.isEmpty()) {
            Aircraft next = landingQueue.poll();
            System.out.println("Tower: Runway granted to next in queue: " + next.getId());
            runwayOccupiedBy = next;
        }
    }
}
