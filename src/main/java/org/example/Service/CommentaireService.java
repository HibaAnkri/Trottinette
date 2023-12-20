package org.example.Service;

import org.example.Repository.CommentaireRepository;
import org.example.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService {
    @Autowired
    public CommentaireRepository commentaireRepository;
}
