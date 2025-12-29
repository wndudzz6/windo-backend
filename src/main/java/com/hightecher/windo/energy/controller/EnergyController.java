package com.hightecher.windo.energy.controller;

import com.hightecher.windo.energy.domain.Season;
import com.hightecher.windo.energy.dto.EnergyImpactResult;
import com.hightecher.windo.energy.dto.TurbineScaleRequest;
import com.hightecher.windo.energy.service.EnergyImpactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/energy")
public class EnergyController {

    private final EnergyImpactService energyImpactService;

    @GetMapping("/{linkId}/impact")
    public EnergyImpactResult getImpact(@PathVariable String linkId) {
        return energyImpactService.calculateImpact(linkId);
    }

    @GetMapping("/{linkId}/impact/season")
    public EnergyImpactResult getSeasonImpact(
            @PathVariable String linkId,
            @RequestParam Season season
    ) {
        return energyImpactService.calculateSeasonImpact(linkId, season);
    }

    @PostMapping("/{linkId}/impact/scale")
    public EnergyImpactResult getScaledImpact(
            @PathVariable String linkId,
            @RequestBody TurbineScaleRequest request
    ) {
        return energyImpactService.calculateScaledImpact(
                linkId,
                request.turbineCount()
        );
    }
}

