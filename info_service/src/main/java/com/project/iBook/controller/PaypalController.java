package com.project.iBook.controller;


import com.project.iBook.service.PaypalService;
import com.project.iBook.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@RequestMapping(value = "/pay", method = RequestMethod.POST)
@CrossOrigin
public class PaypalController {

    @Autowired
    PaypalService paypalService;

    @PostMapping("/{price}")
    public Result paypal(@PathVariable("price") String price) {
        String p = price.replace('P', '.');
        double realPrice = Double.parseDouble(p);
        return paypalService.checkout(realPrice);
    }

    @PostMapping("/successful")
    public void checkoutCompleted(HttpServletRequest request) {
        // 获取参数名称
        Enumeration<String> requestParams = request.getParameterNames();
        // 遍历获取参数
        while (requestParams.hasMoreElements()) {
            String param = requestParams.nextElement();
            String value = request.getParameter(param);
            System.out.println("ipn回调-----" + param + ":"+value);
        }
    }
}
