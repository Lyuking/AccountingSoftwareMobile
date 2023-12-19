package ru.pin120.luka.accountingsoftwaremobile.ui.computer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComputerViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ComputerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(null);
    }

    public LiveData<String> getText() {
        return mText;
    }
}