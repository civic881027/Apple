package com.summer.apple;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.summer.apple.data.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestListAdapter extends RecyclerView.Adapter<RestListAdapter.RestViewHolder> {
    private Cursor mCursor;
    private Context mContext;

    public RestListAdapter(Context context,Cursor cursor){
        this.mCursor=cursor;
        this.mContext=context;
    }

    @NonNull
    @Override
    public RestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.rest_list_item,parent,false);
        return new RestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position))return;
        try{
            String name=mCursor.getString(mCursor.getColumnIndex(RestaurantListContract.COLUMN_REST_NAME));
            String rate=mCursor.getString(mCursor.getColumnIndex(RestaurantListContract.COLUMN_RATE));
            String url=mCursor.getString(mCursor.getColumnIndex(RestaurantListContract.COLUMN_IMAGE_URL));

        }catch(SQLException e){
            e.printStackTrace();
        }





    }

    public void swapCursor(Cursor cursor){
        if(mCursor!=null)mCursor.close();
        mCursor=cursor;
        if(cursor!=null){
            this.notifyDataSetChanged();
        }
    }

    class RestViewHolder extends RecyclerView.ViewHolder{
        ImageView ivRestImage;
        TextView tvRestName;
        TextView tvRestRate;
        public RestViewHolder(View itemView){
            super(itemView);
            ivRestImage=(ImageView)itemView.findViewById(R.id.imgItem);
            tvRestName=(TextView)itemView.findViewById(R.id.nameItem);
            tvRestRate=(TextView)itemView.findViewById(R.id.rateItem);
        }
    }
}
