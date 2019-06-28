package info.fahrifirdaus.twitter.twitterclone.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import info.fahrifirdaus.twitter.twitterclone.R;
import info.fahrifirdaus.twitter.twitterclone.models.Friend;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendHolderView> {
    private ArrayList<Friend> friendList;

    public FriendAdapter(ArrayList<Friend> friendList) {
        this.friendList = friendList;
    }

    @NonNull
    @Override
    public FriendHolderView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflater = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.friend_item, viewGroup, false);
        FriendHolderView viewHolder = new FriendHolderView(inflater);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolderView friendHolderView, int i) {
        friendHolderView.txtUsername.setText((friendList.get(i)).getUsername());
        friendHolderView.txtName.setText((friendList.get(i)).getName());
    }

    @Override
    public int getItemCount() {
        return this.friendList.size();
    }

    public class FriendHolderView extends RecyclerView.ViewHolder {
        public TextView txtUsername;
        public TextView txtName;

        public FriendHolderView(View itemView) {
            super(itemView);

            this.txtUsername = itemView.findViewById(R.id.txt_username);
            this.txtName = itemView.findViewById(R.id.txt_friend_name);
        }
    }

}
