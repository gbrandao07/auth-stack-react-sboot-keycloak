package br.com.brandao.car.usecase.input;

import br.com.brandao.car.usecase.model.CarResponseModel;

import java.util.List;

public interface GetCarsInputBoundary {

    List<CarResponseModel> execute();
}
