package my.emasjid.ajkapi.service;
import my.emasjid.ajkapi.entity.Ajk;
import my.emasjid.ajkapi.repository.AjkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AjkService {

    @Autowired
    private AjkRepository ajkRepository;

   
    public Ajk saveAjk(Ajk ajk) {
        if(ajk != null){
            return ajkRepository.save(ajk);
        } else {
            return null;
        }
        
    }

    
    public List<Ajk> getAllAjks() {
        return ajkRepository.findAll();
    }

  
    public Ajk getAjkById(Long id) {
        if(id!=null){            
            Optional<Ajk> optionalAjk = ajkRepository.findById(id);
            return optionalAjk.orElse(null);
        } else {
            return null;
        }
    }

    
    public Ajk updateAjk(Long id, Ajk updatedAjk) {
        if(id==null)return null;
        
        Optional<Ajk> optionalAjk = ajkRepository.findById(id);
        if (optionalAjk.isPresent()) {
            Ajk existingAjk = optionalAjk.get();
            existingAjk.setPenggal(updatedAjk.getPenggal());
            existingAjk.setJawatan(updatedAjk.getJawatan());
            existingAjk.setNama(updatedAjk.getNama());
            existingAjk.setTarikhMula(updatedAjk.getTarikhMula());
            existingAjk.setTarikhTamat(updatedAjk.getTarikhTamat());
            existingAjk.setStatusAjk(updatedAjk.getStatusAjk());
            existingAjk.setCreateDate(updatedAjk.getCreateDate());
            return ajkRepository.save(existingAjk);
        } else {
            throw new RuntimeException("Ajk not found with id: " + id);
        }
    }

    
    public void deleteAjk(Long id) {
        if(id!=null)ajkRepository.deleteById(id);
    }
}
