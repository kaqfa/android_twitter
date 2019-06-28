package info.fahrifirdaus.twitter.twitterclone.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import info.fahrifirdaus.twitter.twitterclone.models.Post;
import info.fahrifirdaus.twitter.twitterclone.adapters.PostAdapter;
import info.fahrifirdaus.twitter.twitterclone.R;

public class DashboardFragment extends Fragment {

    ArrayList<Post> postList;
    RecyclerView postRecycler;
    RecyclerView.LayoutManager layout;
    RecyclerView.Adapter adapter;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postList = new ArrayList<>();
        genData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        postRecycler = (RecyclerView) view.findViewById(R.id.recycler_post);
        postRecycler.setHasFixedSize(true);
        layout = new LinearLayoutManager(getContext());
        postRecycler.setLayoutManager(layout);

        adapter = new PostAdapter(postList);
        postRecycler.setAdapter(adapter);

        return view;
    }

    private void genData(){
        postList.clear();
        postList.add(new Post("Fahri", "Postingan pertama", 150000));
        postList.add(new Post("Nissa", "Postingan biasa aja", 150001));
        postList.add(new Post("Ida", "Postingan yang sangat wah", 1500212));
        postList.add(new Post("Ratih", "Postingan kok ngene banget", 1500002));
        postList.add(new Post("Andre", "Postingan terakhir", 150090));
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
