package com.product.yuwei.net;


import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;


public final class XHttpTool {

    private XHttpTool(){

    }

    //////////////////////////////  GET 请求 ////////////////////////
    public static void getDataByGet(RequestParams params , final RequestListener requestListener){

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                requestListener.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (ex instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) ex;
                    int responseCode = httpEx.getCode();
                    String responseMsg = httpEx.getMessage();
                    String errorResult = httpEx.getResult();
                    Toast.makeText(x.app(), "请检查您的网络状况", Toast.LENGTH_SHORT);
                } else { // 其他错误
                    Toast.makeText(x.app(), "未知异常", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //////////////////////////////  POST 请求 ////////////////////////
    public static void getDataByPost(RequestParams params , final RequestListener requestListener){
        x.http().post(params, new Callback.CommonCallback<String>() {   //这里的泛型必须写
            @Override
            public void onSuccess(String result) {
                requestListener.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (ex instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) ex;
                    int responseCode = httpEx.getCode();
                    String responseMsg = httpEx.getMessage();
                    String errorResult = httpEx.getResult();
                    Toast.makeText(x.app(), "请检查您的网络状况", Toast.LENGTH_SHORT);
                } else { // 其他错误
                    Toast.makeText(x.app(), "未知异常", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                requestListener.onFinished();
            }
        });
    }

}
