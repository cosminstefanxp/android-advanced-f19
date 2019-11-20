package ro.example.android.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

import timber.log.Timber;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> numberLiveData = new MutableLiveData<>();

    public MainViewModel() {
        super();

        numberLiveData.setValue(new Random().nextInt() + "");
        Timber.d("Initialized ViewModel with %s", numberLiveData.getValue());

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            numberLiveData.postValue(Integer.toString(new Random().nextInt()));
        })
                .start();
    }
}
