package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.observables.Observable;

public interface Observer {
    void actualizarOferta(Integer valor);
    void reset();
    void realizarOferta(Observable producto);
    String getNombre(); 
}
