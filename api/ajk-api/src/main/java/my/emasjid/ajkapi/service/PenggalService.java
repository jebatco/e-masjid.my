package my.emasjid.ajkapi.service;
import my.emasjid.ajkapi.entity.Penggal;
import my.emasjid.ajkapi.repository.PenggalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PenggalService {

    @Autowired
    private  PenggalRepository penggalRepository;


    public Penggal savePenggal(Penggal penggal) {
        return penggalRepository.save(penggal);
    }

    
    public List<Penggal> getAllPenggals() {
        return penggalRepository.findAll();
    }

    
    public Penggal getPenggalById(Long id) {
        Optional<Penggal> optionalPenggal = penggalRepository.findById(id);
        return optionalPenggal.orElse(null);
    }

    
    public Penggal updatePenggal(Long id, Penggal updatedPenggal) {
        Optional<Penggal> optionalPenggal = penggalRepository.findById(id);
        if (optionalPenggal.isPresent()) {
            Penggal existingPenggal = optionalPenggal.get();
            existingPenggal.setNama(updatedPenggal.getNama());
            existingPenggal.setTarikhMula(updatedPenggal.getTarikhMula());
            existingPenggal.setTarikhTamat(updatedPenggal.getTarikhTamat());
            existingPenggal.setFailMinitMesy(updatedPenggal.getFailMinitMesy());
            return penggalRepository.save(existingPenggal);
        } else {
            throw new RuntimeException("Penggal not found with id: " + id);
        }
    }

    
    public void deletePenggal(Long id) {
        penggalRepository.deleteById(id);
    }
}

