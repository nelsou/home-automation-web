package com.home.automation.ws;

import com.home.automation.ws.model.CardEnum;
import com.home.automation.ws.model.ResultResponse;
import com.home.automation.ws.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
public class HomeController {

    @Autowired
    private PlayService playService;

    @RequestMapping("/")
    public String index() throws IOException, InterruptedException {
        HomeController.run("ls");
        return "Made with <3";
    }

    @RequestMapping("/play/{name}")
    public ResultResponse play(@PathVariable String name, @RequestParam String cardName) {
        return playService.play(name, CardEnum.valueOf(cardName));
    }

    public static void run(String... args) throws java.io.IOException, java.lang.InterruptedException {
        java.lang.Runtime rt = java.lang.Runtime.getRuntime();
        java.lang.Process p = rt.exec(args[0]);
        p.waitFor();

        try (InputStream is = p.getInputStream();
             BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(is))) {
            String s = null;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}