package com.example.danhgiasao.screen.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import java.util.Objects;
import com.example.danhgiasao.R;
import com.example.danhgiasao.model.User;
import com.example.danhgiasao.screen.home.HomeFragment;
import com.example.danhgiasao.screen.main.MainActivity;
import com.example.danhgiasao.util.onClickFragmentInterface;


public class DetailFragment extends Fragment implements RatingBar.OnRatingBarChangeListener{

    private SharedPreferences.Editor mEditor;
    private User mUser;
    private ImageView mImageView;
    private TextView mName, mBirthday;
    private RatingBar mRatingBar;
    private SharedPreferences mPreferences;
    private onClickFragmentInterface mClickFragmentInterface;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initView(view);
        if (savedInstanceState != null){
            showInfo((User) savedInstanceState.getParcelable("user"));
        }
        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("CommitPrefEdits")
    private void initView(View view) {
        mImageView = view.findViewById(R.id.imageDetail);
        mName = view.findViewById(R.id.myName);
        mBirthday = view.findViewById(R.id.myBirthday);
        mRatingBar = view.findViewById(R.id.myRating);
        mPreferences = Objects.requireNonNull(getContext())
                .getSharedPreferences("Rating", Context.MODE_PRIVATE);

        mEditor = mPreferences.edit();
       // lưu đánh giá sao
       mRatingBar.setOnRatingBarChangeListener(this);

        if (mUser==null){
            mUser = new User.UserBuilder().id(0)
                    .image(R.drawable.anh01)
                    .name("mokey d luffy")
                    .birthday("04/12/2000")
                    .build();
            showInfo(mUser);
        }
    }


    public void showInfo(User user){
        mUser = user;
        mImageView.setImageResource(mUser.getImage());
        mName.setText(mUser.getName());
        mBirthday.setText(mUser.getBirthday());
        float rating = mPreferences.getFloat(mUser.getId() + "", 0);
        mRatingBar.setRating(rating);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mClickFragmentInterface = (onClickFragmentInterface) context; // gan listener vao MainActivity
        else
            throw new RuntimeException(context.toString() + " must implement onViewSelected!");
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        if (mUser!=null){
            mEditor.putFloat(mUser.getId() + "", v);
            mEditor.apply();
            Intent intent = new Intent();
            intent.putExtra("item", mUser.getId());
            mClickFragmentInterface.onClickDetailFragment(mUser.getId());
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("user", mUser);
    }

}
