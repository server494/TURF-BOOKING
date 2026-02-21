package com.arjuncode.turfbooking.service;

import com.arjuncode.turfbooking.dto.TurfRequestDTO;
import com.arjuncode.turfbooking.dto.TurfResponseDTO;
import com.arjuncode.turfbooking.entity.Turf;
import com.arjuncode.turfbooking.exception.ResourceNotFoundException;
import com.arjuncode.turfbooking.repo.TurfRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurfServiceImpl implements TurfService {

    private final TurfRepository turfRepository;

    public TurfServiceImpl(TurfRepository turfRepository) {
        this.turfRepository = turfRepository;
    }

    @Override
    public TurfResponseDTO createTurf(TurfRequestDTO request) {
        Turf turf = new Turf();
        turf.setTurfName(request.getTurfName());
        turf.setLocation(request.getLocation());
        turf.setPricePerHour(new BigDecimal(request.getPricePerHour()));

        Turf saved = turfRepository.save(turf);
        return mapToResponse(saved);
    }

    @Override
    public TurfResponseDTO getTurfById(Long id) {
        Turf turf = turfRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Turf not found with id: " + id)
                );
        return mapToResponse(turf);
    }

    @Override
    public List<TurfResponseDTO> getAllTurfs() {
        return turfRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TurfResponseDTO updateTurf(Long id, TurfRequestDTO request) {
        Turf turf = turfRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Turf not found with id: " + id)
                );

        turf.setTurfName(request.getTurfName());
        turf.setLocation(request.getLocation());
        turf.setPricePerHour(new BigDecimal(request.getPricePerHour()));

        Turf updated = turfRepository.save(turf);
        return mapToResponse(updated);
    }

    @Override
    public void deleteTurf(Long id) {
        Turf turf = turfRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Turf not found with id: " + id)
                );
        turfRepository.delete(turf);
    }

    private TurfResponseDTO mapToResponse(Turf turf) {
        TurfResponseDTO dto = new TurfResponseDTO();
        dto.setId(turf.getId());
        dto.setTurfName(turf.getTurfName());
        dto.setLocation(turf.getLocation());
        dto.setPricePerHour(turf.getPricePerHour());
        return dto;
    }
}