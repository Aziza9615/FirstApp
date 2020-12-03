package com.example.firstapp.ui.Contacts.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.R
import android.support.v7.widget.Toolbar
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_detail_contact.*

public class DetailContactActivity : AppCompatActivity() {
    private Toolbar toolbar:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar)
    }
}