package com.product.yuwei.bean;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class PreferenceUtil {

    //保存到Preference
    public static void setBoolean(Context context,String key,boolean value){
        //得到SharedPreferences   设置只允许本应用程序读、写
        SharedPreferences preferences = context.getSharedPreferences("preference",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();       //SharedPreferences不能写入数据，但其内部接口中的edit()方法可以获得有写入的Editor对象
        editor.putBoolean(key,value);
        editor.commit();
    }

    //读取数据
    public static boolean getBoolean(Context context,String key){
        SharedPreferences preferences = context.getSharedPreferences("preference",Context.MODE_PRIVATE);
        //返回key值，key的默认值为false
        return preferences.getBoolean(key,false);
    }

}
