package br.com.brandao.car.usecase.input.impl;

import br.com.brandao.car.entity.Car;
import br.com.brandao.car.usecase.gateway.CarsGateway;
import br.com.brandao.car.usecase.input.CreateCarInputBoundary;
import br.com.brandao.car.usecase.presenter.CarsPresenter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCarInteractor implements CreateCarInputBoundary {

    private final CarsGateway carsGateway;
    private final CarsPresenter presenter;

    @Override
    public Integer execute(Car toCreate) {
        try {
           presenter.prepareSuccessView(carsGateway.create(toCreate));
        } catch(Exception e) {
            presenter.prepareFailView("Ocorreu um erro interno ao criar o carro: " + toCreate.name() + ". Causa: " + e.getMessage());
        }
        return null;
    }
}
