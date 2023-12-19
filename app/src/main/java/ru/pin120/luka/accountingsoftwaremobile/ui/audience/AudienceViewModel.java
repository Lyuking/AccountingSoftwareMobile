package ru.pin120.luka.accountingsoftwaremobile.ui.audience;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AudienceViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AudienceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(null);
    }

    public LiveData<String> getText() {
        return mText;
    }
}