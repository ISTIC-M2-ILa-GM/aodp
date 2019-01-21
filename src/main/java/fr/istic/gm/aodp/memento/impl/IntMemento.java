package fr.istic.gm.aodp.memento.impl;

import fr.istic.gm.aodp.memento.Memento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class IntMemento implements Memento<Integer> {

    @Getter
    @Setter
    private Integer value;
}
