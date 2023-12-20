package org.example.Controller;

import org.example.Entity.Trottinette;
import org.example.Entity.User;
import org.example.Service.TrottinetteService;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/Trottinette")
public class TrottinetteController {
    @Autowired
    private TrottinetteService trottinetteService;

    @PostMapping("/Addtro")
    public ResponseEntity<Trottinette> createtro(@RequestBody Trottinette trottinette) {
        Trottinette createtro = trottinetteService.createTrottinette(trottinette);
        return ResponseEntity.status(HttpStatus.CREATED).body(createtro);
    }

    @GetMapping("GetTrottinette")
    public  ResponseEntity<List<Trottinette>>getAllTrottinette(){
        List<Trottinette>trottinettes =trottinetteService.getAllTrottinette();
        return  ResponseEntity.ok(trottinettes);
    }
    @DeleteMapping("/{idTrottinette}")
    public  ResponseEntity<Trottinette>deleteTro(@PathVariable Long idTrottinette){
        trottinetteService.deletetrottinette(idTrottinette);
        return  ResponseEntity.noContent().build();
    }
    @PutMapping("/{idTrottinette}")
    public ResponseEntity<Trottinette> updateTro(
            @PathVariable Long idTrottinette,
            @RequestBody Trottinette trottinetteModifiee) {

        Trottinette updatedTro = trottinetteService.updateTrottinette(idTrottinette, trottinetteModifiee);

        if (updatedTro != null) {
            return ResponseEntity.ok(updatedTro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{idTrottinette}")
    public ResponseEntity<Trottinette> getTrottinetteById(@PathVariable Long idTrottinette) {
        Trottinette trottinette = trottinetteService.findTrottinetteById(idTrottinette);

        if (trottinette != null) {
            return ResponseEntity.ok(trottinette);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

