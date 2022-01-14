package fr.lernejo.prediction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;

    @RestController
    public class PredictionController {

        public final ArrayList<PredictionTempList.prediction> listPredictionTempList = new ArrayList<PredictionTempList.prediction>();
        final TemperatureService service = new TemperatureService();

        @RequestMapping(value = ("/api/temperature"),  method=RequestMethod.GET)
        public Object getPredictTemperature(@RequestParam String country) {

            try {
                listPredictionTempList.add(new PredictionTempList.prediction(LocalDate.now().minusDays(1).toString(), service.getTemperature(country)));
                listPredictionTempList.add(new PredictionTempList.prediction(LocalDate.now().minusDays(2).toString(), service.getTemperature(country)));
            } catch(UnknownCountryException e) {
                return ResponseEntity.status(417).body("Unknown Country : " + country);
            }
                return this.listPredictionTempList;
        }
}
