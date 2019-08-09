package com.github.quantumquality;

import java.util.TimerTask;

public class ReceivingOrder extends TimerTask {

    private CollectionPoint collectionPoint;
    private Beeper beeper;


    public ReceivingOrder(CollectionPoint collectionPoint, Beeper beeper) {
        this.collectionPoint = collectionPoint;
        this.beeper = beeper;
    }

    @Override
    public void run() {
        collectionPoint.clientPicketUp(beeper);
    }
}
