package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

import java.util.List;

public interface Observable {
    void agregarParticipante(Observer participante);

    void quitarParticipante(Observer participante); 

    void reset();
    
    void agregarOferta(Oferta oferta);

    Integer ultimaOferta();

    String ultimoParticipante();

    List<Observer> getParticipantes();
    List<Oferta> getOfertas();

}
