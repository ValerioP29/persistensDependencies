import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDAO {
    private EntityManagerFactory emf;

    public EventoDAO() {
        emf = Persistence.createEntityManagerFactory("gestioneEventi");
    }

    // Metodo per salvare un evento
    public void save(Evento evento) {
        // Usa try-with-resources per garantire che il EntityManager venga chiuso
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();  // Avvia la transazione
            em.persist(evento);  // Salva l'evento nel database
            em.getTransaction().commit();  // Commetti la transazione
        } catch (Exception e) {
            e.printStackTrace();
            // Gestione degli errori se la transazione fallisce
        }
    }

    // Metodo per ottenere un evento per ID
    public Evento getById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Evento.class, id);  // Restituisce l'evento per ID
        }
    }

    // Metodo per eliminare un evento
    public void delete(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();  // Inizia la transazione
            Evento evento = em.find(Evento.class, id);  // Trova l'evento da eliminare
            if (evento != null) {
                em.remove(evento);  // Elimina l'evento
            }
            em.getTransaction().commit();  // Commetti la transazione
        } catch (Exception e) {
            e.printStackTrace();
            // Gestione degli errori se la transazione fallisce
        }
    }
   // public void deleteAll() {
     //   try (EntityManager em = emf.createEntityManager()) {
   //         em.getTransaction().begin();
     //       em.createQuery("DELETE FROM Evento").executeUpdate(); // Elimina tutti gli eventi
       //     em.getTransaction().commit();
       // }
    //}


}
