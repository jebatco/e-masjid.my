package my.emasjid.ajkapi.controller;

import my.emasjid.ajkapi.entity.Jawatan;
import my.emasjid.ajkapi.service.JawatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${deploy.url}")
public class JawatanController {

    @Autowired
    private JawatanService jawatanService;

    // Create a new Jawatan
    @PostMapping("/jawatan/new")
    @ResponseBody
    public ResponseEntity<Jawatan> createJawatan(@RequestBody Jawatan jawatan) {
        Jawatan createdJawatan = jawatanService.saveJawatan(jawatan);
        return new ResponseEntity<>(createdJawatan, HttpStatus.CREATED);
    }

    // Read all Jawatan
    @GetMapping("/jawatan/all")
    @ResponseBody
    public ResponseEntity<List<Jawatan>> getAllJawatan() {
        List<Jawatan> jawatanList = jawatanService.getAllJawatan();
        return new ResponseEntity<>(jawatanList, HttpStatus.OK);
    }

    // Read one Jawatan by ID
    @GetMapping("/jawatan/{id}")
    @ResponseBody
    public ResponseEntity<Jawatan> getJawatanById(@PathVariable Long id) {
        Jawatan jawatan = jawatanService.getJawatanById(id);
        if (jawatan != null) {
            return new ResponseEntity<>(jawatan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing Jawatan
    @PutMapping("/jawatan/{id}")
    @ResponseBody
    public ResponseEntity<Jawatan> updateJawatan(@PathVariable Long id, @RequestBody Jawatan updatedJawatan) {
        Jawatan jawatan = jawatanService.getJawatanById(id);
        if (jawatan != null) {
            updatedJawatan.setId(id);
            Jawatan savedJawatan = jawatanService.saveJawatan(updatedJawatan);
            return new ResponseEntity<>(savedJawatan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a Jawatan by ID
    @DeleteMapping("/jawatan/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteJawatan(@PathVariable Long id) {
        jawatanService.deleteJawatanById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
