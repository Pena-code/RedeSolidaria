package io.codeforall.bootcamp.redesolidaria.persistence.dao;

import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;

import java.util.List;

/**
 * Common interface for customer data access objects
 */
public interface ServicoDao extends Dao<Servico> {

    /**
     * Gets the model
     *
     * @param name the PrestadorSvc name
     * @return the PrestadorSvc
     */
    List<Servico> findByName(String name);

}
