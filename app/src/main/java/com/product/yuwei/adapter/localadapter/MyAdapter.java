package com.product.yuwei.adapter.localadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.product.yuwei.R;
import com.product.yuwei.bean.localbean.MyItemClickListener;
import com.product.yuwei.bean.localbean.MyItemLongClickListener;
import com.product.yuwei.bean.localbean.MyViewHolder;
import com.product.yuwei.bean.localbean.MyItemBean;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

	private List<MyItemBean> mData;
	private MyItemClickListener mItemClickListener;
	private MyItemLongClickListener mItemLongClickListener;
	private int itemCount = 2;

	public MyAdapter(List<MyItemBean> data){
		this.mData = data;
	}

	@Override
	public int getItemCount() {
		if(mData.size()>2)
			return itemCount;
		else
			return mData.size();
	}


	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		MyItemBean bean = mData.get(position);
		holder.tv.setText(bean.tv);
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_must_delights, parent, false);
		MyViewHolder vh = new MyViewHolder(itemView,mItemClickListener,mItemLongClickListener);
		return vh;
	}

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
