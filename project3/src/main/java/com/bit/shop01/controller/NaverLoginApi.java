package com.bit.shop01.controller;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverLoginApi extends DefaultApi20{

	
	 protected NaverLoginApi(){
	    }

	    private static class InstanceHolder{
	        private static final NaverLoginApi INSTANCE = new NaverLoginApi();
	    }


	    public static NaverLoginApi instance(){
	        return InstanceHolder.INSTANCE;
	    }

	    @Override
	    public String getAccessTokenEndpoint() {
	        return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	    }
	    
	    public String getAccessTokenDelete() {
	    	return "https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=CLIENT_ID&client_secret=CLIENT_SECRET&access_token=ACCESS_TOKEN";
	    }                   

	    @Override
	    protected String getAuthorizationBaseUrl() {
	        return "https://nid.naver.com/oauth2.0/authorize";
	    }   

	}

