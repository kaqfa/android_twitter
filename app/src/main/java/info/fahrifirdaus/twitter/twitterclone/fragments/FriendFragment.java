package info.fahrifirdaus.twitter.twitterclone.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import info.fahrifirdaus.twitter.twitterclone.R;
import info.fahrifirdaus.twitter.twitterclone.adapters.FriendAdapter;
import info.fahrifirdaus.twitter.twitterclone.models.Friend;


public class FriendFragment extends Fragment {

    ArrayList<Friend> friendList;
    RecyclerView friendRecycler;
    RecyclerView.LayoutManager layout;
    RecyclerView.Adapter adapter;

    public FriendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        friendList = new ArrayList<>();
        genData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        friendRecycler = (RecyclerView) view.findViewById(R.id.recycler_friend);
        friendRecycler.setHasFixedSize(true);

        layout = new LinearLayoutManager(getContext());
        friendRecycler.setLayoutManager(layout);

        adapter = new FriendAdapter(friendList);
        friendRecycler.setAdapter(adapter);
        return view;
    }

    private void genData() {
        friendList.clear();
        friendList.add(new Friend("kaqfa", "Fahri Firdausillah", "http://instagram.com/kaqfa.jpg"));
        friendList.add(new Friend("chiwink", "Annisa Dwi Anggraini", "http://instagram.com/chiwink.jpg"));
        friendList.add(new Friend("fajrida", "Fajri Nur Frida", "http://instagram.com/fajrida.jpg"));
        friendList.add(new Friend("chamoeslem", "Ericha Uda", "http://instagram.com/chamoeslem.jpg"));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
