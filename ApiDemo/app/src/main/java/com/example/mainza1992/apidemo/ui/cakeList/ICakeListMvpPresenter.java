package com.example.mainza1992.apidemo.ui.cakeList;

import com.example.mainza1992.apidemo.ui.base.MvpPresenter;

/**
 * Created by mainza1992 on 29/09/2017.
 */

public interface ICakeListMvpPresenter < V extends  ICakeListMvpView> extends MvpPresenter<V>{

    void onViewPrepared();
}
