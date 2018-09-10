package com.example.gourav.finalcontactlist;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {

    Context context;
    List<String> list1;
    String TAG="hhbb";

    public adapter(Context context,List<String> list1){

        this.context=context;
        this.list1=list1;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onBindViewHolder: "+list1.size());

        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View v=inflater.inflate(R.layout.contactlist,viewGroup,false);
        viewholder vh=new viewholder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {

        String str1[]=list1.get(i).split(":");
        viewholder.t1.setText(str1[0].toString());
        viewholder.t2.setText(str1[1].toString());
        viewholder.t3.setText(str1[2].toString());
    }


    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);

        }
    }
}
