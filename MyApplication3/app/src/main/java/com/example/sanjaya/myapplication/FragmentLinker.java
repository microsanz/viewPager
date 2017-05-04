package com.example.sanjaya.myapplication;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by sanjaya on 4/10/2017.
 */

public class FragmentLinker extends Fragment {
    private int index;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<ItemModel> itemModelArrayList;

    public static FragmentLinker newInstance(int index, String title){
        FragmentLinker fragmentLinker=new FragmentLinker();
        Bundle args=new Bundle();
        args.putInt("index",index);
        args.putString("title",title);
        fragmentLinker.setArguments(args);
        return fragmentLinker;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index=getArguments().getInt("idx");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.layout_recycle,container,false);
        itemModelArrayList=new ArrayList<>();
        for(int i=1;i<=10;i++){
            itemModelArrayList.add(new ItemModel(String.valueOf(i)));
        }
        recyclerAdapter=new RecyclerAdapter(itemModelArrayList,getActivity());
        recyclerView=(RecyclerView) view.findViewById(R.id.layoutrecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }
}
