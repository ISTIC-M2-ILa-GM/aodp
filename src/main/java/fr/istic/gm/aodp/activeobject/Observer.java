package fr.istic.gm.aodp.activeobject;

import fr.istic.gm.aodp.enums.ChartIdentifier;

public interface Observer {
    void update(ChartIdentifier c);
}
