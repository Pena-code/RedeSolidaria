package io.codeforall.bootcamp.redesolidaria.services;

import io.codeforall.bootcamp.redesolidaria.exceptions.AssociationExistsException;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;

import java.util.List;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface EntidadeService {

    /**
     * Gets the customer with the given id
     *
     * @param id the customer id
     * @return the customer
     */
    Entidade get(Integer id);

    List<Entidade> listByName(String name) throws CustomerNotFoundException;//alterar

    List<Entidade> listByConcelho(String concelho) throws CustomerNotFoundException;//alterar

    /**
     * Saves a installer
     *
     * @param entidade the installer to save
     * @return the saved installer
     */
    Entidade save(Entidade entidade);

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
    List<Entidade> list();
}
