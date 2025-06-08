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
    public void agregarOferta(Oferta oferta) {
        if(participantes.stream().anyMatch(par -> par.getNombre().equals(oferta.getCliente()))){
            throw new OfertaSubastadorException("no esta participando en la subasta");
        }
        ofertas.add(oferta);
    }

    @Override
    public void agregarParticipante(Observer participante) {
        participantes.add(participante);
        
    }

    @Override
    public void notificarAParticipantes() {
        participantes.forEach(of -> of.actualizarOferta(this.ultimaOferta()));
    }

    @Override
    public void quitarParticipante(Observer participante) {
        participantes.remove(participante);
        
    }

    @Override
    public void reset() {
        participantes = new ArrayList<>();
        ofertas = new ArrayList<>();
    }

    public Integer ultimaOferta(){
        if(ofertas.isEmpty()){
            throw new OfertaSubastadorException("no hay ofertas disponibles");
        }
        return ofertas.get(ofertas.size()-1).getPrecio();
    }

    public String ultimoParticipante(){
        if(participantes.isEmpty()){
            throw new OfertaSubastadorException("no hay participantes");
        }
        return participantes.get(participantes.size() - 1).getNombre();
    }

}
