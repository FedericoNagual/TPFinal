/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        if (servicioTuristico.getPaqueteTuristico() == null) {
            servicioTuristico.setPaqueteTuristico(new ArrayList<PaqueteTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PaqueteTuristico> attachedPaqueteTuristico = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico paqueteTuristicoPaqueteTuristicoToAttach : servicioTuristico.getPaqueteTuristico()) {
                paqueteTuristicoPaqueteTuristicoToAttach = em.getReference(paqueteTuristicoPaqueteTuristicoToAttach.getClass(), paqueteTuristicoPaqueteTuristicoToAttach.getId());
                attachedPaqueteTuristico.add(paqueteTuristicoPaqueteTuristicoToAttach);
            }
            servicioTuristico.setPaqueteTuristico(attachedPaqueteTuristico);
            em.persist(servicioTuristico);
            for (PaqueteTuristico paqueteTuristicoPaqueteTuristico : servicioTuristico.getPaqueteTuristico()) {
                paqueteTuristicoPaqueteTuristico.getListaServicio().add(servicioTuristico);
                paqueteTuristicoPaqueteTuristico = em.merge(paqueteTuristicoPaqueteTuristico);
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
            List<PaqueteTuristico> paqueteTuristicoOld = persistentServicioTuristico.getPaqueteTuristico();
            List<PaqueteTuristico> paqueteTuristicoNew = servicioTuristico.getPaqueteTuristico();
            List<PaqueteTuristico> attachedPaqueteTuristicoNew = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico paqueteTuristicoNewPaqueteTuristicoToAttach : paqueteTuristicoNew) {
                paqueteTuristicoNewPaqueteTuristicoToAttach = em.getReference(paqueteTuristicoNewPaqueteTuristicoToAttach.getClass(), paqueteTuristicoNewPaqueteTuristicoToAttach.getId());
                attachedPaqueteTuristicoNew.add(paqueteTuristicoNewPaqueteTuristicoToAttach);
            }
            paqueteTuristicoNew = attachedPaqueteTuristicoNew;
            servicioTuristico.setPaqueteTuristico(paqueteTuristicoNew);
            servicioTuristico = em.merge(servicioTuristico);
            for (PaqueteTuristico paqueteTuristicoOldPaqueteTuristico : paqueteTuristicoOld) {
                if (!paqueteTuristicoNew.contains(paqueteTuristicoOldPaqueteTuristico)) {
                    paqueteTuristicoOldPaqueteTuristico.getListaServicio().remove(servicioTuristico);
                    paqueteTuristicoOldPaqueteTuristico = em.merge(paqueteTuristicoOldPaqueteTuristico);
                }
            }
            for (PaqueteTuristico paqueteTuristicoNewPaqueteTuristico : paqueteTuristicoNew) {
                if (!paqueteTuristicoOld.contains(paqueteTuristicoNewPaqueteTuristico)) {
                    paqueteTuristicoNewPaqueteTuristico.getListaServicio().add(servicioTuristico);
                    paqueteTuristicoNewPaqueteTuristico = em.merge(paqueteTuristicoNewPaqueteTuristico);
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
            List<PaqueteTuristico> paqueteTuristico = servicioTuristico.getPaqueteTuristico();
            for (PaqueteTuristico paqueteTuristicoPaqueteTuristico : paqueteTuristico) {
                paqueteTuristicoPaqueteTuristico.getListaServicio().remove(servicioTuristico);
                paqueteTuristicoPaqueteTuristico = em.merge(paqueteTuristicoPaqueteTuristico);
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
