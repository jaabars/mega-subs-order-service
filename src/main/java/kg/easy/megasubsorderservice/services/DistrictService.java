package kg.easy.megasubsorderservice.services;

import kg.easy.megasubsorderservice.models.dto.DistrictDto;

public interface DistrictService {
    DistrictDto findById(Long id);
}
