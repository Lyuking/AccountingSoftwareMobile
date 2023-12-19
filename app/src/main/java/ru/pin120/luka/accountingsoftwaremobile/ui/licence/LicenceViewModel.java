package ru.pin120.luka.accountingsoftwaremobile.ui.licence;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LicenceViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LicenceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(null);
    }

    public LiveData<String> getText() {
        return mText;
    }
}