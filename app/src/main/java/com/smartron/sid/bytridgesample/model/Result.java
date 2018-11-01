package com.smartron.sid.bytridgesample.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("horizontal_scroll_layout")
    @Expose
    private List<HorizontalScrollLayout> horizontalScrollLayout = null;
    @SerializedName("swaggered_layout")
    @Expose
    private List<SwaggeredLayout> swaggeredLayout = null;

    public List<HorizontalScrollLayout> getHorizontalScrollLayout() {
        return horizontalScrollLayout;
    }

    public void setHorizontalScrollLayout(List<HorizontalScrollLayout> horizontalScrollLayout) {
        this.horizontalScrollLayout = horizontalScrollLayout;
    }

    public List<SwaggeredLayout> getSwaggeredLayout() {
        return swaggeredLayout;
    }

    public void setSwaggeredLayout(List<SwaggeredLayout> swaggeredLayout) {
        this.swaggeredLayout = swaggeredLayout;
    }

}