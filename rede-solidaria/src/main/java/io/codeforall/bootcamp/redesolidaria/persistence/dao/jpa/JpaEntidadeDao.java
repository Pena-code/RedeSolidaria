package io.codeforall.bootcamp.redesolidaria.persistence.dao.jpa;

import io.codeforall.bootcamp.redesolidaria.persistence.dao.EntidadeDao;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.PrestadorSvcDao;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A JPA {@link PrestadorSvcDao} implementation
 */
@Repository
public class JpaEntidadeDao extends GenericJpaDao<Entidade> implements EntidadeDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaEntidadeDao() {
        super(Entidade.class);
    }

    @Override
    public List<Entidade> findByName(String name) {
               return em.createQuery("Select e FROM Entidade e WHERE e.nome LIKE :entName", Entidade.class)
                .setParameter("entName", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<Entidade> findByConcelho(String concelho) {
        return em.createQuery("Select e FROM Entidade e WHERE e.concelho LIKE :entConcelho", Entidade.class)
                .setParameter("entConcelho", "%" + concelho + "%")
                .getResultList();
    }
}
