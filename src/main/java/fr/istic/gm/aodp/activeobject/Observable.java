package fr.istic.gm.aodp.activeobject;

public interface Observable {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
