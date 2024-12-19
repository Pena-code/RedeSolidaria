package io.codeforall.bootcamp.redesolidaria.services;

import io.codeforall.bootcamp.redesolidaria.exceptions.*;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;

import java.util.List;

/**
 * Common interface for customer services, provides methods to manage customers
 */
public interface PrestadorSvcService {

    /**
     * Gets the customer with the given id
     *
     * @param id the customer id
     * @return the customer
     */
    PrestadorSvc get(Integer id);

    List<PrestadorSvc> listByName(String name) throws CustomerNotFoundException;//alterar

    List<PrestadorSvc> listByConcelho(String concelho) throws CustomerNotFoundException;//alterar

    List<PrestadorSvc> listByServicoAndConcelho(int servicoId, String concelho);
    /**
     * Saves a installer
     *
     * @param prestadorSvc the installer to save
     * @return the saved installer
     */
    PrestadorSvc save(PrestadorSvc prestadorSvc);

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
    List<PrestadorSvc> list();
}
