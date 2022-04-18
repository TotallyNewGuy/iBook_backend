package com.project.iBook.service;

import com.project.iBook.vo.Result;

public interface PaypalService {
    Result checkout(double price);
}
