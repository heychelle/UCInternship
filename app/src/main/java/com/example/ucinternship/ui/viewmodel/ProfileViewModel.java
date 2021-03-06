package com.example.ucinternship.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.model.local.Supervisor;
import com.example.ucinternship.model.response.StudentResponse;
import com.example.ucinternship.model.response.SupervisorResponse;
import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.repository.ProfileRepository;
import com.example.ucinternship.repository.ProjectRepository;

import java.util.List;

public class ProfileViewModel extends ViewModel {

    private ProfileRepository repository;

    public ProfileViewModel() {

    }

    public void init(String token) {
        repository = ProfileRepository.getInstance(token);
    }

    public LiveData<Student> getStudentDetails(int id) {
        return repository.getStudentDetails(id);
    }
    public LiveData<Supervisor> getSupervisorDetails(int id) {
        return repository.getSupervisorDetails(id);
    }
    public MutableLiveData<StudentResponse> updateStudent(int id, String phone, String line_account) {
        return repository.updateStudent(id, phone, line_account);
    }
    public MutableLiveData<SupervisorResponse> updateSupervisor(int id, String phone, String line_account) {
        return repository.updateSupervisor(id, phone, line_account);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
