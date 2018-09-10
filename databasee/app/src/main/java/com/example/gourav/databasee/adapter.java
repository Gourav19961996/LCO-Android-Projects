package com.example.gourav.databasee;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder>{

    Context context;
    List<datamodel> list1;

    public adapter(Context context, List<datamodel> list1){
        this.context=context;
        this.list1=list1;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View v=inflater.inflate(R.layout.contact,viewGroup,false);
        viewholder vh=new viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder h, int i) {

        //Toast.makeText(context, "adaptermeya"+list1.get(i).getName(), Toast.LENGTH_SHORT).show();
       datamodel jk=list1.get(i);
       h.t1.setText(jk.getName());
       h.t2.setText(jk.getContact());
        h.t3.setText(jk.getEmail());
        h.t4.setText(jk.getAddress());

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView t1,t2,t3,t4;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t4=itemView.findViewById(R.id.t4);
        }
    }
}
