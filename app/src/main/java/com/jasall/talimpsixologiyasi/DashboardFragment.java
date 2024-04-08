package com.jasall.talimpsixologiyasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jasall.talimpsixologiyasi.adapter.DashboardAdapter;
import com.jasall.talimpsixologiyasi.databinding.FragmentDashboardBinding;
import com.jasall.talimpsixologiyasi.model.DashboardItem;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DashboardAdapter adapter;
    private List<DashboardItem> list;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = new ArrayList<>();
        list.add(new DashboardItem(getResources().getDrawable(R.drawable.school),getString(R.string.maruzalar_text),getString(R.string.maruzalar_desc),getString(R.string.time_maruza)));
        list.add(new DashboardItem(getResources().getDrawable(R.drawable.pencil),"Amaliy ishlar","Amaliy ishlar soni 15 ta","15 dars, 30 soat"));
        list.add(new DashboardItem(getResources().getDrawable(R.drawable.test),"Testlar","Test ishlanmalari","1 dars, 2 soat"));
        list.add(new DashboardItem(null,"Terminlar",null,null));

        adapter = new DashboardAdapter(getActivity(),list);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recycler.setHasFixedSize(true);
        binding.recycler.setAdapter(adapter);

    }


}