package io.codeforall.bootcamp.redesolidaria.services;

import io.codeforall.bootcamp.redesolidaria.exceptions.AssociationExistsException;
import io.codeforall.bootcamp.redesolidaria.exceptions.CustomerNotFoundException;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.EntidadeDao;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.PrestadorSvcDao;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Customer;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadeServiceImpl implements EntidadeService {

    private EntidadeDao entidadeDao;

    /**
     * Sets the customer data access object
     *
     * @param entidadeDao the account DAO to set
     */
    @Autowired
    public void setEntidadeDao(EntidadeDao entidadeDao) {
        this.entidadeDao = entidadeDao;
    }

    /**
     * @see EntidadeService#get(Integer)
     */
    @Override
    public Entidade get(Integer id) {
        return entidadeDao.findById(id);
    }

    @Override
    public List<Entidade> listByName(String name) throws CustomerNotFoundException {
        return entidadeDao.findByName(name);
    }

    @Override
    public List<Entidade> listByConcelho(String concelho) throws CustomerNotFoundException {
        return entidadeDao.findByConcelho(concelho);
    }

    /**
     * @see EntidadeService#save(Entidade)
     */
    @Transactional
    @Override
    public Entidade save(Entidade entidade) {
        return entidadeDao.saveOrUpdate(entidade);
    }

    /**
     * @see PrestadorSvcService#delete(Integer)
     */
    @Transactional
    @Override
    public void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException {

        Entidade entidade = Optional.ofNullable(entidadeDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        entidadeDao.delete(id);
    }

    @Override
    public List<Entidade> list() {
        return entidadeDao.findAll();
    }

}

