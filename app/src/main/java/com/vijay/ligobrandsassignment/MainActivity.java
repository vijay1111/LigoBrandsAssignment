package com.vijay.ligobrandsassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecylcerAdapter recylcerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add).setOnClickListener(this);

        RecyclerView rvItems = (RecyclerView) findViewById(R.id.rv_items);
        rvItems.setLayoutManager(ChipsLayoutManager.newBuilder(this)
                .setOrientation(ChipsLayoutManager.HORIZONTAL)
                .build());
        recylcerAdapter = new RecylcerAdapter(this);
        rvItems.setAdapter(recylcerAdapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_add:
                recylcerAdapter.addItem(((AppCompatEditText) findViewById(R.id.et_input)).getText().toString().trim());
                break;

        }
    }
}
