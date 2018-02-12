package io.mateu.games.core;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter@Setter
public class BaseNivel implements Nivel {

    private List<Objeto> objetos = new ArrayList<>();

    @Override
    public void onCreate() {
        objetos = new ArrayList<>();
    }

    @Override
    public void onFinish() {

    }

    @Override
    public void actualizar(long deltaTime) {
        getObjetos().forEach((o) -> o.actualizar(deltaTime));
    }

    @Override
    public void dibujar(Renderizador renderizador) {
        renderizador.dibujarFondo(0x0000ff);
        getObjetos().forEach(o -> o.dibujar(renderizador));
    }


}
