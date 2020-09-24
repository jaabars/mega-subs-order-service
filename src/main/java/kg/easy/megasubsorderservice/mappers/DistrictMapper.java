package kg.easy.megasubsorderservice.mappers;

import kg.easy.megasubsorderservice.models.District;
import kg.easy.megasubsorderservice.models.dto.DistrictDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    District toDistrict(DistrictDto districtDto);
    DistrictDto toDistrictDto(District district);
}
