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
        if (paqueteTuristico.getListaServicio() == null) {
            paqueteTuristico.setListaServicio(new ArrayList<ServicioTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ServicioTuristico> attachedListaServicio = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico listaServicioServicioTuristicoToAttach : paqueteTuristico.getListaServicio()) {
                listaServicioServicioTuristicoToAttach = em.getReference(listaServicioServicioTuristicoToAttach.getClass(), listaServicioServicioTuristicoToAttach.getId());
                attachedListaServicio.add(listaServicioServicioTuristicoToAttach);
            }
            paqueteTuristico.setListaServicio(attachedListaServicio);
            em.persist(paqueteTuristico);
            for (ServicioTuristico listaServicioServicioTuristico : paqueteTuristico.getListaServicio()) {
                listaServicioServicioTuristico.getPaqueteTuristico().add(paqueteTuristico);
                listaServicioServicioTuristico = em.merge(listaServicioServicioTuristico);
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
            List<ServicioTuristico> listaServicioOld = persistentPaqueteTuristico.getListaServicio();
            List<ServicioTuristico> listaServicioNew = paqueteTuristico.getListaServicio();
            List<ServicioTuristico> attachedListaServicioNew = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico listaServicioNewServicioTuristicoToAttach : listaServicioNew) {
                listaServicioNewServicioTuristicoToAttach = em.getReference(listaServicioNewServicioTuristicoToAttach.getClass(), listaServicioNewServicioTuristicoToAttach.getId());
                attachedListaServicioNew.add(listaServicioNewServicioTuristicoToAttach);
            }
            listaServicioNew = attachedListaServicioNew;
            paqueteTuristico.setListaServicio(listaServicioNew);
            paqueteTuristico = em.merge(paqueteTuristico);
            for (ServicioTuristico listaServicioOldServicioTuristico : listaServicioOld) {
                if (!listaServicioNew.contains(listaServicioOldServicioTuristico)) {
                    listaServicioOldServicioTuristico.getPaqueteTuristico().remove(paqueteTuristico);
                    listaServicioOldServicioTuristico = em.merge(listaServicioOldServicioTuristico);
                }
            }
            for (ServicioTuristico listaServicioNewServicioTuristico : listaServicioNew) {
                if (!listaServicioOld.contains(listaServicioNewServicioTuristico)) {
                    listaServicioNewServicioTuristico.getPaqueteTuristico().add(paqueteTuristico);
                    listaServicioNewServicioTuristico = em.merge(listaServicioNewServicioTuristico);
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
            List<ServicioTuristico> listaServicio = paqueteTuristico.getListaServicio();
            for (ServicioTuristico listaServicioServicioTuristico : listaServicio) {
                listaServicioServicioTuristico.getPaqueteTuristico().remove(paqueteTuristico);
                listaServicioServicioTuristico = em.merge(listaServicioServicioTuristico);
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
