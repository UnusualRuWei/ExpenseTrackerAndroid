package com.eldroid.expensetrackerandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    private final List<String> buttonTexts;
    private final OnButtonClickListener listener;

    public interface OnButtonClickListener {
        void onButtonClick(int position);
    }

    public ButtonAdapter(List<String> buttonTexts, OnButtonClickListener listener) {
        this.buttonTexts = buttonTexts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false);
        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        String text = buttonTexts.get(position);
        holder.button.setText(text);
        holder.button.setOnClickListener(v -> listener.onButtonClick(position));
    }

    @Override
    public int getItemCount() {
        return buttonTexts.size();
    }

    static class ButtonViewHolder extends RecyclerView.ViewHolder {
        Button button;

        ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.item_button);
        }
    }
}
