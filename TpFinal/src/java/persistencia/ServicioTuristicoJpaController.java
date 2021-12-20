
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.PaqueteTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import logica.ServicioTuristico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Federico
 */
public class ServicioTuristicoJpaController implements Serializable {

    public ServicioTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ServicioTuristico servicioTuristico) {
        if (servicioTuristico.getListaPaqueteTuristico() == null) {
            servicioTuristico.setListaPaqueteTuristico(new ArrayList<PaqueteTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PaqueteTuristico> attachedListaPaqueteTuristico = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaqueteTuristicoPaqueteTuristicoToAttach : servicioTuristico.getListaPaqueteTuristico()) {
                listaPaqueteTuristicoPaqueteTuristicoToAttach = em.getReference(listaPaqueteTuristicoPaqueteTuristicoToAttach.getClass(), listaPaqueteTuristicoPaqueteTuristicoToAttach.getId());
                attachedListaPaqueteTuristico.add(listaPaqueteTuristicoPaqueteTuristicoToAttach);
            }
            servicioTuristico.setListaPaqueteTuristico(attachedListaPaqueteTuristico);
            em.persist(servicioTuristico);
            for (PaqueteTuristico listaPaqueteTuristicoPaqueteTuristico : servicioTuristico.getListaPaqueteTuristico()) {
                listaPaqueteTuristicoPaqueteTuristico.getListaServicioTuristico().add(servicioTuristico);
                listaPaqueteTuristicoPaqueteTuristico = em.merge(listaPaqueteTuristicoPaqueteTuristico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ServicioTuristico servicioTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ServicioTuristico persistentServicioTuristico = em.find(ServicioTuristico.class, servicioTuristico.getId());
            List<PaqueteTuristico> listaPaqueteTuristicoOld = persistentServicioTuristico.getListaPaqueteTuristico();
            List<PaqueteTuristico> listaPaqueteTuristicoNew = servicioTuristico.getListaPaqueteTuristico();
            List<PaqueteTuristico> attachedListaPaqueteTuristicoNew = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaqueteTuristicoNewPaqueteTuristicoToAttach : listaPaqueteTuristicoNew) {
                listaPaqueteTuristicoNewPaqueteTuristicoToAttach = em.getReference(listaPaqueteTuristicoNewPaqueteTuristicoToAttach.getClass(), listaPaqueteTuristicoNewPaqueteTuristicoToAttach.getId());
                attachedListaPaqueteTuristicoNew.add(listaPaqueteTuristicoNewPaqueteTuristicoToAttach);
            }
            listaPaqueteTuristicoNew = attachedListaPaqueteTuristicoNew;
            servicioTuristico.setListaPaqueteTuristico(listaPaqueteTuristicoNew);
            servicioTuristico = em.merge(servicioTuristico);
            for (PaqueteTuristico listaPaqueteTuristicoOldPaqueteTuristico : listaPaqueteTuristicoOld) {
                if (!listaPaqueteTuristicoNew.contains(listaPaqueteTuristicoOldPaqueteTuristico)) {
                    listaPaqueteTuristicoOldPaqueteTuristico.getListaServicioTuristico().remove(servicioTuristico);
                    listaPaqueteTuristicoOldPaqueteTuristico = em.merge(listaPaqueteTuristicoOldPaqueteTuristico);
                }
            }
            for (PaqueteTuristico listaPaqueteTuristicoNewPaqueteTuristico : listaPaqueteTuristicoNew) {
                if (!listaPaqueteTuristicoOld.contains(listaPaqueteTuristicoNewPaqueteTuristico)) {
                    listaPaqueteTuristicoNewPaqueteTuristico.getListaServicioTuristico().add(servicioTuristico);
                    listaPaqueteTuristicoNewPaqueteTuristico = em.merge(listaPaqueteTuristicoNewPaqueteTuristico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicioTuristico.getId();
                if (findServicioTuristico(id) == null) {
                    throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.");
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
            ServicioTuristico servicioTuristico;
            try {
                servicioTuristico = em.getReference(ServicioTuristico.class, id);
                servicioTuristico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.", enfe);
            }
            List<PaqueteTuristico> listaPaqueteTuristico = servicioTuristico.getListaPaqueteTuristico();
            for (PaqueteTuristico listaPaqueteTuristicoPaqueteTuristico : listaPaqueteTuristico) {
                listaPaqueteTuristicoPaqueteTuristico.getListaServicioTuristico().remove(servicioTuristico);
                listaPaqueteTuristicoPaqueteTuristico = em.merge(listaPaqueteTuristicoPaqueteTuristico);
            }
            em.remove(servicioTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ServicioTuristico> findServicioTuristicoEntities() {
        return findServicioTuristicoEntities(true, -1, -1);
    }

    public List<ServicioTuristico> findServicioTuristicoEntities(int maxResults, int firstResult) {
        return findServicioTuristicoEntities(false, maxResults, firstResult);
    }

    private List<ServicioTuristico> findServicioTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ServicioTuristico.class));
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

    public ServicioTuristico findServicioTuristico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ServicioTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ServicioTuristico> rt = cq.from(ServicioTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
