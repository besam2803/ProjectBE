package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.model.response.CarBrandEntity;
import com.example.capstoneprojectbe.model.response.RoleEntity;
import com.example.capstoneprojectbe.service.CarBrandService;
import com.example.capstoneprojectbe.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/carbrands")
public class CarBrandController {

    private final CarBrandService carBrandService;
    @GetMapping
    private ResponseEntity getAllCarBrands() {
        List<CarBrandEntity> listEntity = carBrandService.getAllCarBrands();
        return ResponseEntity.ok().body(listEntity);
    }

    @GetMapping("/{id}")
    private ResponseEntity getCarBrandByCarBrandID(@PathVariable String id) {
        CarBrandEntity entity = carBrandService.getCarBrandByCarBrandID(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping()
    public ResponseEntity createNewCarBrand(@RequestBody CarBrandEntity entity) {
        if(carBrandService.isExisted(entity.getCarBrandID())){
            return ResponseEntity.badRequest().body("Car Brand Id is duplicated");
        }
        return ResponseEntity.ok().body(carBrandService.createNewCarBrand(entity));
    }

    @PutMapping
    private ResponseEntity updateExistedCarBrand(@RequestBody CarBrandEntity entity) {
        return ResponseEntity.ok().body(carBrandService.updateExistedCarBrand(entity));
    }

    @DeleteMapping()
    private ResponseEntity deleteExistedCarBrand(@RequestParam String id) {
        return ResponseEntity.ok().body(carBrandService.deleteExistedCarBrand(id));
    }
}
