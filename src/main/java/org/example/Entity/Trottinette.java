package org.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trottinette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrottinette;
    private String marque;
    private String Modele;
    private int vitesse;
    private  int tempscharge;
    private boolean disponibilite;
    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "trottinettes")
    private Set<User> users = new HashSet<>();


    public void setId(Long id) {
    }
}
