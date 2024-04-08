package com.jasall.talimpsixologiyasi;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataModel extends ViewModel {

    private MutableLiveData<String> pdfName;

    public MutableLiveData<String> getPdfName() {
        if (pdfName == null) {
            pdfName = new MutableLiveData<>();
        }
        return pdfName;
    }


}
