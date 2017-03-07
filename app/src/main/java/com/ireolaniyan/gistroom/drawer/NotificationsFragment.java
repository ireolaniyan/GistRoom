package com.ireolaniyan.gistroom.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ireolaniyan.gistroom.R;

import java.util.ArrayList;

/**
 * Created by Ire Olaniyan on 12/4/2016.
 */
public class NotificationsFragment extends Fragment {
    private RecyclerView mNotificationsRecyclerView;
    final ArrayList<String> notifications = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_notifications_list, container, false);

        mNotificationsRecyclerView = (RecyclerView) view.findViewById(R.id.notifications_recycler_view);
        mNotificationsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateNotificationsUI();
        return view;
    }

    private void updateNotificationsUI(){
        RecyclerView.Adapter mNotificationAdapter;

        mNotificationAdapter = new NotificationAdapter(notifications);
        mNotificationsRecyclerView.setAdapter(mNotificationAdapter);
        mNotificationAdapter.notifyDataSetChanged();

    }

    public class NotificationHolder extends RecyclerView.ViewHolder {
        private TextView mNotificationsTextView;

        public NotificationHolder(View itemView) {
            super(itemView);

            mNotificationsTextView = (TextView) itemView.findViewById(R.id.list_notifications_textView);
        }
    }

    public class NotificationAdapter extends RecyclerView.Adapter<NotificationHolder>{

        ArrayList<String> mNotifications;

        public NotificationAdapter(ArrayList<String> notifications) {
            mNotifications = notifications;
        }

        @Override
        public NotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.list_item_notifications, parent, false);
            return new NotificationHolder(view);
        }

        @Override
        public void onBindViewHolder(NotificationHolder holder, int position) {
            holder.mNotificationsTextView.setText(mNotifications.get(position));
        }

        @Override
        public int getItemCount() {
            return mNotifications.size();
        }
    }
}
