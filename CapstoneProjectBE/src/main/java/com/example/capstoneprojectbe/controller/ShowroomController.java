package com.example.capstoneprojectbe.controller;

import com.example.capstoneprojectbe.model.response.RoleEntity;
import com.example.capstoneprojectbe.model.response.ShowroomEntity;
import com.example.capstoneprojectbe.service.RoleService;
import com.example.capstoneprojectbe.service.ShowroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/showrooms")
public class ShowroomController {


    private final ShowroomService showroomService;


    @GetMapping("/{id}")
    private ResponseEntity getShowroomByShowroomID(@PathVariable String id) {
        ShowroomEntity entity = showroomService.getShowroomByShowroomID(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping()
    public ResponseEntity createNewShowroom(@RequestBody ShowroomEntity entity) {
        if(showroomService.isExisted(entity.getShowroomID())){
            return ResponseEntity.badRequest().body("Showroom Id is duplicated");
        }
        return ResponseEntity.ok().body(showroomService.createNewShowroom(entity));
    }

    @PutMapping
    private ResponseEntity updateExistedShowroom(@RequestBody ShowroomEntity entity) {
        return ResponseEntity.ok().body(showroomService.updateExistedShowroom(entity));
    }

    @DeleteMapping()
    private ResponseEntity deleteExistedShowroom(@RequestParam String id) {
        return ResponseEntity.ok().body(showroomService.deleteExistedShowroom(id));
    }
}
