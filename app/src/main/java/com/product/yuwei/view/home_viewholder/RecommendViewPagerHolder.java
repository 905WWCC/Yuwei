
package com.product.yuwei.view.home_viewholder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.product.yuwei.R;
import com.product.yuwei.adapter.homeadapter.SidesPageAdapter;
import com.product.yuwei.bean.homebean.Homepage_Slide;


/**viewpager
 * Created by dd on 2016/10/30.
 */


public class RecommendViewPagerHolder {
    private Context context;
    private View view;
    private ViewPager mViewPager;
    private SidesPageAdapter sidesPageAdapter;
    private int currentItem=0;
    protected static final int MSG_UPDATE_IMAGE=1;
    //请求暂停轮播
    protected static final int MSG_KEEP_SILENT=2;
    //请求恢复轮播
    protected static final int MSG_BREAK_SILENT=3;

/**
     * 记录最新的页号，当用户手动滑动时需要记录新页号，否则会使轮播的页面出错。
     * 例如当前如果在第一页，本来准备播放的是第二页，而这时候用户滑动到了末页，
     * 则应该播放的是第一页，如果继续按照原来的第二页播放，则逻辑上有问题。
     */

    protected static final int MSG_PAGE_CHANGED=4;
    //轮播间隔时间
    protected static final long MSG_DELAY=3000;

    Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //检查列队并且移除未发出的消息
            if (mHandler.hasMessages(MSG_UPDATE_IMAGE)) {
                mHandler.removeMessages(MSG_UPDATE_IMAGE);
            }
            switch (msg.what){
                case MSG_UPDATE_IMAGE:
                    currentItem++;
                    mViewPager.setCurrentItem(currentItem);//跳转到指定的页面
                    //准备下次播放
                    mHandler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE,MSG_DELAY);
                    break;
                case MSG_KEEP_SILENT://休眠
                    break;
                case MSG_BREAK_SILENT://重新启动
                    mHandler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE,MSG_DELAY);
                    break;
                case MSG_PAGE_CHANGED:
                    //记录当期页码
                    currentItem=msg.arg1;
                    break;
                default:
                    break;
            }
        }

    };
    public RecommendViewPagerHolder(Context context, Homepage_Slide homepage_slide){
        this.context=context;
        view= LayoutInflater.from(context).inflate(R.layout.recommend_head_vp,null);
        mViewPager= (ViewPager) view.findViewById(R.id.id_recommend_head_vp);
        setViewPager(homepage_slide);
    }


    public void setViewPager(final Homepage_Slide homepage_slide) {
        sidesPageAdapter=new SidesPageAdapter(context,homepage_slide.getImgUrlList());
        sidesPageAdapter.setOnItemClickListener(new SidesPageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //点击指定项的操作
            }
        });
        mViewPager.setAdapter(sidesPageAdapter);
        //滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mHandler.sendMessage(Message.obtain(mHandler, MSG_PAGE_CHANGED, position, 0));
                int newPosition=position%homepage_slide.getImgUrlList().length;//得到新的索引

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch(state){
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        mHandler.sendEmptyMessage(MSG_KEEP_SILENT);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        mHandler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
                        break;
                    default:
                        break;
                }

            }
        });
        mViewPager.setCurrentItem(0);//默认在中间，使用户看不到边界
        //开始轮播效果
        mHandler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
    }
}

