package com.example.yuan_wanandroid.model.http;

import com.example.yuan_wanandroid.model.entity.Articles;
import com.example.yuan_wanandroid.model.entity.BannerData;
import com.example.yuan_wanandroid.model.entity.BaseResponse;
import com.example.yuan_wanandroid.model.entity.FirstSystem;
import com.example.yuan_wanandroid.model.entity.Tab;
import com.example.yuan_wanandroid.model.entity.Login;
import com.example.yuan_wanandroid.model.http.api.HomeApis;
import com.example.yuan_wanandroid.model.http.api.PersonApis;
import com.example.yuan_wanandroid.model.http.api.ProjectApis;
import com.example.yuan_wanandroid.model.http.api.SystemApis;
import com.example.yuan_wanandroid.model.http.api.WxApis;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/01/21
 *     desc   : 对外隐藏进行网络请求的实现细节
 * </pre>
 */


public class NetworkHelperImpl implements NetworkHelper{
    private HomeApis mHomeApis;
    private SystemApis mSystemApis;
    private WxApis mWxApis;
    private ProjectApis mProjectApis;
    private PersonApis mPersonApis;

    @Inject
    public NetworkHelperImpl(HomeApis homeApis, SystemApis systemApis,WxApis wxApis,ProjectApis projectApis,PersonApis personApis){
        mHomeApis = homeApis;
        mSystemApis = systemApis;
        mWxApis = wxApis;
        mProjectApis =projectApis;
        mPersonApis = personApis;
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mHomeApis.getBannerData();
    }

    @Override
    public Observable<BaseResponse<Articles>> getArticles(int pageNum) {
        return mHomeApis.getArticles(pageNum);
    }

    @Override
    public Observable<BaseResponse<List<FirstSystem>>> getFirstSystemData() {
        return mSystemApis.getFirstSystemData();
    }

    @Override
    public Observable<BaseResponse<Articles>> getSecondSystemArticles(int pageNum, int id) {
        return mSystemApis.getSecondSystemArticles(pageNum,id);
    }

    @Override
    public Observable<BaseResponse<List<Tab>>> getWxTabs() {
        return mWxApis.getWxTabs();
    }

    @Override
    public Observable<BaseResponse<Articles>> getWxArticles(int pageNum, int id) {
        return mWxApis.getWxArticles(pageNum,id);
    }

    @Override
    public Observable<BaseResponse<List<Tab>>> getProjectTab() {
        return mProjectApis.getProjectTab();
    }

    @Override
    public Observable<BaseResponse<Articles>> getProjectArticles(int pageNum, int id) {
        return mProjectApis.getProjectArticles(pageNum,id);
    }

    @Override
    public Observable<BaseResponse<Login>> register(String username, String password, String rePassword) {
        return mPersonApis.register(username,password,rePassword);
    }

    @Override
    public Observable<BaseResponse<Login>> login(String username, String password) {
        return mPersonApis.login(username, password);
    }

    @Override
    public Observable<BaseResponse<Login>> logout() {
        return mPersonApis.logout();
    }


}
