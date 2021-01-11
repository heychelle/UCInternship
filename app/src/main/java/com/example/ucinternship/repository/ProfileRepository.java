package com.example.ucinternship.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.model.response.StudentResponse;
import com.example.ucinternship.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {

    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfileRepository";

    private ProfileRepository(String token) {
        Log.d(TAG, "ProfileRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }
    public static ProfileRepository getInstance(String token) {
        if (profileRepository == null) {
            profileRepository = new ProfileRepository(token);
        }
        return profileRepository;
    }

    public synchronized void resetInstance(){
        if (profileRepository != null) {
            profileRepository = null;
        }
    }

    public MutableLiveData<List<Student>> getStudentDetails(int id){
        MutableLiveData<List<Student>> listStudents = new MutableLiveData<>();
        apiService.getStudentDetails(id).enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {
                Log.d(TAG, "onResponse: "+ response.code());
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+ response.code());
                    if(response.body() != null){
                        Log.d(TAG, "onResponse: "+ response.body().getStudent_data().size());
                        listStudents.postValue(response.body().getStudent_data());
                        resetInstance();
                    }
                }
            }
            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getMessage());
            }
        });
        return listStudents;
    }


}
