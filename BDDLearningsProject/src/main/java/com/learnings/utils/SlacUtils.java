package com.learnings.utils;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SlacUtils {


	private static String slackWebHookURL="";
	
	private static void sendMessage(SlackMessage message) {
		CloseableHttpClient client=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(slackWebHookURL);
		
		try {
			ObjectMapper objectMapper=new ObjectMapper();
			String json =objectMapper.writeValueAsString(message);
			StringEntity entity=new StringEntity(json);
			httpPost.setEntity(entity);
httpPost.setHeader("Accept","application/json");
httpPost.setHeader("Content-Type","application/json");
client.execute(httpPost);

		}catch (Exception e) {
			// TODO: handle exception
		}
	}
public void sendSlackMessage(String message) {
	SlackMessage slackMessage=new SlackMessage();
	slackMessage.setText(message);
	slackMessage.setUserName("bot");
	slackMessage.setIcon_emoji(":twice:");
}
}
