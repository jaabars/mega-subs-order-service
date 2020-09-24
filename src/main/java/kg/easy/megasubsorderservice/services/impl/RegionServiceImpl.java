package kg.easy.megasubsorderservice.services.impl;

import kg.easy.megasubsorderservice.dao.RegionRep;
import kg.easy.megasubsorderservice.mappers.RegionMapper;
import kg.easy.megasubsorderservice.models.dto.RegionDto;
import kg.easy.megasubsorderservice.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRep regionRep;

    @Override
    public RegionDto findById(Long id) {
        return RegionMapper.INSTANCE.toRegionDto(regionRep.findRegionById(id));
    }
}
