package com.fama.numtoenglish.translator.controllers;

import com.fama.numtoenglish.translator.utilities.TranslatorUtilities;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TranslatorController {

    @RequestMapping(value = "/num_to_english", method = RequestMethod.GET, produces = "application/json")
    public Map<String, String> translate(@RequestParam Map<String, String> inputObject) {
        Map<String, String> translatedObject = new HashMap<>();

        if (!inputObject.containsKey("number")) {
            translatedObject.put("status", "no number specified");
        } else {
            String number = inputObject.get("number");
            if (number.isEmpty()) {
                translatedObject.put("status", "no number specified");
            } else if (!number.matches("^-?[0-9]+(.[0-9]+)?$")) {
                translatedObject.put("status", "not a number");
            } else if (number.length() > 66) {
                translatedObject.put("status", "number too large");
            } else {
                translatedObject.put("status", "ok");
                translatedObject.put("num_in_english", TranslatorUtilities.translateNumberToName(number));
            }
        }

        return translatedObject;
    }

}
