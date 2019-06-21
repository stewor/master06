package pl.stew.themstew.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Czas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Override
    public String toString() {
        return "Czas{" +
                "Id=" + Id +
                ", date=" + date +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Czas() {
    }

    public Czas(Date date) {
        this.date = date;
    }

}
