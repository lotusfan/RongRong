package com.rongrong.model.requestview;

import com.rongrong.model.PictureTb;
import com.rongrong.model.PrCommentTb;
import com.rongrong.model.PrPraiseTb;
import com.rongrong.model.PrShareTb;

import java.util.List;

/**
 * Created by zhangfan on 2015/7/23.
 */
public class ProjectListView {

    private List<PrCommentTb> prCommentTbs; //评论列表
    private List<PrPraiseTb> prPraiseTbs; //点赞列表
    private List<PrShareTb> prShareTbs; //扩散列表
    private List<PictureTb> pictureTbs; //图象

    public List<PrCommentTb> getPrCommentTbs() {
        return prCommentTbs;
    }

    public void setPrCommentTbs(List<PrCommentTb> prCommentTbs) {
        this.prCommentTbs = prCommentTbs;
    }

    public List<PrPraiseTb> getPrPraiseTbs() {
        return prPraiseTbs;
    }

    public void setPrPraiseTbs(List<PrPraiseTb> prPraiseTbs) {
        this.prPraiseTbs = prPraiseTbs;
    }

    public List<PrShareTb> getPrShareTbs() {
        return prShareTbs;
    }

    public void setPrShareTbs(List<PrShareTb> prShareTbs) {
        this.prShareTbs = prShareTbs;
    }

    public List<PictureTb> getPictureTbs() {
        return pictureTbs;
    }

    public void setPictureTbs(List<PictureTb> pictureTbs) {
        this.pictureTbs = pictureTbs;
    }

    @Override
    public String toString() {
        return "ProjectListView{" +
                "pictureTbs=" + pictureTbs +
                ", prShareTbs=" + prShareTbs +
                ", prPraiseTbs=" + prPraiseTbs +
                ", prCommentTbs=" + prCommentTbs +
                '}';
    }
}
