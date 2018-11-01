package com.smartron.sid.bytridgesample.infoMVP;

import com.smartron.sid.bytridgesample.model.HorizontalScrollLayout;
import com.smartron.sid.bytridgesample.model.SwaggeredLayout;

import java.util.List;

public class InfoPresenterImpl implements InfoPresenter,InfoInteractor.OnNetworkCallFinishFinish {

    private InfoInteractor infoInteractor;
    private InfoView infoView;

    public InfoPresenterImpl(InfoView infoView){
        this.infoView = infoView;
        infoInteractor = new InfoInteractorImpl();

    }

    @Override
    public void onHorizontolLayoutResponse(List<HorizontalScrollLayout> horizontalScrollLayouts) {

        infoView.dismisProgress();
        infoView.horizontolLayoutDataFetchSuccess(horizontalScrollLayouts);

    }

    @Override
    public void onSwaggeredLayoutResponse(List<SwaggeredLayout> swaggeredLayouts) {

        infoView.dismisProgress();
        infoView.swaggeredlayoutDataFetchSuccess(swaggeredLayouts);

    }

    @Override
    public void onDetailsFetchFaliure(String message) {

        infoView.dismisProgress();
        infoView.onDetailsFetchFaliure(message);
    }

    @Override
    public void doNewtworkCall() {
        infoView.showProgress();
        infoInteractor.startNetworkCall(this);
    }

    @Override
    public void onDestroy() {
        infoView.dismisProgress();
        if (infoView!=null){
            infoView = null;
        }

    }
}
