package com.zjweu.verification;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

public class Verification {

    // 短信应用 SDK AppID
    static int appid = 123456789; // SDK AppID 以1400开头

    // 短信应用 SDK AppKey
    static String appkey = "******";

    // 短信模板 ID，需要在短信应用中申请
    static int templateId = 123456789; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请

    // 签名
    static String smsSign = "*****"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请

    public static void sendOne(String param1, String param2, String phoneNumber) {
        try {
            String[] params = {"",param2,"5"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    123123123, params, smsSign, "", "");
        } catch (Exception e){

        }
    }

}
