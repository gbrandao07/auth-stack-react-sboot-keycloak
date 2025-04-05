package br.com.brandao.car.usecase.input.impl;

import br.com.brandao.car.usecase.gateway.CarsGateway;
import br.com.brandao.car.usecase.input.GetCarsInputBoundary;
import br.com.brandao.car.usecase.model.CarResponseModel;
import br.com.brandao.car.usecase.presenter.CarsPresenter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCarsInteractor implements GetCarsInputBoundary {

    private final CarsGateway carsGateway;
    private final CarsPresenter carsPresenter;

    @Override
    public List<CarResponseModel> execute() {
        try {
            List<CarResponseModel> carResponseModels = carsGateway.getAll();
            return carsPresenter.prepareSuccessView(carResponseModels);
        } catch (Exception e) {
            carsPresenter.prepareFailView("Ocorreu um erro interno ao obter os carros. Causa: " + e.getMessage());
        }
        return null;
    }
}
