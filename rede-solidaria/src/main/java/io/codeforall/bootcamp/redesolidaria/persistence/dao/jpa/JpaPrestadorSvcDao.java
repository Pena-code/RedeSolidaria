package io.codeforall.bootcamp.redesolidaria.persistence.dao.jpa;

import io.codeforall.bootcamp.redesolidaria.persistence.dao.PrestadorSvcDao;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A JPA {@link PrestadorSvcDao} implementation
 */
@Repository
public class JpaPrestadorSvcDao extends GenericJpaDao<PrestadorSvc> implements PrestadorSvcDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaPrestadorSvcDao() {
        super(PrestadorSvc.class);
    }

    @Override
    public List<PrestadorSvc> findByName(String name) {
               return em.createQuery("Select p FROM PrestadorSvc p WHERE p.nome LIKE :prestName", PrestadorSvc.class)
                .setParameter("prestName", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<PrestadorSvc> findByConcelho(String concelho) {
        return em.createQuery("Select p FROM PrestadorSvc p WHERE p.concelho LIKE :prestConcelho", PrestadorSvc.class)
                .setParameter("prestConcelho", "%" + concelho + "%")
                .getResultList();
    }

    @Override
    public List<PrestadorSvc> findByServicoAndConcelho(int servicoId, String concelho) {
        return em.createQuery("Select p FROM PrestadorSvc p WHERE p.servico.id = :servico AND p.concelho LIKE :prestConcelho", PrestadorSvc.class)
                .setParameter("prestConcelho", "%" + concelho + "%")
                .setParameter("servico", servicoId)
                .getResultList();
    }


}
