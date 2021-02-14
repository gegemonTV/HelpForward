package com.minerva.helpforward;

import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    ShapeableImageView userImage;
    TextView username;

    FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
    public ProfileFragment(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        userImage = (ShapeableImageView) rootView.findViewById(R.id.user_image);
        username = (TextView) rootView.findViewById(R.id.nickname);
        username.setText(mUser.getDisplayName().toString());

        Uri imageUri = mUser.getPhotoUrl();
        if (imageUri != null){
            Log.d("URI", "onCreateView: "+imageUri.toString());
        }else{
            Log.d("URI", "onCreateView: No image");
        }


        return rootView;
    }
}
