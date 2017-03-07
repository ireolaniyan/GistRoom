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

public class SettingsFragment extends Fragment {
    private RecyclerView mSettingsRecyclerView;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_settings_list, container, false);

        mSettingsRecyclerView = (RecyclerView) view.findViewById(R.id.settings_recycler_view);
        mSettingsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public class SettingsHolder extends RecyclerView.ViewHolder{
        private TextView mSettingsTextView;

        public SettingsHolder(View itemView) {
            super(itemView);
            mSettingsTextView = (TextView) itemView.findViewById(R.id.settings_list_items);
        }
    }

    public class SettingsAdapter extends RecyclerView.Adapter<SettingsHolder>{

        @Override
        public SettingsHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        }

        @Override
        public void onBindViewHolder(SettingsHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
