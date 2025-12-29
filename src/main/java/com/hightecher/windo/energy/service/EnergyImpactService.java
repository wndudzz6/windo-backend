package com.hightecher.windo.energy.service;

import com.hightecher.windo.energy.domain.RoadEnergyForecast;
import com.hightecher.windo.energy.dto.EnergyImpactResult;
import com.hightecher.windo.energy.repository.RoadEnergyForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnergyImpactService {

    private static final double PRICE_PER_KWH = 93.19725;
    private static final double CO2_PER_KWH = 0.466;

    private final RoadEnergyForecastRepository repository;

    public EnergyImpactResult calculateImpact(String linkId) {

        List<RoadEnergyForecast> list =
                repository.findByLinkId(linkId);

        double dailyKwh = list.stream()
                .mapToDouble(f -> f.getEKwh() * 3)
                .sum();

        double dailyRevenue = dailyKwh * PRICE_PER_KWH;
        double yearlyRevenue = dailyRevenue * 365;

        double yearlyCo2Kg = dailyKwh * CO2_PER_KWH * 365;

        return new EnergyImpactResult(
                dailyRevenue,
                dailyRevenue * 30,
                dailyRevenue * 30 * 6,
                yearlyRevenue,
                yearlyRevenue * 5,
                yearlyCo2Kg,
                yearlyCo2Kg * 5
        );
    }

    public EnergyImpactResult calculateSeasonImpact(
            String linkId,
            String season
    ) {

        List<RoadEnergyForecast> list =
                repository.findByLinkIdAndSeason(linkId, season);

        // 하루 발전량
        double dailyKwh = list.stream()
                .mapToDouble(f -> f.getEKwh() * 3)
                .sum();

        // 계절 = 90일
        double seasonalKwh = dailyKwh * 90;

        double seasonalRevenue = seasonalKwh * PRICE_PER_KWH;
        double seasonalCo2Kg = seasonalKwh * CO2_PER_KWH;

        return new EnergyImpactResult(
                dailyKwh * PRICE_PER_KWH,          // 하루
                seasonalRevenue / 3,               // 월 평균 (선택)
                seasonalRevenue,                   // 3개월
                seasonalRevenue * 4,               // 1년 환산
                seasonalRevenue * 4 * 5,           // 5년 환산
                seasonalCo2Kg * 4,                 // 연 CO2
                seasonalCo2Kg * 4 * 5              // 5년 CO2
        );
    }

    public EnergyImpactResult calculateScaledImpact(
            String linkId,
            int turbineCount
    ) {
        if (turbineCount <= 0) {
            throw new IllegalArgumentException("터빈 개수는 1 이상이어야 합니다.");
        }

        EnergyImpactResult base = calculateImpact(linkId);

        return new EnergyImpactResult(
                base.dailyRevenueWon() * turbineCount,
                base.monthlyRevenueWon() * turbineCount,
                base.sixMonthRevenueWon() * turbineCount,
                base.yearlyRevenueWon() * turbineCount,
                base.fiveYearRevenueWon() * turbineCount,
                base.yearlyCo2SavedKg() * turbineCount,
                base.fiveYearCo2SavedKg() * turbineCount
        );
    }


}
