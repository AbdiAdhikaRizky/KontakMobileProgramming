package com.example.kontak.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kontak.EditActivity;
import com.example.kontak.Model.Kontak;
import com.example.kontak.R;

import java.util.List;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.MyViewHolder> {
    List<Kontak>mKontakList;
    public KontakAdapter(List<Kontak>KontakList){
        mKontakList = KontakList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kontak_list,parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position){
        holder.mTextViewId.setText("id = "+mKontakList.get(position).getId());
        holder.mTextViewNama.setText("nama = "+mKontakList.get(position).getNama());
        holder.mTextviewNomor.setText("nomor = "+mKontakList.get(position).getNomor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("id",mKontakList.get(position).getId());
                mIntent.putExtra("nama",mKontakList.get(position).getNama());
                mIntent.putExtra("nomor",mKontakList.get(position).getNomor());
                view.getContext().startActivity(mIntent);
            }
        });
    }
    @Override
    public  int getItemCount(){
        return mKontakList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextViewId,mTextViewNama,mTextviewNomor;
        public MyViewHolder(View itemView){
            super(itemView);
            mTextViewId = (TextView)itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView)itemView.findViewById(R.id.tvNama);
            mTextviewNomor = (TextView)itemView.findViewById(R.id.tvNomor);
        }
    }
}
