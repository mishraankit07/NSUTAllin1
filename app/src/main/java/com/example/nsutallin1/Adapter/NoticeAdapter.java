package com.example.nsutallin1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nsutallin1.Class.Notice;
import com.example.nsutallin1.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {


    private ArrayList<Notice> mNotices;
    private Context mContext;

    public NoticeAdapter(ArrayList<Notice> notices, Context context) {
        mNotices = notices;
        mContext = context;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notices_item, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NoticeViewHolder holder, int position) {

        final Notice notice = mNotices.get(position);

        holder.subject.setText(notice.getTitle());
        holder.pubDate.setText(notice.getPubDate());
        holder.pubBy.setText(notice.getPubBy());

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(notice.getDownloadLink()));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNotices.size();
    }

    public static class NoticeViewHolder extends RecyclerView.ViewHolder {

        TextView subject;
        TextView pubDate;
        TextView pubBy;

        View rootView;

        public NoticeViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = itemView;
            subject = (TextView) itemView.findViewById(R.id.subject);
            pubDate = (TextView) itemView.findViewById(R.id.published_on);
            pubBy = (TextView) itemView.findViewById(R.id.published_by);
        }
    }
}
