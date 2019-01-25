package fr.istic.gm.aodp.domain;

import fr.istic.gm.aodp.enums.ChartIdentifier;

/**
 * The monitor observer
 */
public interface MonitorObserver {

    /**
     * Update the chart with a new value
     *
     * @param c     the chart
     * @param value the value
     */
    void update(ChartIdentifier c, Integer value);
}
