package com.geektech.quizapp_gt_4_2.ux.data.remote;

public interface GenericCallBack<T>{
        void onSuccess(T result);

        void onFailure(Exception e);

}

