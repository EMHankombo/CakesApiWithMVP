package com.example.mainza1992.apidemo.ui.cakeList;

import com.example.mainza1992.apidemo.data.DataManager;
import com.example.mainza1992.apidemo.data.network.model.CakeListModel;
import com.example.mainza1992.apidemo.ui.base.BasePresenter;
import com.example.mainza1992.apidemo.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by mainza1992 on 29/09/2017.
 */

public class CakeListPresenter <V extends ICakeListMvpView> extends BasePresenter<V>  implements ICakeListMvpPresenter<V>{

    public CakeListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

        getCompositeDisposable()
                .add(getDataManager().useCaseCakeList()
                        .observeOn(getSchedulerProvider().ui())
                        .subscribeOn(getSchedulerProvider().io())
                        .subscribe(new Consumer<List<CakeListModel>>() {
                                       @Override
                                       public void accept(@NonNull List<CakeListModel> cakeListModels) throws Exception {
                                           getMvpView().onFetchDataCompleted(cakeListModels);

                                       }
                                   },
                                new Consumer<Throwable>() {
                                    @Override
                                    public void accept(@NonNull Throwable throwable) throws Exception {
                                        getMvpView().onError(throwable.getMessage());

                                    }
                                }));
    };
}
