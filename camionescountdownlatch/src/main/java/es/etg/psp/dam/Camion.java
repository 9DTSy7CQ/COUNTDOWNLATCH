package es.etg.psp.dam;

import java.util.concurrent.CountDownLatch;

public class Camion implements Runnable {

    private String id;
    private CountDownLatch cuenta;

    private static final String LLEGADA_CAMION = "Ha llegado el camión: ";

    public  Camion(String id, CountDownLatch cuenta) {
        this.id = id;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        System.out.println(LLEGADA_CAMION + id);
        cuenta.countDown();
    }
}
