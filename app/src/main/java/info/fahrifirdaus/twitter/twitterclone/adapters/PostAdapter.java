package info.fahrifirdaus.twitter.twitterclone.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import info.fahrifirdaus.twitter.twitterclone.models.Post;
import info.fahrifirdaus.twitter.twitterclone.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private ArrayList dataList;

    public PostAdapter(ArrayList<Post> postList) {
        dataList = postList;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item, viewGroup, false);
        PostViewHolder viewHolder = new PostViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder viewHolder, int position) {
        viewHolder.txtName.setText(((Post)dataList.get(position)).getName());
        viewHolder.txtContent.setText(((Post)dataList.get(position)).getContent());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        public TextView txtName;
        public TextView txtContent;

        public PostViewHolder(View view) {
            super(view);
            this.txtName = view.findViewById(R.id.txt_post_name);
            this.txtContent = view.findViewById(R.id.txt_post_content);
        }
    }
}
