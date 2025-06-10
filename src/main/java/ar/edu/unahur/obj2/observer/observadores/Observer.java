package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;

public interface Observer {
    void guardarUltimaOferta(Oferta valor);
    
    void reset();

    void actualizarOferta();

    String getNombre(); 

    Oferta getUltimaOferta();

    void setObjetoSubastable(Observable objeto);
}
