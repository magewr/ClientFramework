package com.example.wr.clientframework.ui.content.main;

import com.example.wr.clientframework.data.remote.dto.SampleDTO;
import com.example.wr.clientframework.interactor.GetSampleDTOUseCase;
import com.example.wr.clientframework.ui.base.Presenter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by WR on 2017-11-27.
 */

public class MainPresenter extends Presenter<MainContract.View> implements MainContract.Presenter {

    GetSampleDTOUseCase useCase;

    @Inject
    public MainPresenter(GetSampleDTOUseCase useCase){
        this.useCase = useCase;
    }

    @Override
    public void getSampleData() {
        useCase.execute(new SampleDataObserver(), null);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getSampleData();
    }

    private final class SampleDataObserver extends DisposableObserver<SampleDTO> {
        @Override
        public void onNext(SampleDTO sampleDTO) {
            getView().showSampleData(sampleDTO);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }

}
