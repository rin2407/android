package com.example.danhgiasao.screen.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.example.danhgiasao.R;
import com.example.danhgiasao.model.User;
import com.example.danhgiasao.screen.home.adapter.HomeAdapter;
import com.example.danhgiasao.screen.main.MainActivity;
import com.example.danhgiasao.util.onClickFragmentInterface;

public class HomeFragment extends Fragment implements HomeAdapter.onClickContentViewItem{

    private List<User> userList = new ArrayList<>();
    public HomeAdapter mainAdapter;
    public static onClickFragmentInterface listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initView(rootView);
        return rootView;
    }

    @SuppressLint("NewApi")
    private void initView(View a) {

        RecyclerView recyclerView = a.findViewById(R.id.content);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        userList = addProfile(userList);

        mainAdapter = new HomeAdapter(userList, getActivity());
        mainAdapter.setClickContentViewItem(this);
        recyclerView.setAdapter(mainAdapter);
    }

    private List<User> addProfile(List<User> users) {

        User.UserBuilder userBuilder = new User.UserBuilder();

        users.add(userBuilder.id(0)
                .image(R.drawable.anh01)
                .name("Monkey D.Luffy")
                .birthday("04/12/2000")
                .build());
        users.add(userBuilder.id(1)
                .image(R.drawable.anh02)
                .name("Monkey D.Luffy")
                .birthday("16/02/2000")
                .build());
        users.add(userBuilder.id(2)
                .image(R.drawable.anh03)
                .name("Roronoa Zoro")
                .birthday("01/03/1998")
                .build());
        users.add(userBuilder.id(3)
                .image(R.drawable.anh04)
                .name("Roronoa Zoro")
                .birthday("15/12/1998")
                .build());
        users.add(userBuilder.id(4)
                .image(R.drawable.anh05)
                .name("Traf law")
                .birthday("08/07/1999")
                .build());
        users.add(userBuilder.id(5)
                .image(R.drawable.anh06)
                .name("Chopper")
                .birthday("03/09/1998")
                .build());
        return users;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            listener = (onClickFragmentInterface) context; // gan listener vao MainActivity
        else
            throw new RuntimeException(context.toString() + " must implement onViewSelected!");
    }

    @Override
    public void onClick(int position) {
        listener.onClickHomeFragment(userList.get(position));
    }
}
