package io.codeforall.bootcamp.redesolidaria.persistence.dao;

import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;

import java.util.List;

/**
 * Common interface for customer data access objects
 */
public interface PrestadorSvcDao extends Dao<PrestadorSvc> {

    /**
     * Gets the model
     *
     * @param name the PrestadorSvc name
     * @return the PrestadorSvc
     */
    List<PrestadorSvc> findByName(String name);

    List<PrestadorSvc> findByConcelho(String concelho);

    List<PrestadorSvc> findByServicoAndConcelho(int servicoId, String concelho);

}
