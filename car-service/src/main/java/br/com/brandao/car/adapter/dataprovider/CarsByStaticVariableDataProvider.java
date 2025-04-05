package br.com.brandao.car.adapter.dataprovider;

import br.com.brandao.car.entity.Car;
import br.com.brandao.car.usecase.gateway.CarsGateway;
import br.com.brandao.car.usecase.model.CarResponseModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsByStaticVariableDataProvider implements CarsGateway {

    private static final List<CarResponseModel> carsList = new ArrayList<>();

    @Override
    public Integer create(Car toCreate) {
        carsList.add(new CarResponseModel(carsList.size() + 1, toCreate.name(), toCreate.year()));
        return null;
    }

    @Override
    public List<CarResponseModel> getAll() {
        return carsList;
    }
}
