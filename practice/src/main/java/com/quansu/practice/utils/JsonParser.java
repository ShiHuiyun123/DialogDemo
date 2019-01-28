package com.quansu.practice.utils;

import com.quansu.practice.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Created by weihuagu on 2017/11/18.
 */

public class JsonParser {

    public static String parseIatResult(String json) {
        StringBuffer ret = new StringBuffer();
        try {
            JSONTokener tokener = new JSONTokener(json);
            JSONObject joResult = new JSONObject(tokener);

            JSONArray words = joResult.getJSONArray("ws");
            for (int i = 0; i < words.length(); i++) {
                // Rewrite the result word, using the first result by default
                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
                JSONObject obj = items.getJSONObject(0);
                ret.append(obj.getString("w"));
//				If multiple candidates are needed, parse the other fields of the array
//				for(int j = 0; j < items.length(); j++)
//				{
//					JSONObject obj = items.getJSONObject(j);
//					ret.append(obj.getString("w"));
//				}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret.toString();
    }

    public static String parseGrammarResult(String json) {
        StringBuffer ret = new StringBuffer();
        try {
            JSONTokener tokener = new JSONTokener(json);
            JSONObject joResult = new JSONObject(tokener);

            JSONArray words = joResult.getJSONArray("ws");
            for (int i = 0; i < words.length(); i++) {
                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
                for (int j = 0; j < items.length(); j++) {
                    JSONObject obj = items.getJSONObject(j);
                    if (obj.getString("w").contains("nomatch")) {
                        ret.append(R.string.no_matching_results);
                        return ret.toString();
                    }
                    ret.append(R.string.the_results_of + obj.getString("w"));
                    ret.append(R.string.degree_of_confidence + obj.getInt("sc"));
                    ret.append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ret.append(R.string.no_matching_results);
        }
        return ret.toString();
    }

    public static String parseLocalGrammarResult(String json) {
        StringBuffer ret = new StringBuffer();
        try {
            JSONTokener tokener = new JSONTokener(json);
            JSONObject joResult = new JSONObject(tokener);

            JSONArray words = joResult.getJSONArray("ws");
            for (int i = 0; i < words.length(); i++) {
                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
                for (int j = 0; j < items.length(); j++) {
                    JSONObject obj = items.getJSONObject(j);
                    if (obj.getString("w").contains("nomatch")) {
                        ret.append(R.string.no_matching_results);
                        return ret.toString();
                    }
                    ret.append(R.string.the_results_of + obj.getString("w"));
                    ret.append("\n");
                }
            }
            ret.append(R.string.degree_of_confidence + joResult.optInt("sc"));

        } catch (Exception e) {
            e.printStackTrace();
            ret.append(R.string.no_matching_results);
        }
        return ret.toString();
    }

    public static String parseTransResult(String json, String key) {
        StringBuffer ret = new StringBuffer();
        try {
            JSONTokener tokener = new JSONTokener(json);
            JSONObject joResult = new JSONObject(tokener);
            String errorCode = joResult.optString("ret");
            if (!errorCode.equals("0")) {
                return joResult.optString("errmsg");
            }
            JSONObject transResult = joResult.optJSONObject("trans_result");
            ret.append(transResult.optString(key));
            /*JSONArray words = joResult.getJSONArray("results");
			for (int i = 0; i < words.length(); i++) {
				JSONObject obj = words.getJSONObject(i);
				ret.append(obj.getString(key));
			}*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret.toString();
    }
}
