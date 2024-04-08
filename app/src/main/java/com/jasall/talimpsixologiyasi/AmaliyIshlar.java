package com.jasall.talimpsixologiyasi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jasall.talimpsixologiyasi.databinding.FragmentAmaliyIshlarBinding;
import com.jasall.talimpsixologiyasi.databinding.FragmentMaruzaBinding;

public class AmaliyIshlar extends Fragment {

    private FragmentAmaliyIshlarBinding binding;
    private ArrayAdapter adapter;
    private DataModel model;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAmaliyIshlarBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(getActivity()).get(DataModel.class);
        adapter = ArrayAdapter.createFromResource(getContext(),R.array.amaliylar, android.R.layout.simple_list_item_1);

        binding.listViewAmaliylar.setAdapter(adapter);

        binding.listViewAmaliylar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView v = (TextView) view;
                model.getPdfName().setValue(v.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_amaliyIshlar_to_pdfFragment);
            }
        });

    }
}