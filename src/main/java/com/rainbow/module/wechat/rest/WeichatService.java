package com.rainbow.module.wechat.rest;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.rainbow.core.http.HttpRequester;
import com.rainbow.module.wechat.beans.AccessToken;

@Path("/wechat")
public class WeichatService {
	
	@Path("/in")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Response wechat(String xml) {
		
		try {
			Document doc = DocumentHelper.parseText(xml);

			Element el = doc.getRootElement();
			String openID = el.selectSingleNode("FromUserName").getStringValue();
			String content = el.selectSingleNode("Content").getStringValue();
			
			if(!openID.equalsIgnoreCase("obZMl1VEPEinDnYanz6DhB58htkM") && !openID.equalsIgnoreCase("obZMl1SYElJEfQXQrYCT2ZAqJqtc")){
				AccessToken.PHYLLIS = openID;
			}
			
			JSONObject json = new JSONObject();
	    	try {
				json.put("touser", openID);
				json.put("msgtype", "text");
				json.put("text", new JSONObject().put("content", "What's the content you sent to me is <" + content +">. This message is from Ray's desktop server."));
			
	    	HttpRequester http = new HttpRequester();
	    	
	    	http.post(HttpRequester.URL_SEND_CUSTOMER_MSG + "?access_token=" + AccessToken.TOKEN, json);
	    	} catch (JSONException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
			System.out.println(openID);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(xml);
		return Response.status(200).entity("ok").build();
		
	}

}
