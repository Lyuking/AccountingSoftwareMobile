package ru.pin120.luka.accountingsoftwaremobile.ui.installedsoftware;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InstalledSoftwareViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> selectedAudience;

    public InstalledSoftwareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(null);
        selectedAudience = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
    public MutableLiveData<String> getSelectedAudience() {
        return selectedAudience;
    }
}
