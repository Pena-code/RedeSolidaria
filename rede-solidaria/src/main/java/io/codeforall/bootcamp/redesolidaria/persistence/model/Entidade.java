package io.codeforall.bootcamp.redesolidaria.persistence.model;

import io.codeforall.bootcamp.redesolidaria.persistence.model.account.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The customer model entity
 */
@Entity
@Table(name = "entidade")
public class Entidade extends AbstractModel {

    private String nome;
    private String email;
    private int contacto;
    private int nif;
    private String morada;
    private String concelho;
    private String docs;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "entidade",
            fetch = FetchType.EAGER
    )
    // tickets
    private List<Ticket> tickets = new ArrayList<>();

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
     * Gets the address of the installer
     *
     * @return the installer address
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Sets the address of the installer
     *
     * @param morada the address to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Gets the concelho of the installer
     *
     * @return the installer concelho
     */
    public String getConcelho() {
        return concelho;
    }

    /**
     * Sets the concelho of the installer
     *
     * @param concelho the concelho to set
     */
    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    /**
     * Gets the service type of the installer
     *
     * @return the installer service type
     */

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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket ticket) {
        tickets.add(ticket);
        ticket.setEntidade(this);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
        ticket.setEntidade(null);
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
                ", morada=" + morada +
                ", concelho=" + concelho +
                ", docs=" + docs +
                "} " + super.toString();
    }
}



