package com.jasall.talimpsixologiyasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jasall.talimpsixologiyasi.databinding.FragmentPdfBinding;

public class PdfFragment extends Fragment {

    private FragmentPdfBinding binding;
    private DataModel model;
    private String pdfNomi;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPdfBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(getActivity()).get(DataModel.class);

        model.getPdfName().observe(getActivity(), pdfName -> {
            pdfNomi = pdfName;
        });

        pdfNomi += ".pdf";

        binding.pdfViewer.fromAsset(pdfNomi)
                .load();
    }
}