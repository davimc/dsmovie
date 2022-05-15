package com.devsuperior.dsmovie.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_score")
public class Score implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ScorePK id = new ScorePK();

    private Double value;

    public Score() {
    }

    public Score(ScorePK id, Double value) {
        this.id = id;
        this.value = value;
    }

    public ScorePK getId() {
        return id;
    }
    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }
    public void setUser(User user) {
        id.setUser(user);
    }
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
