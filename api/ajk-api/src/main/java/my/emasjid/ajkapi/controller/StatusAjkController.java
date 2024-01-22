package my.emasjid.ajkapi.controller;
import my.emasjid.ajkapi.entity.StatusAjk;
import my.emasjid.ajkapi.service.StatusAjkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statusajk")
public class StatusAjkController {

    private StatusAjkService statusAjkService;

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<StatusAjk> createStatusAjk(@RequestBody StatusAjk statusAjk) {
        StatusAjk createdStatusAjk = statusAjkService.saveStatusAjk(statusAjk);
        return new ResponseEntity<>(createdStatusAjk, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<StatusAjk>> getAllStatusAjks() {
        List<StatusAjk> statusAjkList = statusAjkService.getAllStatusAjks();
        return new ResponseEntity<>(statusAjkList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<StatusAjk> getStatusAjkById(@PathVariable Long id) {
        StatusAjk statusAjk = statusAjkService.getStatusAjkById(id);
        if (statusAjk != null) {
            return new ResponseEntity<>(statusAjk, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<StatusAjk> updateStatusAjk(@PathVariable Long id, @RequestBody StatusAjk updatedStatusAjk) {
        try {
            StatusAjk updatedAjk = statusAjkService.updateStatusAjk(id, updatedStatusAjk);
            return new ResponseEntity<>(updatedAjk, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatusAjk(@PathVariable Long id) {
        statusAjkService.deleteStatusAjk(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
