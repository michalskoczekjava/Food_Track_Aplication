package com.github.quantumquality;

import java.time.LocalDateTime;
import java.util.Timer;

public class CollectionPoint {

    private Manager manager;


    public void callAClient(Beeper beeper) {
        ReceivingOrder receivingOrder = new ReceivingOrder(this, beeper);
        Timer timer = new Timer();
        timer.schedule(receivingOrder, 5000);
    }

    public void clientPicketUp(Beeper beeper) {
        manager.orderReceived(beeper);
        System.out.println("Zamówienie odebrane! " + " Smacznego");
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
