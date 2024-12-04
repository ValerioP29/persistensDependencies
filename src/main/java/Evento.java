import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter

@ToString
@Table (name = "evento")
public class Evento {

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String titolo;

    private LocalDate dataEvento;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    private int numeroMassimoPartecipanti;


    public enum TipoEvento {
        PUBBLICO,
        PRIVATO
    }
}
