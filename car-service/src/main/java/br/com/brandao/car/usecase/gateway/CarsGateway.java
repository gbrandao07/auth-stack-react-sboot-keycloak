package br.com.brandao.car.usecase.gateway;

import br.com.brandao.car.entity.Car;
import br.com.brandao.car.usecase.model.CarResponseModel;

import java.util.List;

public interface CarsGateway {

    Integer create(Car toCreate);

    List<CarResponseModel> getAll();
}
