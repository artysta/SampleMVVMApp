package pl.adriankurek.samplemvvmapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pl.adriankurek.samplemvvmapp.models.User;
import pl.adriankurek.samplemvvmapp.models.UserRepository;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;
    private UserRepository repository;

    public void init() {
        if (users != null) return;

        repository = UserRepository.getInstance();
        users = repository.getUsers();
    }

    public void addUser(User user) {
        List<User> currentUsers = users.getValue();

        if (user != null)
            currentUsers.add(user);

        users.postValue(currentUsers);
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }
}
