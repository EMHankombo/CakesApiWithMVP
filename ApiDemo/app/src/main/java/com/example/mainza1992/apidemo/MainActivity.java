package com.example.mainza1992.apidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mainza1992.apidemo.data.AppDataManager;
import com.example.mainza1992.apidemo.data.network.model.CakeListModel;
import com.example.mainza1992.apidemo.data.network.service.IRequestInterface;
import com.example.mainza1992.apidemo.ui.cakeList.CakeListPresenter;
import com.example.mainza1992.apidemo.ui.cakeList.ICakeListMvpView;
import com.example.mainza1992.apidemo.utils.rx.AppSchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements ICakeListMvpView{
    private IRequestInterface iRequestInterface;
    private RecyclerView recyclerView;

   private CakeListPresenter<ICakeListMvpView> cakeListMvpViewCakeListPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeRecycler();

        cakeListMvpViewCakeListPresenter = new CakeListPresenter<>(new AppDataManager(),new AppSchedulerProvider(),new CompositeDisposable());
        cakeListMvpViewCakeListPresenter.onAttach(this);
        cakeListMvpViewCakeListPresenter.onViewPrepared();


    }


    public void initializeRecycler(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerCakes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    @Override
    public void onFetchDataCompleted(List<CakeListModel> cakeListModels) {
        Log.i("CakesList",cakeListModels.get(0).getTitle());
        recyclerView.setAdapter(new CakeListAdapter(cakeListModels,R.layout.row,getApplicationContext()));


    }

    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }


}
