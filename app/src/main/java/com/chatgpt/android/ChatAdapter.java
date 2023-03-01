package com.chatgpt.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ChatModel> chatModels;
    public ChatAdapter(Context context){
        this.context=context;
    }
    public void setListData(List<ChatModel> magierEntities){
        this.chatModels = magierEntities;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
       if(viewType == AppConstants.SENDER_TYPE){
           viewHolder =  new SenderViewHolder(LayoutInflater.from(context).inflate(R.layout.listitem_sender_question,parent,false));
       }else{
           viewHolder = new ReceiverViewHolder(LayoutInflater.from(context).inflate(R.layout.listitem_receiver_answer,parent,false));
       }
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case AppConstants.SENDER_TYPE :   ((SenderViewHolder)holder).message.setText(chatModels.get(position).getData());
                                               break;
            case AppConstants.RECEIVER_TYPE : ((ReceiverViewHolder)holder).message.setText(chatModels.get(position).getData());
                                               break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(chatModels.get(position).getType()==AppConstants.SENDER_TYPE)
            return AppConstants.SENDER_TYPE;
        else if(chatModels.get(position).getType()==AppConstants.RECEIVER_TYPE)
            return AppConstants.RECEIVER_TYPE;
        else
            return -1;
    }

    @Override
    public int getItemCount() {
        return chatModels.size();
    }
    public class SenderViewHolder extends RecyclerView.ViewHolder {
        TextView message;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
           message = itemView.findViewById(R.id.message);
        }
    }
    public class ReceiverViewHolder extends RecyclerView.ViewHolder{
        TextView message;
        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);
            message= itemView.findViewById(R.id.message);
        }
    }
}
