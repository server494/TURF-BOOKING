package com.arjuncode.turfbooking.controller;

import com.arjuncode.turfbooking.dto.TurfRequestDTO;
import com.arjuncode.turfbooking.dto.TurfResponseDTO;
import com.arjuncode.turfbooking.service.TurfService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turfs")
public class TurfController {

    private final TurfService turfService;

    public TurfController(TurfService turfService) {
        this.turfService = turfService;
    }

    // CREATE
    @PostMapping
    public TurfResponseDTO createTurf(@RequestBody TurfRequestDTO request) {
        return turfService.createTurf(request);
    }

    // READ (by id)
    @GetMapping("/{id}")
    public TurfResponseDTO getTurfById(@PathVariable Long id) {
        return turfService.getTurfById(id);
    }

    // READ (all)
    @GetMapping
    public List<TurfResponseDTO> getAllTurfs() {
        return turfService.getAllTurfs();
    }

    // UPDATE
    @PutMapping("/{id}")
    public TurfResponseDTO updateTurf(
            @PathVariable Long id,
            @RequestBody TurfRequestDTO request) {
        return turfService.updateTurf(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteTurf(@PathVariable Long id) {
        turfService.deleteTurf(id);
    }
}

