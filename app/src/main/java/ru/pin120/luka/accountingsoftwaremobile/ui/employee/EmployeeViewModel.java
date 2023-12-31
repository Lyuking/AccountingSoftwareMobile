package ru.pin120.luka.accountingsoftwaremobile.ui.employee;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EmployeeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EmployeeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(null);
    }

    public LiveData<String> getText() {
        return mText;
    }
}