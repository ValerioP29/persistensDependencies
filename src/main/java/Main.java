import com.github.javafaker.Faker;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EventoDAO eventoDAO = new EventoDAO();
        Faker faker = new Faker();



        // Crea e salva 10 eventi finti usando JavaFaker
        for (int i = 0; i < 10; i++) {
            Evento evento = new Evento(
                    faker.book().title(),                             // Titolo dell'evento (finto)
                    LocalDate.of(faker.number().numberBetween(2024, 2025), // Data evento (anno finto)
                            faker.number().numberBetween(1, 12), // Mese finto
                            faker.number().numberBetween(1, 28)),  // Giorno finto
                    faker.lorem().sentence(),                        // Descrizione finta
                    faker.options().option(Evento.TipoEvento.values()), // Tipo evento (pubblico o privato)
                    faker.number().numberBetween(50, 500)            // Numero massimo di partecipanti (finto)
            );

            eventoDAO.save(evento);  // Salva l'evento nel database
        }

        System.out.println("Eventi inseriti con successo.");
    }
}
