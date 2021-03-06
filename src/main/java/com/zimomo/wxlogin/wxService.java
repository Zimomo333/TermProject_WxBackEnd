package com.zimomo.wxlogin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;

import static com.google.zxing.client.j2se.MatrixToImageWriter.toBufferedImage;

@Service
public class wxService {

    public String getOpenid(String code) {

        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString("https://api.weixin.qq.com/sns/jscode2session?appid=wx3e5955768b640056&secret=02878d1ff0518b5893a35c4227fce5e0&js_code={code}&grant_type=authorization_code").build()
                .expand(code)
                .encode();
        String WX_URL = uriComponents.toString();

        RequestEntity<Void> requestEntity = RequestEntity
                .get(URI.create(WX_URL))
                .build();

        ResponseEntity<String> exchange = new RestTemplate().exchange(requestEntity, String.class);
        String body = exchange.getBody();
        JSONObject jsonObject = JSON.parseObject(body);
        jsonObject.put("registerSign",false);
        return jsonObject.toJSONString();
    }

    public String getQRcode(String openid) throws WriterException, IOException {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        User user=new User("test","test","test","test","test",1,"test","https://wx.qlogo.cn/mmopen/vi_32/x2pm3wR1Q1fsJ3T1NEfqiaa6ej5o5s8BDDiaIQOr58R5Cic3SAxJC0SyjPQWUjLKB03Jxm2N3SicGxYVfRaC8QHljQ/132","test",3,3,false);
        String json_user = JSON.toJSONString(user);

        BitMatrix bitMatrix = qrCodeWriter.encode(json_user, BarcodeFormat.QR_CODE,300,300,hints);
//        MatrixToImageWriter.writeToPath(bitMatrix,"png", Path.of("C:\\zimomo\\WeChatProjects\\test.png"));
        // 实现二：生成二维码图片并将图片转为二进制传递给前台
        // 1、读取文件转换为字节数组
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedImage image = toBufferedImage(bitMatrix);

        ImageIO.write(image, "png", out);
        byte[] bytes = out.toByteArray();

        // 2、将字节数组转为二进制
        Encoder encoder = Base64.getEncoder();
        String binary = encoder.encodeToString(bytes);
        return binary;
    }

    public String getInfo(String openid) {
        User user=new User("test","test","test",1,"test","https://wx.qlogo.cn/mmopen/vi_32/x2pm3wR1Q1fsJ3T1NEfqiaa6ej5o5s8BDDiaIQOr58R5Cic3SAxJC0SyjPQWUjLKB03Jxm2N3SicGxYVfRaC8QHljQ/132","test",3,3,false);
        String json_user = JSON.toJSONString(user);
        return json_user;
    }

}
