package pl.adriankurek.samplemvvmapp.models;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository instance;
    private List<User> users = new ArrayList<>();

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }

        return instance;
    }

    // Get users from data source.
    public MutableLiveData<List<User>> getUsers() {
        setUsers();

        MutableLiveData<List<User>> data = new MutableLiveData<>();
        data.setValue(users);

        return data;
    }

    // Set sample users.
    public void setUsers() {
        for (int i = 0; i < 5; i++)
            users.add(User.getRandomUser());
    }
}