package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class ProductoSubatado implements Observable {

    private List<Observer> participantes = new ArrayList<>();
    private List<Oferta> ofertas = new ArrayList<>();

    @Override
    public List<Observer> getParticipantes(){
        return this.participantes;
    }

    @Override
    public List<Oferta> getOfertas() {
        return this.ofertas;
    }

    @Override
    public Integer cantDeOfertas(){
        return ofertas.size();
    }

    @Override
    public void agregarOferta(Oferta oferta) {
        /*
          agrega una ofertaa la lista de ofertas si el participante pertenece a la lista de participantes
          y notifica a los demas participantes
        */
        if(!participantes.stream().anyMatch(par -> par.getNombre().equals(oferta.getCliente()))){
            throw new OfertaSubastadorException("no esta participando en la subasta");
        }

        ofertas.add(oferta);
        participantes.forEach(p -> p.guardarUltimaOferta(oferta));
    }

    @Override
    public void agregarParticipante(Observer participante) {
        //agrega un participante en la lista  
        participantes.add(participante);
        
    }

    @Override
    public void quitarParticipante(Observer participante) {
        //remueve participante
        participantes.remove(participante);
        
    }

    @Override
    public void reset() {
        participantes.clear();
        ofertas.clear();
    }

    @Override
    public Oferta ultimaOferta(){
        if(ofertas.isEmpty()){
            throw new OfertaSubastadorException("no hay ofertas disponibles");
        }
        return ofertas.get(ofertas.size()-1);
    }

    @Override
    public String ultimoParticipante(){
        if(participantes.isEmpty()){
            throw new OfertaSubastadorException("no hay participantes");
        }
        return participantes.get(participantes.size() - 1).getNombre();
    }

    

}
