package fr.istic.gm.aodp.domain;

import fr.istic.gm.aodp.enums.ChartIdentifier;

public interface MonitorObserver {
    void update(ChartIdentifier c);
}
