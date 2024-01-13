package my.emasjid.ajkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import my.emasjid.ajkapi.entity.Ajk;

public interface AjkRepository extends JpaRepository<Ajk, Long> {
    
}

