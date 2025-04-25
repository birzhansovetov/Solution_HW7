package Mediator;

public abstract class Aircraft {
    protected final String id;
    protected int fuelLevel;
    protected boolean emergency = false;

    public Aircraft(String id, int fuelLevel) {
        this.id = id;
        this.fuelLevel = fuelLevel;
    }

    public abstract void receive(String msg);

    public void send(String msg, TowerMediator mediator) {
        mediator.broadcast(msg, this);
    }

    public String getId() {
        return id;
    }

    public boolean isEmergency() {
        return emergency || fuelLevel <= 10;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}
