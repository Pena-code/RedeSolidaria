package io.codeforall.bootcamp.redesolidaria.persistence.dao.jpa;

import io.codeforall.bootcamp.redesolidaria.persistence.dao.PrestadorSvcDao;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.ServicoDao;
import io.codeforall.bootcamp.redesolidaria.persistence.model.PrestadorSvc;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Servico;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A JPA {@link PrestadorSvcDao} implementation
 */
@Repository
public class JpaServicoDao extends GenericJpaDao<Servico> implements ServicoDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaServicoDao() {
        super(Servico.class);
    }

    @Override
    public List<Servico> findByName(String name) {
               return em.createQuery("Select s FROM Servico s WHERE s.nome LIKE :servName", Servico.class)
                .setParameter("servName", "%" + name + "%")
                .getResultList();
    }
}
