package com.smartron.sid.bytridgesample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smartron.sid.bytridgesample.R;
import com.smartron.sid.bytridgesample.model.HorizontalScrollLayout;
import com.smartron.sid.bytridgesample.model.SwaggeredLayout;

import java.util.ArrayList;
import java.util.List;

public class SwaggeredScrollAdapter extends RecyclerView.Adapter<SwaggeredScrollAdapter.ViewHolder> {

    private Context mContext;
    private List<SwaggeredLayout> list;

    public SwaggeredScrollAdapter(Context context) {
        mContext = context;
        this.list = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swaggered_layout, parent, false);
        return new ViewHolder(view);
    }

    public void setData(List<SwaggeredLayout> list){
        if (!this.list.isEmpty())this.list.clear();
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RequestOptions defaultOptions = new RequestOptions();
        defaultOptions.placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);
        if (!TextUtils.isEmpty(list.get(position).getKidsUrl().toString()))
            Glide.with(mContext)
                    .setDefaultRequestOptions(defaultOptions)
                    .load(list.get(position).getKidsUrl())
                    .into(holder.imageView);

        holder.textView.setText(list.get(position).getId().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
