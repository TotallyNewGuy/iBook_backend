package com.project.iBook.controller;


import com.project.iBook.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class ErrorHandlerController {

    @GetMapping
    public Result purchaseFail() {
        return Result.fail(404, "Request uri is invalid");
    }
}