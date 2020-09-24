package kg.easy.megasubsorderservice.services.impl;

import kg.easy.megasubsorderservice.dao.DistrictRep;
import kg.easy.megasubsorderservice.mappers.DistrictMapper;
import kg.easy.megasubsorderservice.models.dto.DistrictDto;
import kg.easy.megasubsorderservice.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRep districtRep;

    @Override
    public DistrictDto findById(Long id) {

        return DistrictMapper.INSTANCE.toDistrictDto(districtRep.findDistrictById(id));
    }
}
