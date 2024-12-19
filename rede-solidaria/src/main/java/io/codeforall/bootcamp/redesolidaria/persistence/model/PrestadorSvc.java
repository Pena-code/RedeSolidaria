package io.codeforall.bootcamp.redesolidaria.persistence.model;

import io.codeforall.bootcamp.redesolidaria.persistence.model.account.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The customer model entity
 */
@Entity
@Table(name = "prestadorsvc")
public class PrestadorSvc extends AbstractModel {

    private String nome;
    private String email;
    private int contacto;
    private int nif;
    private String concelho;
    private boolean ativo;
    private String docs;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "prestadorsvc",
            fetch = FetchType.EAGER
    )
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne
    private Servico servico;

    /**
     * Gets the name of the installer
     *
     * @return the installer name
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the email of the installer
     *
     * @param nome the name to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the email of the installer
     *
     * @return the installer email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the installer
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the contact number of the installer
     *
     * @return the installer contact number
     */
    public int getContacto() {
        return contacto;
    }

    /**
     * Sets the contact number of the installer
     *
     * @param contacto the contact number to set
     */
    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    /**
     * Gets the NIF of the installer
     *
     * @return the installer NIF
     */
    public int getNif() {
        return nif;
    }

    /**
     * Sets the NIF of the installer
     *
     * @param nif the NIF to set
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Gets the concelho where the installer lives
     *
     * @return the installer's concelho
     */
    public String getConcelho() {
        return concelho;
    }

    /**
     * Sets the concelho where the installer lives
     *
     * @param concelho the installer's concelho to set
     */
    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    /**
     * Gets the status of the installer
     *
     * @return true if the installer is active, false otherwise
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Sets the status of the installer
     *
     * @param ativo true to make the installer active, false otherwise
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Sets documents of the installer
     *
     * returns binary file
     */
    public String getDocs() {
        return docs;
    }

    /**
     * Sets documents of the installer
     *
     * @param docs binary file
     */
    public void setDocs(String docs) {
        this.docs = docs;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        ticket.setPrestadorSvc(this);
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        ticket.setPrestadorSvc(null);
        tickets.remove(ticket);
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {

        // printing recipients with lazy loading
        // and no session will cause issues
        return "PrestadorSvc{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", contacto='" + contacto + '\'' +
                ", nif='" + nif + '\'' +
                ", serviço=" + servico +
                ", docs=" + docs +
                "} " + super.toString();
    }
}



