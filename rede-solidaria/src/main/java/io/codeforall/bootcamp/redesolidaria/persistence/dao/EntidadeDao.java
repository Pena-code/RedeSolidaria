package io.codeforall.bootcamp.redesolidaria.persistence.dao;

import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;

import java.util.List;

/**
 * Common interface for customer data access objects
 */
public interface EntidadeDao extends Dao<Entidade> {

    /**
     * Gets the model
     *
     * @param name the Entidade name
     * @return the Entidade model
     */
    List<Entidade> findByName(String name);

    List<Entidade> findByConcelho(String concelho);

}
