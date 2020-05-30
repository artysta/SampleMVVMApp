package pl.adriankurek.samplemvvmapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import pl.adriankurek.samplemvvmapp.R;
import pl.adriankurek.samplemvvmapp.adapters.UserAdapter;
import pl.adriankurek.samplemvvmapp.models.User;
import pl.adriankurek.samplemvvmapp.viewmodels.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private BaseAdapter adapter;
    private UserViewModel userViewModel;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.init();

        userViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.notifyDataSetChanged();
            }
        });

        initListView();

        button = findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userViewModel.addUser(User.getRandomUser());
            }
        });
    }

    private void initListView() {
        adapter = new UserAdapter(this, userViewModel.getUsers().getValue());
        list.setAdapter(adapter);
    }
}
