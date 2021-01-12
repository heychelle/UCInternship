package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.repository.ProjectRepository;

import java.util.List;

public class ProjectViewModel extends ViewModel {
    private ProjectRepository repository;

    public ProjectViewModel() {

    }

    public void init(String token) {
        repository = ProjectRepository.getInstance(token);
    }

    public LiveData<List<Project>> getProjects() {
        return repository.getProjects();
    }

    public LiveData<List<Project>> getProjectOffers() {
        return repository.getProjectOffers();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
