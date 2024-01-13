package my.emasjid.ajkapi.service;

import my.emasjid.ajkapi.entity.Jawatan;
import my.emasjid.ajkapi.repository.JawatanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JawatanService {

    @Autowired
    private JawatanRepository jawatanRepository;
   
    public Jawatan saveJawatan(Jawatan jawatan) {
        return jawatanRepository.save(jawatan);
    }

    public List<Jawatan> getAllJawatan() {
        return jawatanRepository.findAll();
    }
  
    public Jawatan getJawatanById(Long id) {
        Optional<Jawatan> optionalJawatan = jawatanRepository.findById(id);
        return optionalJawatan.orElse(null);
    }

    public void deleteJawatanById(Long id) {
        jawatanRepository.deleteById(id);
    }
}

