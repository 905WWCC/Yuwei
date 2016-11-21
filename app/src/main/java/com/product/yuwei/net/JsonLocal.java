//package com.product.yuwei.net;
//
///**
// * Created by Administrator on 2016/11/13 0013.
// */
//
//import com.product.yuwei.bean.HotBase;
//import com.product.yuwei.bean.localbean.LocalDataBean;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * Created by Administrator on 2016/10/30 0030.
// */
//public class JsonLocal {
//
//    public static List<LocalDataBean> parserData(String jsonString,int id) throws JSONException {
//
//        List<LocalDataBean> list = null;
//
//        switch (id){
//            case 1:
//                list = new ArrayList<LocalDataBean>();
//                LocalDataBean localDataBean = null;
//                JSONObject object = new JSONObject(jsonString);
//
//                JSONObject data = object.getJSONObject("data");
//                JSONArray dataList = data.getJSONArray("list");
//
//                for (int i = 0; i < dataList.length(); i++) {
//                    JSONObject jsonObject = dataList.getJSONObject(i);
//                    String type = jsonObject.getString("type");
//                    localDataBean = new LocalDataBean();
//                    JSONArray content = jsonObject.getJSONArray("content");
////
////                    String name = content.getJSONObject(i).getString("name");
////                    String summary = content.getJSONObject(i).getString("summary");
////                    int cost = content.getJSONObject(i).getInt("cost");
////                    localDataBean.setType(type);
////                    localDataBean.setName(name);
////                    localDataBean.setSummary(summary);
////                    localDataBean.setCost(cost);
////                    list.add(localDataBean);
////                }
////                break;
//
//        }
//        return list;
//
//    }
//
//}
