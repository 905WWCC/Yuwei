package com.product.yuwei.view.localview;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.product.yuwei.R;


public class MyViewHolder extends ViewHolder implements OnClickListener,OnLongClickListener{

	public ImageView iv;
	public TextView tv,tv1;
	private MyItemClickListener mListener;
	private MyItemLongClickListener mLongClickListener;
	
	public MyViewHolder(View arg0,MyItemClickListener listener,MyItemLongClickListener longClickListener) {
		super(arg0);

		iv = (ImageView)arg0.findViewById(R.id.cover);
		tv = (TextView)arg0.findViewById(R.id.name);
		tv1 = (TextView)arg0.findViewById(R.id.sum);
		this.mListener = listener;
		this.mLongClickListener = longClickListener;
		arg0.setOnClickListener(this);
		arg0.setOnLongClickListener(this);
	}


	@Override
	public void onClick(View v) {
		if(mListener != null){
			mListener.onItemClick(v,getPosition());
		}
	}

	@Override
	public boolean onLongClick(View arg0) {
		if(mLongClickListener != null){
			mLongClickListener.onItemLongClick(arg0, getPosition());
		}
		return true;
	}

}
