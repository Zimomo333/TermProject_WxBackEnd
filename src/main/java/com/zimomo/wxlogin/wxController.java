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

    @RequestMapping("/wx/openid")
    @ResponseBody
    public String getOpenid(String code){
        return wxService.getOpenid(code);
    }

    @RequestMapping("/wx/qrcode")
    @ResponseBody
    public String getQRcode(String openid) throws WriterException, IOException {
        return wxService.getQRcode(openid);
    }

    @RequestMapping("/wx/info")
    @ResponseBody
    public String getInfo(String openid) {
        return wxService.getInfo(openid);
    }
}
