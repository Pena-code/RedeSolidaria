package io.codeforall.bootcamp.redesolidaria.persistence.dao;

import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;

import java.util.List;

/**
 * Common interface for customer data access objects
 */
public interface TicketDao extends Dao<Ticket> {

    /**
     * Gets the model
     *
     * @param name the Entidade name
     * @return the Entidade model
     */
    List<Ticket> findByName(String name);

    List<Ticket> findByPrestadorSvc(int id);

    List<Ticket> findByEntidade(int id);

    List<Ticket> findByEstado(String estado);

    List<Ticket> findByEstadoAndServicoId(String estado, int servicoId);

    List<Ticket> findByEstadoAndServicoIdAndConcelho(String estado, int servicoId, String concelho);

}
