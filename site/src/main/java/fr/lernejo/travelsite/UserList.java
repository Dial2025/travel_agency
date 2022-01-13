package fr.lernejo.travelsite;

public record UserList(String userEmail, String userName, String userCountry,
                       String weatherExpectation, Integer minimumTemperatureDistance) {
}
