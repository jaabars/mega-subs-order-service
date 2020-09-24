package kg.easy.megasubsorderservice.dao;

import kg.easy.megasubsorderservice.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRep extends JpaRepository<District,Long> {

    District findDistrictById(Long id);
}
