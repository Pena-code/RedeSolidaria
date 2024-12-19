package io.codeforall.bootcamp.redesolidaria.services;

import io.codeforall.bootcamp.redesolidaria.exceptions.AssociationExistsException;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;

import java.util.List;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface TicketService {

    /**
     * Gets the customer with the given id
     *
     * @param id the customer id
     * @return the customer
     */
    Ticket get(Integer id);

    List<Ticket> listByName(String name) throws CustomerNotFoundException;//alterar

    List<Ticket> listByPrestadorSvc(int id) throws CustomerNotFoundException;//alterar
    List<Ticket> listByEntidade(int id) throws CustomerNotFoundException;//alterar

    List<Ticket> listByEstado(String estado) throws CustomerNotFoundException;//alterar

    List<Ticket> listByEstadoAndServicoId(String estado, int servicoId) throws CustomerNotFoundException;//alterar

    List<Ticket> listByEstadoAndServicoIdAndConcelho(String estado, int servicoId, String concelho);


    /**
     * Saves a installer
     *
     * @param ticket the installer to save
     * @return the saved installer
     */
    Ticket save(Ticket ticket);

    /**
     * Deletes the customer
     *
     * @param id the customer id
     */
    void delete(Integer id) throws AssociationExistsException, CustomerNotFoundException;

    /**
     * Gets a list of the installers
     *
     * @return the installer list
     */
    List<Ticket> list();
}
