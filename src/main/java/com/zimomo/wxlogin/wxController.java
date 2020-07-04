package com.zimomo.wxlogin;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class wxController {

    @Autowired
    wxService wxService;

    @RequestMapping("/getOpenid")
    @ResponseBody
    public String getOpenid(String code){
        return wxService.getOpenid(code);
    }

    @RequestMapping("/getQRcode")
    @ResponseBody
    public String getQRcode() throws WriterException, IOException {
        return wxService.getQRcode();
    }
}
