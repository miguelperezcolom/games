package io.mateu.games.core;

import javafx.application.Platform;

public class Runable implements Runnable {

    private final Juego juego;

    public Runable(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void run() {
        long t0 = System.currentTimeMillis();
        double fps = 1;
        System.out.println("jugando = " + juego.isJugando());
        while (juego.isJugando()) {
            long t = System.currentTimeMillis();
            long delta = t - t0;

            if (delta > 0) fps = 1000 / delta;
            juego.actualizar(delta);

            final boolean[] listo = {false};

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    juego.dibujar();
                    listo[0] = true;
                }
            });

            while (!listo[0]) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (fps > 60) {
                try {
                    Thread.sleep((1000 / 60) - delta);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
