package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.model.response.BuyCarRequestEntity;
import com.example.capstoneprojectbe.service.BuyCarRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/buycarrequests")
public class BuyCarRequestController {

    private final BuyCarRequestService buyCarRequestService;


    @GetMapping("/{id}")
    private ResponseEntity getBuyCarByBuyCarID(@PathVariable String id) {
        BuyCarRequestEntity entity = buyCarRequestService.getBuyCarByBuyCarID(id);
        return ResponseEntity.ok().body(entity);
    }

    @GetMapping("/userid/{id}")
    private ResponseEntity getBuyCarByUserID(@PathVariable String id){
        List<BuyCarRequestEntity> entity = buyCarRequestService.getBuyCarByUserID(id);
        return ResponseEntity.ok().body(entity);
    }

    @GetMapping("/showroomid/{id}")
    private ResponseEntity getCarByShowroomID(@PathVariable String id){
        List<BuyCarRequestEntity> entity = buyCarRequestService.getBuyCarByShowroomID(id);
        return ResponseEntity.ok().body(entity);
    }

    @GetMapping("/carid/{id}")
    private ResponseEntity getBuyCarByCarID(@PathVariable String id){
        List<BuyCarRequestEntity> entity = buyCarRequestService.getBuyCarByCarID(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping()
    public ResponseEntity createNewBuyCarRequest(@RequestBody BuyCarRequestEntity entity) {
        if(buyCarRequestService.isExisted(entity.getBuyCarID())){
            return ResponseEntity.badRequest().body("Buy Car Id is duplicated");
        }
        return ResponseEntity.ok().body(buyCarRequestService.createNewBuyCarRequest(entity));
    }

    @PutMapping
    private ResponseEntity updateExistedBuyCarRequest(@RequestBody BuyCarRequestEntity entity) {
        return ResponseEntity.ok().body(buyCarRequestService.updateExistedBuyCarRequest(entity));
    }

    @DeleteMapping()
    private ResponseEntity deleteExistedBuyCarRequest(@RequestParam String id) {
        return ResponseEntity.ok().body(buyCarRequestService.deleteExistedBuyCarRequest(id));
    }
}
