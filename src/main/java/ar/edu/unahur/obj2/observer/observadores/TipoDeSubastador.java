package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.observables.Observable;

public interface TipoDeSubastador {
    void crearOferta(Observable producto, Subastador subastador);
}

