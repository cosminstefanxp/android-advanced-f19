package ro.example.android.main;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ro.example.android.R;
import ro.example.android.core.BaseActivity;
import ro.example.android.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = viewBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainAdapter adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setArticles(ArticleKt.getTestArticles());
    }
}
