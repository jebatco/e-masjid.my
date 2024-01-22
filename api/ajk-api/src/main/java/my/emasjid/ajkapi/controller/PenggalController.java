package my.emasjid.ajkapi.controller;
import my.emasjid.ajkapi.entity.Penggal;
import my.emasjid.ajkapi.service.PenggalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/penggal")
public class PenggalController {

    @Autowired
    private PenggalService penggalService;

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<Penggal> createPenggal(@RequestBody Penggal penggal) {
        Penggal createdPenggal = penggalService.savePenggal(penggal);
        return new ResponseEntity<>(createdPenggal, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Penggal>> getAllPenggals() {
        List<Penggal> penggalList = penggalService.getAllPenggals();
        return new ResponseEntity<>(penggalList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Penggal> getPenggalById(@PathVariable Long id) {
        Penggal penggal = penggalService.getPenggalById(id);
        if (penggal != null) {
            return new ResponseEntity<>(penggal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Penggal> updatePenggal(@PathVariable Long id, @RequestBody Penggal updatedPenggal) {
        try {
            Penggal updatedPenggalResult = penggalService.updatePenggal(id, updatedPenggal);
            return new ResponseEntity<>(updatedPenggalResult, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> deletePenggal(@PathVariable Long id) {
        penggalService.deletePenggal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
