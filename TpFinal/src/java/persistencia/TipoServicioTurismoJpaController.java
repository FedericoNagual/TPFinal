
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.TipoServicioTurismo;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Federico
 */
public class TipoServicioTurismoJpaController implements Serializable {

    public TipoServicioTurismoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public TipoServicioTurismoJpaController() {
        emf = Persistence.createEntityManagerFactory("TpFinalPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoServicioTurismo tipoServicioTurismo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoServicioTurismo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoServicioTurismo tipoServicioTurismo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoServicioTurismo = em.merge(tipoServicioTurismo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoServicioTurismo.getId_TipoServicioTurismo();
                if (findTipoServicioTurismo(id) == null) {
                    throw new NonexistentEntityException("The tipoServicioTurismo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoServicioTurismo tipoServicioTurismo;
            try {
                tipoServicioTurismo = em.getReference(TipoServicioTurismo.class, id);
                tipoServicioTurismo.getId_TipoServicioTurismo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoServicioTurismo with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoServicioTurismo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoServicioTurismo> findTipoServicioTurismoEntities() {
        return findTipoServicioTurismoEntities(true, -1, -1);
    }

    public List<TipoServicioTurismo> findTipoServicioTurismoEntities(int maxResults, int firstResult) {
        return findTipoServicioTurismoEntities(false, maxResults, firstResult);
    }

    private List<TipoServicioTurismo> findTipoServicioTurismoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoServicioTurismo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoServicioTurismo findTipoServicioTurismo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoServicioTurismo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoServicioTurismoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoServicioTurismo> rt = cq.from(TipoServicioTurismo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
