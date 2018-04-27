package com.home.automation.ws.service;

import com.home.automation.ws.model.CardEnum;
import com.home.automation.ws.model.ResultEnum;
import com.home.automation.ws.model.ResultResponse;
import com.home.automation.ws.model.User;
import com.home.automation.ws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nelson Levert on 2/20/17.
 */
@Service
@Transactional
public class PlayServiceImpl implements PlayService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public ResultResponse play(String name, CardEnum userCardEnum) {
		// random opponent card
		CardEnum opponentCardEnum = CardEnum.getRandomCard();

		User user = userRepository.findOne(name);
		if (user == null) {
			user = new User();
			user.setName(name);
		}

		ResultEnum resultEnum = getResult(user, userCardEnum, opponentCardEnum);
		userRepository.save(user);
		return new ResultResponse(user, opponentCardEnum, resultEnum);
	}

	private ResultEnum getResult(User user, CardEnum userCardEnum, CardEnum opponentCardEnum) {
		if (userCardEnum.isWin(opponentCardEnum)) {
			return ResultEnum.WIN.update(user);
		} else if (userCardEnum.isLost(opponentCardEnum)) {
			return ResultEnum.LOST.update(user);
		} else  {
			return ResultEnum.DRAW.update(user);
		}
	}
}
