package br.com.brandao.car.usecase.presenter;

import br.com.brandao.car.usecase.model.CarResponseModel;

import java.util.List;

public interface CarsPresenter {

    List<CarResponseModel> prepareSuccessView(List<CarResponseModel> carResponseModels);

    Integer prepareSuccessView(Integer createdId);

    void prepareFailView(String error);
}