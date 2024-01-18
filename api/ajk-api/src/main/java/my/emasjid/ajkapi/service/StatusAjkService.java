package my.emasjid.ajkapi.service;

import my.emasjid.ajkapi.entity.StatusAjk;
import my.emasjid.ajkapi.repository.StatusAjkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusAjkService {

    @Autowired
    private  StatusAjkRepository statusAjkRepository;

  
    public StatusAjk saveStatusAjk(StatusAjk statusAjk) {
        return statusAjkRepository.save(statusAjk);
    }

    
    public List<StatusAjk> getAllStatusAjks() {
        return statusAjkRepository.findAll();
    }

    
    public StatusAjk getStatusAjkById(Long id) {
        Optional<StatusAjk> optionalStatusAjk = statusAjkRepository.findById(id);
        return optionalStatusAjk.orElse(null);
    }

   
    public StatusAjk updateStatusAjk(Long id, StatusAjk updatedStatusAjk) {
        Optional<StatusAjk> optionalStatusAjk = statusAjkRepository.findById(id);
        if (optionalStatusAjk.isPresent()) {
            StatusAjk existingStatusAjk = optionalStatusAjk.get();
            existingStatusAjk.setNama(updatedStatusAjk.getNama());
            return statusAjkRepository.save(existingStatusAjk);
        } else {
            throw new RuntimeException("StatusAjk not found with id: " + id);
        }
    }

    
    public void deleteStatusAjk(Long id) {
        statusAjkRepository.deleteById(id);
    }
}


