package br.com.brandao.car.usecase.input;

import br.com.brandao.car.entity.Car;

public interface CreateCarInputBoundary {

    Integer execute(Car toCreate);
}
