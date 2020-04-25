// 
// Decompiled by Procyon v0.5.36
// 

package com.raspberry.mirror;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.Locale;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController
{
    @RequestMapping(value = { "/idle" }, method = { RequestMethod.GET })
    public String idle(final Locale locale, final Model model) {
        return "idle";
    }
    
    @RequestMapping(value = { "/" }, method = { RequestMethod.GET })
    public String home(final Locale locale, final Model model) {
        final CallAPI ca = new CallAPI();
        final UtilClass uc = new UtilClass();
        final String today = uc.getToday();
        System.out.println("today : " + today);
        final String hours = uc.getHour();
        final String[] location = { "\uc11c\uc6b8,61,126", "\uc6b8\uc0b0,102,84", "\ub300\uc804,66,100", "\ubd80\uc0b0 ,98,76", "\uad11\uc8fc,59,75", "\uc804\uc8fc,63,88", "\ud654\uc131,62,118", "\uc544\uc0b0,60,110", "\uc81c\uc8fc,53,38" };
        final List<DataVO> info = new ArrayList<DataVO>();
        final DataVO iInfo = new DataVO();
        String baseTime = "";
        for (int i = 0; i < location.length; ++i) {
            final String[] lArr = location[i].split(",");
            try {
                final String str = ca.restWeatherInfo(today, hours, lArr[1], lArr[2]);
                final JSONParser parser = new JSONParser();
                final JSONObject obj = (JSONObject)parser.parse(str);
                final JSONObject responseObj = (JSONObject)obj.get((Object)"response");
                final JSONObject bodyObj = (JSONObject)responseObj.get((Object)"body");
                final JSONObject itemsObj = (JSONObject)bodyObj.get((Object)"items");
                final JSONArray arr = (JSONArray)itemsObj.get((Object)"item");
                final DataVO dataVO = new DataVO();
                dataVO.setLocation(lArr[0]);
                for (int j = 0; j < arr.size(); ++j) {
                    final JSONObject arrObj = (JSONObject)arr.get(j);
                    System.out.println(arrObj.get((Object)"baseDate") + "|" + arrObj.get((Object)"baseTime") + "|" + arrObj.get((Object)"nx") + "|" + arrObj.get((Object)"ny") + "|" + arrObj.get((Object)"category") + "|" + arrObj.get((Object)"obsrValue"));
                    dataVO.setBaseDate(String.valueOf(arrObj.get((Object)"baseDate")));
                    dataVO.setBaseTime(String.valueOf(arrObj.get((Object)"baseTime")));
                    if (arrObj.get((Object)"category").equals("SKY")) {
                        dataVO.setSkyCondition(String.valueOf(arrObj.get((Object)"obsrValue")));
                    }
                    if (arrObj.get((Object)"category").equals("T1H")) {
                        dataVO.setTemperature(String.valueOf(arrObj.get((Object)"obsrValue")));
                    }
                    if (arrObj.get((Object)"category").equals("PTY")) {
                        dataVO.setPrecipitationForm(String.valueOf(arrObj.get((Object)"obsrValue")));
                    }
                }
                if ("\uc11c\uc6b8".equals(dataVO.getLocation())) {
                    iInfo.setBaseDate(dataVO.getBaseDate());
                    iInfo.setBaseTime(dataVO.getBaseTime());
                    iInfo.setLocation(dataVO.getLocation());
                    iInfo.setPrecipitationForm(dataVO.getPrecipitationForm());
                    iInfo.setSkyCondition(dataVO.getSkyCondition());
                    iInfo.setTemperature(dataVO.getTemperature());
                }
                else {
                    info.add(dataVO);
                }
                baseTime = dataVO.getBaseTime();
                baseTime = baseTime.substring(0, 2).concat(":00");
                System.out.println("baseTime : " + baseTime);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("info", (Object)info);
        model.addAttribute("iInfo", (Object)iInfo);
        model.addAttribute("baseTime", (Object)baseTime);
        return "home";
    }
    
    @RequestMapping(value = { "/home2" }, method = { RequestMethod.GET })
    public String home2(final Locale locale, final Model model) {
        return "home2";
    }
    
    @RequestMapping(value = { "/home3" }, method = { RequestMethod.GET })
    public String home3(final Locale locale, final Model model) {
        return "home3";
    }
}