package br.com.brandao.car.adapter.mapper;

import br.com.brandao.car.adapter.entrypoint.dto.CarRequestDto;
import br.com.brandao.car.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICarMapper {

    default Car carRequestDtoToCar(CarRequestDto requestDto) {
        return new Car(null, requestDto.name(), requestDto.year());
    }
}
