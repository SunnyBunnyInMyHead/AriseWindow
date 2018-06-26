package com.example.a12.arisewindow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mainTextView = (TextView) findViewById(R.id.mainTextView);
//        CustomDialog customDialog = new CustomDialog(this);

        Button button = (Button) findViewById(R.id.mainButton);
        //error here
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View dialog_layout = inflater.inflate(R.layout.dialog, null, false);
                final TextView textView = (TextView) dialog_layout.findViewById(R.id.textView);
                initNumberGVnew(textView, dialog_layout);
                initAlphabetGVnew(textView, dialog_layout);
                AlertDialog.Builder db = new AlertDialog.Builder(MainActivity.this);
                db.setView(dialog_layout);
                db.setTitle("settings");
                db.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mainTextView.setText(textView.getText());
                    }
                });

                AlertDialog dialog = db.create();
                dialog.show();
            }
        });



    }

    private void initAlphabetGV(final TextView textView, View view) {
        GridView gridViewA = findViewById(R.id.gridOfAlphabet);

        String[] numbers = view.getContext().getResources().getStringArray(R.array.alphabet);
        gridViewA.setAdapter(new ButtonAdapter(view.getContext(), numbers, new ButtonClickListener() {
            @Override
            public void ButtonOnClick(Character symbol) {
                textView.setText(String.valueOf(textView.getText()) + symbol);
            }
        }));
    }

    private void initNumberGV(final TextView textView, View view) {
        GridView gridViewN = findViewById(R.id.gridOfNumbers);
        String[] numbers = view.getContext().getResources().getStringArray(R.array.numbers);
        gridViewN.setAdapter(new ButtonAdapter(view.getContext(), numbers, new ButtonClickListener() {
            @Override
            public void ButtonOnClick(Character symbol) {
                textView.setText(String.valueOf(textView.getText()) + symbol);
            }
        }));
    }

    private void initAlphabetGVnew(final TextView textView, View view) {
        GridView gridViewA = view.findViewById(R.id.gridOfAlphabet);
        final String[] alphabet = view.getContext().getResources().getStringArray(R.array.alphabet);
        gridViewA.setAdapter(new ButtonAdapter(view.getContext(), alphabet));
        gridViewA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(String.valueOf(textView.getText()) + alphabet[i]);
            }
        });
    }

    private void initNumberGVnew(final TextView textView, View view) {
        GridView gridViewN = view.findViewById(R.id.gridOfNumbers);
        final String[] numbers = view.getContext().getResources().getStringArray(R.array.numbers);
        gridViewN.setAdapter(new ButtonAdapter(view.getContext(), numbers));
        gridViewN.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(String.valueOf(textView.getText()) + numbers[i]);
            }
        });
    }


}
