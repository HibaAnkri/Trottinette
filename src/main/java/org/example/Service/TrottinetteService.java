package org.example.Service;

import jakarta.transaction.Transactional;
import org.example.Entity.Reservation;
import org.example.Entity.Trottinette;
import org.example.Entity.User;
import org.example.Repository.ReservationRepository;
import org.example.Repository.TrottinetteRepository;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrottinetteService {
    @Autowired
    public TrottinetteRepository trottinetteRepository;

    public Trottinette createTrottinette(Trottinette trottinette) {
        return trottinetteRepository.save(trottinette);
    }
    public Trottinette findTrottinetteById(Long idTrottinette){return  trottinetteRepository.findById(idTrottinette).orElse(null);}


    public List<Trottinette> getAllTrottinette() {
        return trottinetteRepository.findAll();
    }

    public void deletetrottinette(Long idTrottinette) {
        trottinetteRepository.deleteById(idTrottinette);
    }

    public Trottinette updateTrottinette(Long idTrottinette, Trottinette trottinetteModifiee) {
        if (trottinetteRepository.existsById(idTrottinette)) {
            trottinetteModifiee.setId(idTrottinette);
            return trottinetteRepository.save(trottinetteModifiee);
        } else {
            return null;
        }
    }
    @Autowired
    public  ReservationRepository reservationRepository;
    @Transactional
    public boolean siTrottinetteReserver(Long idTrottinette, Date dateDebut, Date dateFin) {
        Trottinette trottinette = trottinetteRepository.findById(idTrottinette).orElse(null);

        if (trottinette == null) {
            return false; // La trottinette n'existe pas
        }

        List<Reservation> reservations = reservationRepository.findByTrottinetteReser(trottinette, dateDebut, dateFin);

        return !reservations.isEmpty();
    }
}


