package com.home.automation.ws.service;

import com.home.automation.ws.model.CardEnum;
import com.home.automation.ws.model.ResultResponse;

/**
 * Created by Nelson Levert on 2/20/17.
 */
public interface PlayService {
	ResultResponse play(String name, CardEnum userCardEnum);
}
