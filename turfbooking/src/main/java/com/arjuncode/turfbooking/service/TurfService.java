package com.arjuncode.turfbooking.service;

import com.arjuncode.turfbooking.dto.TurfRequestDTO;
import com.arjuncode.turfbooking.dto.TurfResponseDTO;

import java.util.List;

public interface TurfService {
    TurfResponseDTO createTurf(TurfRequestDTO request);

    TurfResponseDTO getTurfById(Long id);

    List<TurfResponseDTO> getAllTurfs();

    TurfResponseDTO updateTurf(Long id, TurfRequestDTO request);

    void deleteTurf(Long id);
}
