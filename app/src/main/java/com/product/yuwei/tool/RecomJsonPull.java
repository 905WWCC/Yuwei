package com.product.yuwei.tool;

import android.nfc.Tag;
import android.util.Log;

import com.product.yuwei.bean.homebean.RecomAuthorBean;
import com.product.yuwei.bean.homebean.RecomBaseBean;
import com.product.yuwei.bean.homebean.RecomNoteBean;
import com.product.yuwei.bean.homebean.RecomPageBean;
import com.product.yuwei.bean.homebean.RecomHotBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



/**Json解析 初始化bean要在循环里面
 * Created by dd on 2016/11/4.
 */

public  class RecomJsonPull {
    private static final String TAG = "recompull";

    public static RecomBaseBean pullRecomjson(String jsonString)throws JSONException{
        RecomBaseBean recombasebean =new RecomBaseBean();
        List<RecomPageBean> list_page=new ArrayList<>();
        List<RecomHotBean> listhotbean1=new ArrayList<RecomHotBean>();
        List<RecomHotBean> listhotbean2=new ArrayList<RecomHotBean>();
        List<RecomHotBean> listhotbean3=new ArrayList<RecomHotBean>();
        List<RecomHotBean> listhotbean4=new ArrayList<RecomHotBean>();
        List<RecomHotBean> listhotbean5=new ArrayList<RecomHotBean>();
        List<RecomNoteBean> list_notebean=new ArrayList<>();



        JSONObject jsonObject=new JSONObject(jsonString);//
        JSONObject data= jsonObject.getJSONObject("data");//data是<list[]>
        JSONArray list=data.getJSONArray("list");//list代表是list的数组
        JSONObject themes=list.getJSONObject(0);//themes是获得的list(0),滑动视图对象、
        JSONObject shot=list.getJSONObject(1);//shot是没有用的
        JSONObject hot =list.getJSONObject(2);//hot 是热门推荐，就是那个九宫格
        JSONObject note=list.getJSONObject(3);//note是listView 的数据源
        JSONArray themes_content=themes.getJSONArray("content");//themes_content是一个有4个对象的list
        JSONArray hot_content=hot.getJSONArray("content");



        JSONObject hot1=hot_content.getJSONObject(0);//hot1_是老饕最爱list中的第一个 是一个对象
        JSONObject hot2=hot_content.getJSONObject(1);
        JSONObject hot3=hot_content.getJSONObject(2);
        JSONObject hot4=hot_content.getJSONObject(3);
        JSONObject hot5=hot_content.getJSONObject(4);
        JSONArray hot1_content=hot1.getJSONArray("content");//hot1_content是list，这个标题还没处理
        JSONArray hot2_content=hot2.getJSONArray("content");
        JSONArray hot3_content=hot3.getJSONArray("content");
        JSONArray hot4_content=hot4.getJSONArray("content");
        JSONArray hot5_content=hot5.getJSONArray("content");


        //////////////////////////获得themes中的图片信息/////////////////

        for (int i = 0; i <themes_content.length() ; i++) {
            RecomPageBean recom_page=new RecomPageBean();
            String title=themes_content.getJSONObject(i).getString("title");
            recom_page.setTitle(title);
            String img=themes_content.getJSONObject(i).getString("img");
            recom_page.setImg(img);
            String url=themes_content.getJSONObject(i).getString("url");
            recom_page.setUrl(url);
            list_page.add(recom_page);

        }
        /////////////////这里要加入到主要的类里面
        recombasebean.setList_page(list_page);
      //  Log.e(TAG,list_page+"pullRecomjson");


        /////////////////////获得hot里面的标题，

        String hot5_title=hot5.getString("title");
        String hot4_title=hot4.getString("title");
        String hot3_title=hot3.getString("title");
        String hot2_title=hot2.getString("title");
        String hot1_title=hot1.getString("title");

        recombasebean.setHot1_title(hot1_title);
        recombasebean.setHot2_title(hot2_title);
        recombasebean.setHot3_title(hot3_title);
        recombasebean.setHot4_title(hot4_title);
        recombasebean.setHot5_title(hot5_title);
///////////////////////////////////////////////下面是获得hot1到hot5的bean///////////////////////////////////
        for (int i = 0; i <hot1_content.length() ; i++) {//都是六个
            RecomHotBean recomhotbean=new RecomHotBean();
            recomhotbean.setId(hot1_content.getJSONObject(i).getJSONObject("content").getString("id"));
            recomhotbean.setName(hot1_content.getJSONObject(i).getJSONObject("content").getString("name"));
            recomhotbean.setSummary(hot1_content.getJSONObject(i).getJSONObject("content").getString("summary"));
            recomhotbean.setCover(hot1_content.getJSONObject(i).getJSONObject("content").getString("cover"));
            recomhotbean.setUrl(hot1_content.getJSONObject(i).getJSONObject("content").getString("url"));
            listhotbean1.add(recomhotbean);
            //这边没问题

        }
        recombasebean.setList_hot1(listhotbean1);//这里的值好像都是一样的
       // recomhotbean=null;//要不要清呢？
        for (int i = 0; i <hot2_content.length() ; i++) {
            RecomHotBean recomhotbean=new RecomHotBean();
            recomhotbean.setId(hot2_content.getJSONObject(i).getJSONObject("content").getString("id"));
            recomhotbean.setName(hot2_content.getJSONObject(i).getJSONObject("content").getString("name"));
            recomhotbean.setSummary(hot2_content.getJSONObject(i).getJSONObject("content").getString("summary"));
            recomhotbean.setCover(hot2_content.getJSONObject(i).getJSONObject("content").getString("cover"));
            recomhotbean.setUrl(hot2_content.getJSONObject(i).getJSONObject("content").getString("url"));
            listhotbean2.add(recomhotbean);
        }
        recombasebean.setList_hot2(listhotbean2);
       // recomhotbean=null;//要不要清呢？
        for (int i = 0; i <hot3_content.length() ; i++) {
            RecomHotBean recomhotbean=new RecomHotBean();
            recomhotbean.setId(hot3_content.getJSONObject(i).getJSONObject("content").getString("id"));
            recomhotbean.setName(hot3_content.getJSONObject(i).getJSONObject("content").getString("name"));
            recomhotbean.setSummary(hot3_content.getJSONObject(i).getJSONObject("content").getString("summary"));
            recomhotbean.setCover(hot3_content.getJSONObject(i).getJSONObject("content").getString("cover"));
            recomhotbean.setUrl(hot3_content.getJSONObject(i).getJSONObject("content").getString("url"));
            listhotbean3.add(recomhotbean);
        }
        recombasebean.setList_hot3(listhotbean4);
       // recomhotbean=null;//要不要清呢？
        for (int i = 0; i <hot4_content.length() ; i++) {
            RecomHotBean recomhotbean=new RecomHotBean();
            recomhotbean.setId(hot4_content.getJSONObject(i).getJSONObject("content").getString("id"));
            recomhotbean.setName(hot4_content.getJSONObject(i).getJSONObject("content").getString("name"));
            recomhotbean.setSummary(hot4_content.getJSONObject(i).getJSONObject("content").getString("summary"));
            recomhotbean.setCover(hot4_content.getJSONObject(i).getJSONObject("content").getString("cover"));
            recomhotbean.setUrl(hot4_content.getJSONObject(i).getJSONObject("content").getString("url"));
            listhotbean4.add(recomhotbean);
        }
        recombasebean.setList_hot4(listhotbean4);
     //   recomhotbean=null;//要不要清呢？
        for (int i = 0; i <hot5_content.length() ; i++) {
            RecomHotBean recomhotbean=new RecomHotBean();
            recomhotbean.setId(hot5_content.getJSONObject(i).getJSONObject("content").getString("id"));
            recomhotbean.setName(hot5_content.getJSONObject(i).getJSONObject("content").getString("name"));
            recomhotbean.setSummary(hot5_content.getJSONObject(i).getJSONObject("content").getString("summary"));
            recomhotbean.setCover(hot5_content.getJSONObject(i).getJSONObject("content").getString("cover"));
            recomhotbean.setUrl(hot5_content.getJSONObject(i).getJSONObject("content").getString("url"));
            listhotbean5.add(recomhotbean);
        }
        recombasebean.setList_hot5(listhotbean5);
        //////////////////////////////////////////////获得note中的信息
        JSONArray note_content=note.getJSONArray("content");
        String note_title=note.getString("title");
        String note_subtitle=note.getString("subtitle");
        recombasebean.setNote_title(note_title);
        recombasebean.setNote_subtitle(note_subtitle);

        for (int i = 0; i <note_content.length() ; i++) {
            RecomNoteBean recomnotebean=new RecomNoteBean();
           // RecomAuthorBean author=new RecomAuthorBean();
            recomnotebean.setId(note_content.getJSONObject(i).getString("id"));
            recomnotebean.setName(note_content.getJSONObject(i).getString("name"));
            recomnotebean.setUrl(note_content.getJSONObject(i).getString("url"));
            recomnotebean.setCover(note_content.getJSONObject(i).getString("cover"));
            recomnotebean.setCity(note_content.getJSONObject(i).getString("city"));
            recomnotebean.setTime(note_content.getJSONObject(i).getString("time"));
            JSONObject note_author=note_content.getJSONObject(i).getJSONObject("author");
            recomnotebean.setAuthor_name(note_author.getString("uname"));
            recomnotebean.setAuthor_img(note_author.getString("header"));
            list_notebean.add(recomnotebean);
        }
        recombasebean.setNote_list(list_notebean);
        return recombasebean;

    }




}

