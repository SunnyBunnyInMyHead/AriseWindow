package com.example.a12.arisewindow;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.GridView;
import android.widget.TextView;

public class CustomDialog extends AlertDialog {

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog);
        TextView textView = (TextView) findViewById(R.id.textView);
        initNumberGV(textView);
        initAlphabetGV(textView);
    }


    private void initAlphabetGV(final TextView textView){
        GridView gridViewA = findViewById(R.id.gridOfAlphabet);
        String [] numbers = getContext().getResources().getStringArray(R.array.alphabet);
        gridViewA.setAdapter(new ButtonAdapter(getContext(), numbers, new ButtonClickListener() {
            @Override
            public void ButtonOnClick(Character symbol) {
                textView.setText(String.valueOf(textView.getText())+symbol);
            }
        }));
        //gridViewA.setOnItemClickListener();
    }
    private void initNumberGV(final TextView textView){
        GridView gridViewN = findViewById(R.id.gridOfNumbers);
        String [] numbers = getContext().getResources().getStringArray(R.array.numbers);
        gridViewN.setAdapter(new ButtonAdapter(getContext(), numbers, new ButtonClickListener() {
            @Override
            public void ButtonOnClick(Character symbol) {
                textView.setText(String.valueOf(textView.getText())+symbol);
            }
        }));
    }


}
