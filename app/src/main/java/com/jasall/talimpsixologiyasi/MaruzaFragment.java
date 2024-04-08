package com.jasall.talimpsixologiyasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.jasall.talimpsixologiyasi.databinding.FragmentMaruzaBinding;

import java.util.ArrayList;

public class MaruzaFragment extends Fragment {

    private FragmentMaruzaBinding binding;
    private ArrayAdapter adapter;
    private DataModel model;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMaruzaBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(getActivity()).get(DataModel.class);
        adapter = ArrayAdapter.createFromResource(getContext(),R.array.maruzalar, android.R.layout.simple_list_item_1);

        binding.listViewMaruza.setAdapter(adapter);

        binding.listViewMaruza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView v = (TextView) view;
                model.getPdfName().setValue(v.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_maruzaFragment_to_pdfFragment);
            }
        });

    }


}


