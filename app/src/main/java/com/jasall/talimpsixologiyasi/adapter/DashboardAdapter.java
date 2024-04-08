package com.jasall.talimpsixologiyasi.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.jasall.talimpsixologiyasi.DashboardFragment;
import com.jasall.talimpsixologiyasi.DataModel;
import com.jasall.talimpsixologiyasi.R;
import com.jasall.talimpsixologiyasi.databinding.DashboardItemBinding;
import com.jasall.talimpsixologiyasi.model.DashboardItem;

import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>{

    private Activity context;
    private List<DashboardItem> list;
    private DataModel model;

    public DashboardAdapter(Activity context, List<DashboardItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DashboardItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.dashboard_item,
                parent,
                false
        );
        return new DashboardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        DashboardItem dashboardItem = list.get(position);

        holder.binding.setDashboard(dashboardItem);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DashboardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private DashboardItemBinding binding;

        public DashboardViewHolder(@NonNull DashboardItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.card.setOnClickListener(this);
            model = new ViewModelProvider((ViewModelStoreOwner) context).get(DataModel.class);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position == 0) {
                Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_maruzaFragment);
            } else if (position == 1) {
                Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_amaliyIshlar);
            } else if (position == 2) {
                model.getPdfName().setValue("Test savollari");
                Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_pdfFragment);
            }else if (position == 3) {
                model.getPdfName().setValue("Terminlar");
                Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_pdfFragment);
            }
        }
    }
}
