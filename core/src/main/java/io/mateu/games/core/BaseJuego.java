package io.mateu.games.core;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class BaseJuego implements Juego {

    private Renderizador renderizador;

    private boolean jugando = false;

    private List<Nivel> niveles = new ArrayList<>();
    private Nivel nivelActual;
    private Thread hilo;
    private double screenX;
    private double screenY;

    public BaseJuego() {

    }

    @Override
    public void setRenderizador(Renderizador renderizador) {
        this.renderizador = renderizador;
    }

    public void onStart() throws Exception {
        if (niveles.size() == 0) throw  new Exception("El juego debe tener niveles.");
        nivelActual = niveles.get(0);
        setJugando(true);
        hilo = new Thread(new Runable(this));
        hilo.start();
    }

    @Override
    public void actualizar(long delta) {
        getNivelActual().actualizar(delta);
    }

    @Override
    public void dibujar() {
        getNivelActual().dibujar(getRenderizador());
    }

    @Override
    public void setScreenX(double width) {
        screenX = width;
    }

    @Override
    public void setScreenY(double height) {
        screenY = height;
    }


    public void onDie() {

    }

    public void onEnd() {

    }

    @Override
    public void moveTo(double x, double y) {
        System.out.println("moveto " + x + " " + y);
    }

    @Override
    public void tap(double x, double y) {
        System.out.println("tap " + x + " " + y);
    }
}
