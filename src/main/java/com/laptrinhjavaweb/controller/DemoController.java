package com.laptrinhjavaweb.controller;

import com.google.gson.Gson;
import com.laptrinhjavaweb.server.CountryServer;
import com.laptrinhjavaweb.server.StateServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private CountryServer countryServer;

    @Autowired
    private StateServer stateServer;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        return new ModelAndView("demo/index", "countries", countryServer.findAll());
    }

        @RequestMapping(value = "loadStates/{id}", method = RequestMethod.GET)
        @ResponseBody
    public String loadState(@PathVariable("id") Integer id) {
        Gson gSon = new Gson();
        return gSon.toJson(stateServer.findByCountry(id));


    }

}
