package com.rainbow.module.wechat;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.rainbow.core.http.HttpRequester;
import com.rainbow.module.wechat.beans.AccessToken;

public class AccessTokenMaker extends Thread {

	@Override 	
	public void run() { 
//		try {  
//            while (true) {  
//                
//                HttpRequester ht = new HttpRequester();
//                String url = HttpRequester.URL_WECHAT_TOKEN_UPDATE + "&appid=wxb2a86bc6f8346ed6&secret=dfb067bad5fc8319fb59868f2d6ec89c";
//                String response = ht.post(url, null);
//                JSONObject json = new JSONObject(response);
//                String token = json.getString("access_token");
//                AccessToken.TOKEN = token;
//                Thread.sleep(7200*1000);  
//            }  
//              
//        } catch (InterruptedException e) {  
//            e.printStackTrace();  
//        } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
	}
}
