package com.techinsights.cards.mapper;


import com.techinsights.cards.dto.CardDTO;
import com.techinsights.cards.entity.CardEntity;

public class CardMapper {
    public static CardDTO mapToCardsDto(CardEntity cardEntity, CardDTO cardsDto) {
        cardsDto.setCardNumber(cardEntity.getCardNumber());
        cardsDto.setCardType(cardEntity.getCardType());
        cardsDto.setMobileNumber(cardEntity.getMobileNumber());
        cardsDto.setTotalLimit(cardEntity.getTotalLimit());
        cardsDto.setAvailableAmount(cardEntity.getAvailableAmount());
        cardsDto.setAmountUsed(cardEntity.getAmountUsed());
        return cardsDto;
    }

    public static CardEntity mapToCards(CardDTO cardsDto, CardEntity cardEntity) {
        cardEntity.setCardNumber(cardsDto.getCardNumber());
        cardEntity.setCardType(cardsDto.getCardType());
        cardEntity.setMobileNumber(cardsDto.getMobileNumber());
        cardEntity.setTotalLimit(cardsDto.getTotalLimit());
        cardEntity.setAvailableAmount(cardsDto.getAvailableAmount());
        cardEntity.setAmountUsed(cardsDto.getAmountUsed());
        return cardEntity;
    }

}
