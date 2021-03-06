package com.testerhome.nativeandroid.views.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.testerhome.nativeandroid.R;
import com.testerhome.nativeandroid.models.TopicEntity;
import com.testerhome.nativeandroid.views.adapters.BaseAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bin Li on 2015/9/16.
 */
public class TopicsListAdapter extends BaseAdapter<TopicEntity> {


    public TopicsListAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_topic, parent, false);
        return new TopicItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        TopicItemViewHolder holder = (TopicItemViewHolder) viewHolder;

        TopicEntity topic = mItems.get(position);

        holder.topicUserAvatar.setImageURI(Uri.parse("https://testerhome.com" + topic.getUser().getAvatar_url()));

        holder.textViewTopicTitle.setText(topic.getTitle());

        holder.topicUsername.setText(topic.getUser().getName());
        holder.topicPublishDate.setText(topic.getCreated_at());
        holder.topicName.setText(topic.getNode_name());
    }

    public class TopicItemViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.sdv_topic_user_avatar)
        SimpleDraweeView topicUserAvatar;

        @Bind(R.id.tv_topic_title)
        TextView textViewTopicTitle;

        @Bind(R.id.tv_topic_username)
        TextView topicUsername;

        @Bind(R.id.tv_topic_publish_date)
        TextView topicPublishDate;

        @Bind(R.id.tv_topic_name)
        TextView topicName;

        public TopicItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
