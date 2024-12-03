import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDAO {
    private EntityManagerFactory emf;

    public EventoDAO () {
        emf = Persistence.createEntityManagerFactory("gestioneeventi");
    }

    public void save (Evento evento) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Evento getById (Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Evento.class, id);
        } finally {
            em.close();
        }
        }

        public void delete (Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        }
    }

