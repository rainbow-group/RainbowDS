package com.rainbow.module.wechat.rest;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.rainbow.core.http.HttpRequester;
import com.rainbow.module.wechat.beans.AccessToken;

@Path("/wc")
public class WeichatSenderService {

	@Path("/test")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response wechat(String text) {

		JSONObject json = new JSONObject();
		try {
			json.put("touser", AccessToken.PHYLLIS == null?"obZMl1SYElJEfQXQrYCT2ZAqJqtc" : AccessToken.PHYLLIS);
			json.put("msgtype", "text");
			json.put("text", new JSONObject().put("content",
					"Hi Phyllis, you just sent message : <" + text + "> from your laptop :)."));

			HttpRequester http = new HttpRequester();

			http.post(HttpRequester.URL_SEND_CUSTOMER_MSG + "?access_token=" + AccessToken.TOKEN, json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.status(200).entity("ok").build();

	}
	
//	@Path("/test1")
//	@POST
//	@Produces(MediaType.TEXT_PLAIN)
//	public Response wechat1(String openId, String text) {
//
//		JSONObject json = new JSONObject();
//		try {
//			json.put("touser", openId);
//			json.put("msgtype", "text");
//			json.put("text", new JSONObject().put("content",
//					"Hi, you just sent message : <" + text + "> from your laptop :)."));
//
//			HttpRequester http = new HttpRequester();
//
//			http.post(HttpRequester.URL_SEND_CUSTOMER_MSG + "?access_token=" + AccessToken.TOKEN, json);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return Response.status(200).entity("ok").build();
//
//	}

}
