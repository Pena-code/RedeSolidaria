package io.codeforall.bootcamp.redesolidaria.services;

import io.codeforall.bootcamp.redesolidaria.exceptions.AssociationExistsException;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;

import java.util.List;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface ServicoService {

    /**
     * Gets the customer with the given id
     *
     * @param id the customer id
     * @return the customer
     */
    Servico get(Integer id);

    List<Servico> listByName(String name) throws CustomerNotFoundException;//alterar

    /**
     * Saves a installer
     *
     * @param servico the installer to save
     * @return the saved installer
     */
    Servico save(Servico servico);

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
    List<Servico> list();
}
