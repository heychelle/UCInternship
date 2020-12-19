package com.example.ucinternship.ui.logout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.repository.AuthRepository;
import com.example.ucinternship.repository.LogoutRepository;
import com.example.ucinternship.repository.ProjectRepository;

public class LogoutViewModel  extends ViewModel {
    private LogoutRepository repository;

    public LogoutViewModel() {

    }
    public void init(String token){
        repository = LogoutRepository.getInstance(token);
    }

    public LiveData<String> logout() {
        return repository.logout();
    }
}
