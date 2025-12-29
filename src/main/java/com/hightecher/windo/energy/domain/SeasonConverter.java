package com.hightecher.windo.energy.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SeasonConverter implements AttributeConverter<Season, String> {

    @Override
    public String convertToDatabaseColumn(Season season) {
        return season == null ? null : season.getKorean();
    }

    @Override
    public Season convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Season.fromKorean(dbData);
    }
}
