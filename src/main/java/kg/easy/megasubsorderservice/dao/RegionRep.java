package kg.easy.megasubsorderservice.dao;

import kg.easy.megasubsorderservice.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRep extends JpaRepository<Region,Long> {
    Region findRegionById(Long id);
}
