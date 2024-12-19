package io.codeforall.bootcamp.redesolidaria.persistence.dao.jpa;

import io.codeforall.bootcamp.redesolidaria.persistence.dao.EntidadeDao;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.PrestadorSvcDao;
import io.codeforall.bootcamp.redesolidaria.persistence.dao.TicketDao;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Entidade;
import io.codeforall.bootcamp.redesolidaria.persistence.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A JPA {@link TicketDao} implementation
 */
@Repository
public class JpaTicketDao extends GenericJpaDao<Ticket> implements TicketDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaTicketDao() {
        super(Ticket.class);
    }

    @Override
    public List<Ticket> findByName(String name) {
               return em.createQuery("Select e FROM Entidade e WHERE e.nome LIKE :entName", Ticket.class)
                .setParameter("entName", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<Ticket> findByPrestadorSvc(int id) {
        return em.createQuery("Select t FROM Ticket t WHERE t.prestadorsvc.id = :id", Ticket.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Ticket> findByEntidade(int id) {
        return em.createQuery("Select t FROM Ticket t WHERE t.entidade.id = :id", Ticket.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Ticket> findByEstado(String estado) {

        switch (estado) {
            case "aberto":
                return em.createQuery("Select t FROM Ticket t WHERE t.aberto = true", Ticket.class)
                       .getResultList();
            case "emprogresso":
                return em.createQuery("Select t FROM Ticket t WHERE t.emProgresso = true", Ticket.class)
                       .getResultList();
            case "concluido":
                return em.createQuery("Select t FROM Ticket t WHERE t.concluido = true", Ticket.class)
                       .getResultList();

            default: return null;
        }
    }

    @Override
    public List<Ticket> findByEstadoAndServicoId(String estado, int servicoId) {

        switch (estado) {
            case "aberto":
                return em.createQuery("Select t FROM Ticket t WHERE t.aberto = true and t.servico.id = :servicoId", Ticket.class)
                        .setParameter("servicoId", servicoId)
                        .getResultList();
            case "emprogresso":
                return em.createQuery("Select t FROM Ticket t WHERE t.emProgresso = true and t.servico.id = :servicoId", Ticket.class)
                        .setParameter("servicoId", servicoId)
                        .getResultList();
            case "concluido":
                return em.createQuery("Select t FROM Ticket t WHERE t.concluido = true and t.servico.id = :servicoId", Ticket.class)
                        .setParameter("servicoId", servicoId)
                        .getResultList();
            case "todos":
                return em.createQuery("Select t FROM Ticket t WHERE t.servico.id = :servicoId", Ticket.class)
                        .setParameter("servicoId", servicoId)
                        .getResultList();

            default: return null;
        }
    }

    @Override
    public List<Ticket> findByEstadoAndServicoIdAndConcelho(String estado, int servicoId, String concelho) {

        switch (estado) {
            case "aberto":
                return em.createQuery("Select t FROM Ticket t WHERE t.aberto = true and t.servico.id = :servicoId and t.entidade.concelho = :entconcelho and t.prestadorsvc.concelho = :prestconcelho", Ticket.class)
                        .setParameter("servicoId", servicoId)
                        .setParameter("entconcelho", concelho)
                        .setParameter("prestconcelho", concelho)
                        .getResultList();
            case "emprogresso":
                return em.createQuery("Select t FROM Ticket t WHERE t.emProgresso = true and t.servico.id = :servicoId and t.entidade.concelho = :entconcelho and t.prestadorsvc.concelho = :prestconcelho", Ticket.class)
                        .setParameter("servicoId", servicoId)
                        .setParameter("entconcelho", concelho)
                        .setParameter("prestconcelho", concelho)
                        .getResultList();
            case "concluido":
                return em.createQuery("Select t FROM Ticket t WHERE t.concluido = true and t.servico.id = :servicoId and t.entidade.concelho = :entconcelho and t.prestadorsvc.concelho = :prestconcelho", Ticket.class)
                        .setParameter("servicoId", servicoId)
                        .setParameter("entconcelho", concelho)
                        .setParameter("prestconcelho", concelho)
                        .getResultList();
            case "todos":
                return em.createQuery("Select t FROM Ticket t WHERE t.servico.id = :servicoId and t.entidade.concelho = :entconcelho and t.prestadorsvc.concelho = :prestconcelho", Ticket.class)
                        .setParameter("servicoId", servicoId)
                        .setParameter("entconcelho", concelho)
                        .setParameter("prestconcelho", concelho)
                        .getResultList();

            default: return null;
        }
    }
}
