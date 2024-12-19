package io.codeforall.bootcamp.redesolidaria.services;

import io.codeforall.bootcamp.redesolidaria.exceptions.AssociationExistsException;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.PrestadorSvcDao;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.ServicoDao;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Customer;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoServiceImpl implements ServicoService {

    private ServicoDao servicoDao;

    /**
     * Sets the customer data access object
     *
     * @param servicoDao the account DAO to set
     */
    @Autowired
    public void setServicoDao(ServicoDao servicoDao) {
        this.servicoDao = servicoDao;
    }

    /**
     * @see ServicoService#get(Integer)
     */
    @Override
    public Servico get(Integer id) {
        return servicoDao.findById(id);
    }

    @Override
    public List<Servico> listByName(String name) throws CustomerNotFoundException {
        return servicoDao.findByName(name);
    }

    /**
     * @see CustomerService#save(Customer)
     */
    @Transactional
    @Override
    public Servico save(Servico servico) {
        return servicoDao.saveOrUpdate(servico);
    }

    /**
     * @see PrestadorSvcService#delete(Integer)
     */
    @Transactional
    @Override
    public void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException {

        Servico servico = Optional.ofNullable(servicoDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        servicoDao.delete(id);
    }

    @Override
    public List<Servico> list() {
        return servicoDao.findAll();
    }

}

