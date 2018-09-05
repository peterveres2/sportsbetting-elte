package com.epam.training.sportsbetting.service;

import java.lang.reflect.Type;

import com.epam.training.sportsbetting.domain.Wager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class WagerSerializer implements JsonSerializer<Wager> {

    public JsonElement serialize(Wager wager, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject wagerJson = new JsonObject();
        wagerJson.addProperty("id", wager.getId());
        wagerJson.addProperty("eventTitle", wager.getEventTitle());
        wagerJson.addProperty("eventType", wager.getEventType());
        wagerJson.addProperty("betType", wager.getBetType());
        wagerJson.addProperty("betDescription", wager.getBetDescription());
        wagerJson.addProperty("outcomeValue", wager.getOutcomeOdd().getOutcomeValue());
        wagerJson.addProperty("oddValue", wager.getOddValue());
        wagerJson.addProperty("amount", wager.getAmount());
        wagerJson.addProperty("currency", wager.getCurrency().toString());
        wagerJson.addProperty("winner", wager.isWinner());
        wagerJson.addProperty("processed", wager.isProcessed());
        return wagerJson;
    }
}
