package fr.lernejo.prediction;

import java.util.List;

public record PredictionTempList(String country, List<prediction> temperatures) {
    public record prediction(String date, double temperature) {
    }
}

