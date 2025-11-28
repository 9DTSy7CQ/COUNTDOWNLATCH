package es.etg.psp.dam;

import java.util.concurrent.CountDownLatch;

public class Main{

    private static final String INICIO_ESPERA = "Camiones en reparto";
    private static final String TODOS_LLEGADOS = " Han llegado todos los camiones.";

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cuenta = new CountDownLatch(5); 

        System.out.println(INICIO_ESPERA);

        Thread c1 = new Thread(new Camion("Camion-1", cuenta));
        Thread c2 = new Thread(new Camion("Camion-2", cuenta));
        Thread c3 = new Thread(new Camion("Camion-3", cuenta));
        Thread c4 = new Thread(new Camion("Camion-4", cuenta));
        Thread c5 = new Thread(new Camion("Camion-5", cuenta));

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        cuenta.await();

        System.out.println("\n" + TODOS_LLEGADOS);
    }
}

