package ru.pin120.luka.accountingsoftwaremobile.ui.software;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SoftwareViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SoftwareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(null);
    }

    public LiveData<String> getText() {
        return mText;
    }
}