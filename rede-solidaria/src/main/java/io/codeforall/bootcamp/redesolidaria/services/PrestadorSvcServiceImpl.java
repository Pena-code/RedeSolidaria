package io.codeforall.bootcamp.redesolidaria.services;

import io.codeforall.bootcamp.redesolidaria.exceptions.*;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.PrestadorSvcDao;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Customer;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrestadorSvcServiceImpl implements PrestadorSvcService {

    private PrestadorSvcDao prestadorSvcDao;

    /**
     * Sets the customer data access object
     *
     * @param prestadorSvcDao the account DAO to set
     */
    @Autowired
    public void setPrestadorSvcDao(PrestadorSvcDao prestadorSvcDao) {
        this.prestadorSvcDao = prestadorSvcDao;
    }

    /**
     * @see PrestadorSvcService#get(Integer)
     */
    @Override
    public PrestadorSvc get(Integer id) {
        return prestadorSvcDao.findById(id);
    }

    @Override
    public List<PrestadorSvc> listByName(String name) throws CustomerNotFoundException {
        return prestadorSvcDao.findByName(name);
    }

    @Override
    public List<PrestadorSvc> listByConcelho(String concelho) throws CustomerNotFoundException {
        return prestadorSvcDao.findByConcelho(concelho);
    }

    @Override
    public List<PrestadorSvc> listByServicoAndConcelho(int servicoId, String concelho) {
        return prestadorSvcDao.findByServicoAndConcelho(servicoId, concelho);
    }

    /**
     * @see CustomerService#save(Customer)
     */
    @Transactional
    @Override
    public PrestadorSvc save(PrestadorSvc prestadorSvc) {
        return prestadorSvcDao.saveOrUpdate(prestadorSvc);
    }

    /**
     * @see PrestadorSvcService#delete(Integer)
     */
    @Transactional
    @Override
    public void delete(Integer id) throws CustomerNotFoundException, AssociationExistsException {

        PrestadorSvc prestadorSvc = Optional.ofNullable(prestadorSvcDao.findById(id))
                .orElseThrow(CustomerNotFoundException::new);

        prestadorSvcDao.delete(id);
    }

    @Override
    public List<PrestadorSvc> list() {
        return prestadorSvcDao.findAll();
    }

}

