package com.turing.cardmanager.service;

import java.util.List;

import com.turing.cardmanager.CardPage;
import com.turing.cardmanager.entity.CardType;

public interface ICardService {

	List<CardType> queryAll(CardPage page);

}
