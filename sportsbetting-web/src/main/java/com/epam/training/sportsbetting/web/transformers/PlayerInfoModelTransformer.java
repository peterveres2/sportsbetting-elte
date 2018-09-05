package com.epam.training.sportsbetting.web.transformers;

import java.math.BigInteger;
import java.util.List;

import com.epam.training.sportsbetting.domain.Player;
import com.epam.training.sportsbetting.domain.SportEvent;
import com.epam.training.sportsbetting.domain.Wager;
import com.epam.training.sportsbetting.web.models.PlayerInfoModel;

public class PlayerInfoModelTransformer {
    public PlayerInfoModel transform(Player player, List<Wager> wagers, SportEvent event) {
        PlayerInfoModel playerInfo = new PlayerInfoModel();
        playerInfo.setUserName(player.getUserName());
        playerInfo.setName(player.getName());
        playerInfo.setAccountNumber(player.getAccountNumber());
        playerInfo.setBalance(player.getBalance());
        playerInfo.setCurrency(player.getCurrency().toString());
        playerInfo.setDateOfBirth(player.getDateOfBirth().toString());
        PlayerInfoModel.SportEvents sportEvents = new PlayerInfoModel.SportEvents();
        playerInfo.setSportEvents(sportEvents);
        PlayerInfoModel.SportEvents.SportEvent sportEvent = new PlayerInfoModel.SportEvents.SportEvent();
        sportEvents.setSportEvent(sportEvent);
        PlayerInfoModel.SportEvents.SportEvent.Wagers XMLwagersList = new PlayerInfoModel.SportEvents.SportEvent.Wagers();
        sportEvent.setWagers(XMLwagersList);

        for (Wager wager : wagers) {
            PlayerInfoModel.SportEvents.SportEvent.Wagers.Wager currentXmlWager = new PlayerInfoModel.SportEvents.SportEvent.Wagers.Wager();
            currentXmlWager.setBetType(event.getClass().getSimpleName());
            currentXmlWager.setBetDescription(event.getTitle());
            currentXmlWager.setOutcomeValue(wager.getOutcomeOdd().getOutcomeValue());
            currentXmlWager.setAmount(BigInteger.valueOf(wager.getAmount()));
            currentXmlWager.setCurrency(wager.getCurrency().toString());
            currentXmlWager.setOdd(wager.getOddValue());
            currentXmlWager.setWin(wager.isWinner());
            currentXmlWager.setDate(wager.getTimestamp().toString());
            XMLwagersList.getWager().add(currentXmlWager);
        }

        return playerInfo;
    }
}
