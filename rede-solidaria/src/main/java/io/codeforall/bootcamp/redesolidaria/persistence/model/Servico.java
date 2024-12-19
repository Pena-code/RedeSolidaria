package io.codeforall.bootcamp.redesolidaria.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The customer model entity
 */
@Entity
@Table(name = "Servico")
public class Servico extends AbstractModel {

    private String tipoServico;
    private boolean certificado;


    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "servico",
            fetch = FetchType.EAGER
    )
    private List<PrestadorSvc> prestadorSvcs = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "servico",
            fetch = FetchType.EAGER
    )
    private List<Ticket> tickets = new ArrayList<>();

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public boolean hasCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public List<PrestadorSvc> getPrestadorSvcs() {
        return prestadorSvcs;
    }

    public void addPrestadorSvc(PrestadorSvc prestadorSvc) {
        prestadorSvcs.add(prestadorSvc);
        prestadorSvc.setServico(this);
    }

    public void removePrestadorSvc(PrestadorSvc prestadorSvc) {
        prestadorSvcs.remove(prestadorSvc);
        prestadorSvc.setServico(null);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setServico(this);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        ticket.setServico(null);
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {

        // printing recipients with lazy loading
        // and no session will cause issues
        return "PrestadorSvc{" +
                "tipo de serviço='" + tipoServico + '\'' +
                ", certificado='" + certificado +
                "} " + super.toString();
    }
}



