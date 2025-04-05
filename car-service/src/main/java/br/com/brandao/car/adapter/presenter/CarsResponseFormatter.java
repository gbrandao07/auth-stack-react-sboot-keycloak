package br.com.brandao.car.adapter.presenter;

import br.com.brandao.car.usecase.exception.BusinessException;
import br.com.brandao.car.usecase.model.CarResponseModel;
import br.com.brandao.car.usecase.presenter.CarsPresenter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarsResponseFormatter implements CarsPresenter {

    @Override
    public List<CarResponseModel> prepareSuccessView(List<CarResponseModel> carResponseModels) {
        return carResponseModels;
    }

    @Override
    public Integer prepareSuccessView(Integer createdId) {
        return createdId;
    }

    @Override
    public void prepareFailView(String error) {
        throw new BusinessException(error);
    }
}