package com.smartron.sid.bytridgesample.infoMVP;

import com.smartron.sid.bytridgesample.model.HorizontalScrollLayout;
import com.smartron.sid.bytridgesample.model.SwaggeredLayout;

import java.util.List;

public interface InfoInteractor {
    void startNetworkCall(OnNetworkCallFinishFinish onNetworkCallFinishFinish);

    interface OnNetworkCallFinishFinish {

        void onHorizontolLayoutResponse(List<HorizontalScrollLayout> horizontalScrollLayouts);

        void onSwaggeredLayoutResponse(List<SwaggeredLayout> swaggeredLayouts);

        void onDetailsFetchFaliure(String message);

    }
}
