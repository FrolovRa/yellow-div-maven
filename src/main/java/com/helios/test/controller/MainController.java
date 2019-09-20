package com.helios.test.controller;

import com.helios.test.model.Constant;
import com.helios.test.model.Response;
import com.helios.test.repository.ConstantRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.NoSuchElementException;

@RestController
public class MainController {

    private final ConstantRepository repository;

    MainController(ConstantRepository repository){
        this.repository = repository;
    }

    @PostMapping("/compute")
    public Response doTheMath(@RequestParam("operation") String operation,
                              @RequestParam("digitOne") int digitOne,
                              @RequestParam("digitTwo") int digitTwo) {
        Response response;
        int count;
        int dbConstant;

        Iterator<Constant> i = repository.findAll().iterator();

        if (i.hasNext()){
            dbConstant = i.next().getNumber();
        } else {
            throw new NoSuchElementException();
        }

        switch (operation) {
            case "plus":
                count = digitOne + digitTwo + dbConstant;
                response = new Response(count, "green");
                break;
            case "minus":
                count = digitOne - digitTwo + dbConstant;
                response = new Response(count, "red");
                break;
            default:
                throw new IllegalArgumentException();
        }
        return response;
    }
}
