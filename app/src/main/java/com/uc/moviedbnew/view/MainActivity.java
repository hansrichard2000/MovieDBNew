package com.uc.moviedbnew.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.uc.moviedbnew.R;
import com.uc.moviedbnew.model.Movies;
import com.uc.moviedbnew.viewModel.MovieViewModel;

public class MainActivity extends AppCompatActivity {

    private MovieViewModel viewModel;
    private Button btn_hit;
    private TextInputLayout til_movie_id;
    private TextView txt_show;
    private static final String TAG = "MainActivity";
    private static final String TEXT_CONTENTS = "TextContent";
    private static final String TEXT_CONTENTS2 = "TextContent2";
    String movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(MainActivity.this).get(MovieViewModel.class);
        txt_show = findViewById(R.id.txt_show_main);
        til_movie_id = findViewById(R.id.til_movie_id_main);
        btn_hit = findViewById(R.id.btn_submit_main);
        btn_hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieId = til_movie_id.getEditText().getText().toString().trim();
                if (movieId.isEmpty()){
                    til_movie_id.setError("Please fill movie id field!");
                }else {
                    til_movie_id.setError(null);
                    viewModel.getMovieById(movieId);
                    viewModel.getResultGetMovieById().observe(MainActivity.this, showResultMovie);
                }

            }
        });
    }

    private Observer<Movies> showResultMovie = new Observer<Movies>() {
        @Override
        public void onChanged(Movies movies) {
            try {
                String title = movies.getTitle();
                txt_show.setText(title);
            }catch (Exception e){
                txt_show.setText("Unavailable");
            }

        }
    };


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final String savedString = savedInstanceState.getString(TEXT_CONTENTS, "");
        final String savedString2 = savedInstanceState.getString(TEXT_CONTENTS2, "");
        txt_show.setText(savedString2);
        til_movie_id.getEditText().setText(savedString);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_CONTENTS, til_movie_id.getEditText().getText().toString().trim());
        outState.putString(TEXT_CONTENTS2, txt_show.getText().toString());
    }
}