package com.hightecher.windo.energy.dto;

public record EnergyImpactResult(
        double dailyRevenueWon,
        double monthlyRevenueWon,
        double sixMonthRevenueWon,
        double yearlyRevenueWon,
        double fiveYearRevenueWon,
        double yearlyCo2SavedKg,
        double fiveYearCo2SavedKg
) {}
