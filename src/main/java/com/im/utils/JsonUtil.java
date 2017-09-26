package com.im.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;



public class JsonUtil {
	/*protected static ObjectMapper mapper = new ObjectMapper();
	protected static JsonFactory factory = mapper.getJsonFactory();
	
	public final static void writeJSON(Object obj,HttpServletResponse response,String code,String message) throws IOException {
		response.setContentType("text/html;charset=utf-8");
	    JSONObject  dataJson=new JSONObject();
	    dataJson.put("code", code);
	    dataJson.put("message", message);
	    dataJson.put("data", obj);
	    PrintWriter out=response.getWriter();
	    out.print(dataJson.toString());
        out.flush();
        out.close();

	}
	 *//**
     * 将json转化为实体POJO
     * @param jsonStr
     * @param obj
     * @return
     *//*
    public static<T> Object JSONToObj(String jsonStr,Class<T> obj) {
        T t = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            t = objectMapper.readValue(jsonStr,
                    obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    
    *//**
     * 将实体POJO转化为JSON
     * @param obj
     * @return
     * @throws JSONException
     * @throws IOException
     *//*
    public static<T> JSONObject objectToJson(T obj) throws JSONException, IOException {
        ObjectMapper mapper = new ObjectMapper();  
        // Convert object to JSON string  
        String jsonStr = "";
        try {
             jsonStr =  mapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw e;
        }
        return new JSONObject(jsonStr);
    }*/
	public final static void writeJSON(Object obj,HttpServletResponse response,int code,String message) throws IOException {
		response.setContentType("text/html;charset=utf-8");
	    JSONObject  dataJson=new JSONObject();
	    dataJson.put("code", code);
	    dataJson.put("message", message);
	    dataJson.put("data", obj);
	    PrintWriter out=response.getWriter();
	    out.print(dataJson.toString());
        out.flush();
        out.close();
	}
}