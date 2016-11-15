package com.product.yuwei.adapter.localadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.product.yuwei.R;
import com.product.yuwei.bean.localbean.MustEatBean;
import com.product.yuwei.view.localview.MyItemClickListener;
import com.product.yuwei.view.localview.MyItemLongClickListener;
import com.product.yuwei.view.localview.MyViewHolder;
import com.product.yuwei.bean.localbean.MyItemBean;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

//	private List<MyItemBean> list;
	private List<MustEatBean> list;
	private MyItemClickListener mItemClickListener;
	private MyItemLongClickListener mItemLongClickListener;
	private int itemCount = 2;
	private Context context;

	public MyAdapter(Context context,List<MustEatBean> list){
		this.context = context;
		this.list = list;
	}

	@Override
	public int getItemCount() {
		if(list.size()>2)
			return itemCount;
		else
			return list.size();
	}


	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
//		MyItemBean bean = list.get(position);
		MustEatBean mustEatBean = list.get(position);
		String name = mustEatBean.getName();
		String sum = mustEatBean.getSum();

		holder.tv.setText(name);
		holder.tv1.setText(sum);
		Glide
				.with(context)
				.load(mustEatBean.getCover())
				.centerCrop()
				.into(holder.iv);

	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_must_delights, parent, false);
		MyViewHolder vh = new MyViewHolder(itemView,mItemClickListener,mItemLongClickListener);

		return vh;
	}

//	static class ViewHolder{
//		public ImageView img;
//		public String title1,title2;
//	}
	/**
	 * 设置Item点击监听
	 * @param listener
	 */
	public void setOnItemClickListener(MyItemClickListener listener){
		this.mItemClickListener = listener;
	}

	public void setOnItemLongClickListener(MyItemLongClickListener listener){
		this.mItemLongClickListener = listener;
	}
	public void addItemNum(int number){
		itemCount = number;
	}
}
