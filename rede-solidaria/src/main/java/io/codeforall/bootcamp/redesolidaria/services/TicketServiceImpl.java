package io.codeforall.bootcamp.redesolidaria.services;

import io.codeforall.bootcamp.redesolidaria.exceptions.AssociationExistsException;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.EntidadeDao;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.TicketDao;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Customer;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketDao ticketDao;

    /**
     * Sets the customer data access object
     *
     * @param ticketDao the account DAO to set
     */
    @Autowired
    public void setTicketDao(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    /**
     * @see TicketService#get(Integer)
     */
    @Override
    public Ticket get(Integer id) {
        return ticketDao.findById(id);
    }

    @Override
    public List<Ticket> listByName(String name) throws CustomerNotFoundException {
        return ticketDao.findByName(name);
    }

    @Override
    public List<Ticket> listByPrestadorSvc(int id) throws CustomerNotFoundException {
        return ticketDao.findByPrestadorSvc(id);
    }

    @Override
    public List<Ticket> listByEntidade(int id) throws CustomerNotFoundException {
        return ticketDao.findByEntidade(id);
    }

    @Override
    public List<Ticket> listByEstado(String estado) throws CustomerNotFoundException {
        return ticketDao.findByEstado(estado);
    }

    @Override
    public List<Ticket> listByEstadoAndServicoId(String estado, int servicoId) throws CustomerNotFoundException {
        return ticketDao.findByEstadoAndServicoId(estado, servicoId);
    }

    @Override
    public List<Ticket> listByEstadoAndServicoIdAndConcelho(String estado, int servicoId, String concelho) {
        return ticketDao.findByEstadoAndServicoIdAndConcelho(estado, servicoId, concelho);
    }

    /**
     * @see TicketService#save(Ticket)
     */
    @Transactional
    @Override
    public Ticket save(Ticket ticket) {
        return ticketDao.saveOrUpdate(ticket);
    }

    /**
     * @see PrestadorSvcService#delete(Integer)
     */
    @Transactional
    @Override
    public void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException {

        Ticket ticket = Optional.ofNullable(ticketDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        ticketDao.delete(id);
    }

    @Override
    public List<Ticket> list() {
        return ticketDao.findAll();
    }

}

