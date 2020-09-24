package kg.easy.megasubsorderservice.mappers;

import kg.easy.megasubsorderservice.models.Region;
import kg.easy.megasubsorderservice.models.dto.RegionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    Region toRegion(RegionDto regionDto);
    RegionDto toRegionDto(Region region);
}
