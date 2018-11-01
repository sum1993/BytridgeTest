package com.smartron.sid.bytridgesample.infoMVP;

import com.smartron.sid.bytridgesample.model.HorizontalScrollLayout;
import com.smartron.sid.bytridgesample.model.SwaggeredLayout;

import java.util.List;

public interface InfoView {
    void showProgress();
    void dismisProgress();
    void horizontolLayoutDataFetchSuccess(List<HorizontalScrollLayout> horizontalScrollLayout);
    void swaggeredlayoutDataFetchSuccess(List<SwaggeredLayout> swaggeredLayout);
    void onDetailsFetchFaliure(String message);
}
