package com.smartron.sid.bytridgesample.infoMVP;

import android.util.Log;

import com.smartron.sid.bytridgesample.model.GetCompleteResponse;
import com.smartron.sid.bytridgesample.network.NetworkHandler;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class InfoInteractorImpl implements InfoInteractor {

    @Override
    public void startNetworkCall(final OnNetworkCallFinishFinish onNetworkCallFinishFinish) {
        NetworkHandler.getInstance().restApiInstance().getDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCompleteResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCompleteResponse getCompleteResponse) {

                        if (getCompleteResponse.getResult()!=null && getCompleteResponse.getResult().getHorizontalScrollLayout()!=null
                                && getCompleteResponse.getResult().getSwaggeredLayout()!=null) {
                            onNetworkCallFinishFinish.onHorizontolLayoutResponse(getCompleteResponse.getResult().getHorizontalScrollLayout());
                            onNetworkCallFinishFinish.onSwaggeredLayoutResponse(getCompleteResponse.getResult().getSwaggeredLayout());
                        }else {
                            onNetworkCallFinishFinish.onDetailsFetchFaliure("Details cannot be empty");
                        }
                        Log.d("Complete details", getCompleteResponse.toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetworkCallFinishFinish.onDetailsFetchFaliure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
