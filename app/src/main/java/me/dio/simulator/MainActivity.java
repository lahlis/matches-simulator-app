package me.dio.simulator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.dio.simulator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}

/* Notes:

//lateinit: late initialization (isn't initializing in constructor)
//Using view binding: 1) create binding (to accesss the views); 2) inflate(): 'binding = LayoutFileName.inflate(layoutInflater)'; 3) setContentView(binding.root)*
//*getRoot(): method included in binding class that provide a direct reference for the root view of the layout file (activity_main.xml)

---------------------------------------------------------------------------------------------------------------------------------------- */


