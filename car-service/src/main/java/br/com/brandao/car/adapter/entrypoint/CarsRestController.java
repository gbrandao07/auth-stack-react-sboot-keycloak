package br.com.brandao.car.adapter.entrypoint;

import br.com.brandao.car.adapter.entrypoint.dto.CarRequestDto;
import br.com.brandao.car.adapter.mapper.ICarMapper;
import br.com.brandao.car.usecase.input.CreateCarInputBoundary;
import br.com.brandao.car.usecase.input.GetCarsInputBoundary;
import br.com.brandao.car.usecase.model.CarResponseModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CarsRestController {

    private final GetCarsInputBoundary getCarsInputBoundary;
    private final CreateCarInputBoundary createCarInputBoundary;
    private final ICarMapper mapper;

    @GetMapping("/api/cars")
    @PreAuthorize("hasRole('get-operations')")
    @Operation(summary = "Get all cars",
            description = "Given valid payload, returns all cars",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Success"),
                    @ApiResponse(responseCode = "422", description = "When some business error occur"),
                    @ApiResponse(responseCode = "500", description = "When an internal error occur")
            })
    public ResponseEntity<List<CarResponseModel>> getAll() {
        List<CarResponseModel> carResponseModels = getCarsInputBoundary.execute();
        return new ResponseEntity<>(carResponseModels, HttpStatus.OK);
    }

    @PostMapping("/api/car")
    @PreAuthorize("hasRole('admin-operations')")
    @Operation(summary = "Create a car",
            description = "Given valid payload, create a new car",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Success"),
                    @ApiResponse(responseCode = "422", description = "When some business error occur"),
                    @ApiResponse(responseCode = "500", description = "When an internal error occur")
            })
    public ResponseEntity<Integer> create(@RequestBody CarRequestDto carDto) {
        Integer createdId = createCarInputBoundary.execute(mapper.carRequestDtoToCar(carDto));
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }
}
