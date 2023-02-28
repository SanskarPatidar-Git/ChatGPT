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
    public ChatAdapter(Context context , List<ChatModel> chatModels){
        this.context=context;
        this.chatModels = chatModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
       if(viewType == AppConstants.SENDER_TYPE){
           view = LayoutInflater.from(context).inflate(R.layout.listitem_sender_question,parent,false);
           return new SenderViewHolder(view);
       }else{
           view = LayoutInflater.from(context).inflate(R.layout.listitem_receiver_answer,parent,false);
           return new ReceiverViewHolder(view);
       }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case AppConstants.SENDER_TYPE : //((SenderViewHolder)holder).chat.setText(chatModels.get(position).getData());
            case AppConstants.RECEIVER_TYPE : ((SenderViewHolder)holder).chat.setText(chatModels.get(position).getData());
                                             break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(chatModels.get(position).getType()==AppConstants.SENDER_TYPE)
            return 0;
        else if(chatModels.get(position).getType()==AppConstants.RECEIVER_TYPE)
            return 1;
        else
            return -1;
    }

    @Override
    public int getItemCount() {
        return chatModels.size();
    }
    public class SenderViewHolder extends RecyclerView.ViewHolder {
        TextView chat;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
           chat = itemView.findViewById(R.id.chat_tv);
        }
    }
    public class ReceiverViewHolder extends RecyclerView.ViewHolder{
        TextView chat;
        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);
            chat = itemView.findViewById(R.id.chat_tv);
        }
    }
}
