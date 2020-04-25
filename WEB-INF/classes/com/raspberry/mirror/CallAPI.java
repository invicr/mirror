// 
// Decompiled by Procyon v0.5.36
// 

package com.raspberry.mirror;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import java.net.URL;

public class CallAPI
{
    public String restWeatherInfo(final String today, final String hour, final String nX, final String nY) throws Exception {
        String addr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService/ForecastGrib?ServiceKey=";
        final String serviceKey = "dfFAkpvOb9tqjShICYWmHRRxLFykGmfENe6%2FR7%2F6OuB51irAdNC9pwDdy%2Fijt6NLCayTL9vZAYFRLRqqNiZUcg%3D%3D";
        String parameter = "";
        parameter = String.valueOf(parameter) + "&" + "base_date=" + today + "&base_time=" + hour + "00&nx=" + nX + "&ny=" + nY + "&pageNo=1&numOfRows=10&_type=json";
        addr = String.valueOf(addr) + serviceKey + parameter;
        System.out.println(addr);
        final URL url = new URL(addr);
        final InputStream in = url.openStream();
        final CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, (OutputStream)bos);
        in.close();
        bos.close();
        return bos.getOut().toString();
    }
}