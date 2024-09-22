package com.eldroid.expensetrackerandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;


public class CategoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private ButtonAdapter buttonAdapter;
    private ImageButton backButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView = rootView.findViewById(R.id.categoriesrecyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Sample categories
        List<String> buttonTexts = Arrays.asList("Food Expenses", "Transportation Expenses", "Other Expenses", "School Expenses");

        buttonAdapter = new ButtonAdapter(buttonTexts, position -> {

            Toast.makeText(getContext(), " Opening " + buttonTexts.get(position) + " Summary...", Toast.LENGTH_SHORT).show();
        });

        recyclerView.setAdapter(buttonAdapter);


        backButton = rootView.findViewById(R.id.categorybackbutton); // Adjust the ID if necessary

        backButton.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager.popBackStack(); // Go back to the previous fragment
        });

        return rootView;
    }
}