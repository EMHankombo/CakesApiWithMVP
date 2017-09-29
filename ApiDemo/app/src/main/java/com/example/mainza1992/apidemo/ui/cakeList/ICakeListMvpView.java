package com.example.mainza1992.apidemo.ui.cakeList;

import com.example.mainza1992.apidemo.data.network.model.CakeListModel;
import com.example.mainza1992.apidemo.ui.base.MvpView;

import java.util.List;

/**
 * Created by mainza1992 on 29/09/2017.
 */

public interface ICakeListMvpView extends MvpView {

    void onFetchDataCompleted(List<CakeListModel> cakeListModels);
}
