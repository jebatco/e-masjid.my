package my.emasjid.ajkapi.controller;
import my.emasjid.ajkapi.entity.Ajk;
import my.emasjid.ajkapi.service.AjkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajk")
public class AjkController {

    @Autowired
    private  AjkService ajkService;

    @PostMapping("/new")
    public ResponseEntity<Ajk> createAjk(@RequestBody Ajk ajk) {
        Ajk createdAjk = ajkService.saveAjk(ajk);
        return new ResponseEntity<>(createdAjk, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ajk>> getAllAjks() {
        List<Ajk> ajkList = ajkService.getAllAjks();
        return new ResponseEntity<>(ajkList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ajk> getAjkById(@PathVariable Long id) {
        Ajk ajk = ajkService.getAjkById(id);
        if (ajk != null) {
            return new ResponseEntity<>(ajk, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ajk> updateAjk(@PathVariable Long id, @RequestBody Ajk updatedAjk) {
        try {
            Ajk updatedAjkResult = ajkService.updateAjk(id, updatedAjk);
            return new ResponseEntity<>(updatedAjkResult, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAjk(@PathVariable Long id) {
        ajkService.deleteAjk(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
