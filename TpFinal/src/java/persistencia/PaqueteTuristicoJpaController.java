
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.ServicioTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import logica.PaqueteTuristico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Federico
 */
public class PaqueteTuristicoJpaController implements Serializable {

    public PaqueteTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PaqueteTuristico paqueteTuristico) {
        if (paqueteTuristico.getListaServicioTuristico() == null) {
            paqueteTuristico.setListaServicioTuristico(new ArrayList<ServicioTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ServicioTuristico> attachedListaServicioTuristico = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico listaServicioTuristicoServicioTuristicoToAttach : paqueteTuristico.getListaServicioTuristico()) {
                listaServicioTuristicoServicioTuristicoToAttach = em.getReference(listaServicioTuristicoServicioTuristicoToAttach.getClass(), listaServicioTuristicoServicioTuristicoToAttach.getId());
                attachedListaServicioTuristico.add(listaServicioTuristicoServicioTuristicoToAttach);
            }
            paqueteTuristico.setListaServicioTuristico(attachedListaServicioTuristico);
            em.persist(paqueteTuristico);
            for (ServicioTuristico listaServicioTuristicoServicioTuristico : paqueteTuristico.getListaServicioTuristico()) {
                listaServicioTuristicoServicioTuristico.getListaPaqueteTuristico().add(paqueteTuristico);
                listaServicioTuristicoServicioTuristico = em.merge(listaServicioTuristicoServicioTuristico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PaqueteTuristico paqueteTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico persistentPaqueteTuristico = em.find(PaqueteTuristico.class, paqueteTuristico.getId());
            List<ServicioTuristico> listaServicioTuristicoOld = persistentPaqueteTuristico.getListaServicioTuristico();
            List<ServicioTuristico> listaServicioTuristicoNew = paqueteTuristico.getListaServicioTuristico();
            List<ServicioTuristico> attachedListaServicioTuristicoNew = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico listaServicioTuristicoNewServicioTuristicoToAttach : listaServicioTuristicoNew) {
                listaServicioTuristicoNewServicioTuristicoToAttach = em.getReference(listaServicioTuristicoNewServicioTuristicoToAttach.getClass(), listaServicioTuristicoNewServicioTuristicoToAttach.getId());
                attachedListaServicioTuristicoNew.add(listaServicioTuristicoNewServicioTuristicoToAttach);
            }
            listaServicioTuristicoNew = attachedListaServicioTuristicoNew;
            paqueteTuristico.setListaServicioTuristico(listaServicioTuristicoNew);
            paqueteTuristico = em.merge(paqueteTuristico);
            for (ServicioTuristico listaServicioTuristicoOldServicioTuristico : listaServicioTuristicoOld) {
                if (!listaServicioTuristicoNew.contains(listaServicioTuristicoOldServicioTuristico)) {
                    listaServicioTuristicoOldServicioTuristico.getListaPaqueteTuristico().remove(paqueteTuristico);
                    listaServicioTuristicoOldServicioTuristico = em.merge(listaServicioTuristicoOldServicioTuristico);
                }
            }
            for (ServicioTuristico listaServicioTuristicoNewServicioTuristico : listaServicioTuristicoNew) {
                if (!listaServicioTuristicoOld.contains(listaServicioTuristicoNewServicioTuristico)) {
                    listaServicioTuristicoNewServicioTuristico.getListaPaqueteTuristico().add(paqueteTuristico);
                    listaServicioTuristicoNewServicioTuristico = em.merge(listaServicioTuristicoNewServicioTuristico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paqueteTuristico.getId();
                if (findPaqueteTuristico(id) == null) {
                    throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.");
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
            PaqueteTuristico paqueteTuristico;
            try {
                paqueteTuristico = em.getReference(PaqueteTuristico.class, id);
                paqueteTuristico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.", enfe);
            }
            List<ServicioTuristico> listaServicioTuristico = paqueteTuristico.getListaServicioTuristico();
            for (ServicioTuristico listaServicioTuristicoServicioTuristico : listaServicioTuristico) {
                listaServicioTuristicoServicioTuristico.getListaPaqueteTuristico().remove(paqueteTuristico);
                listaServicioTuristicoServicioTuristico = em.merge(listaServicioTuristicoServicioTuristico);
            }
            em.remove(paqueteTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities() {
        return findPaqueteTuristicoEntities(true, -1, -1);
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities(int maxResults, int firstResult) {
        return findPaqueteTuristicoEntities(false, maxResults, firstResult);
    }

    private List<PaqueteTuristico> findPaqueteTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PaqueteTuristico.class));
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

    public PaqueteTuristico findPaqueteTuristico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PaqueteTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaqueteTuristico> rt = cq.from(PaqueteTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
