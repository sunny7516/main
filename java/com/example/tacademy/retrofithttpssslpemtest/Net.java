package com.example.tacademy.retrofithttpssslpemtest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tacademy on 2017-02-20.
 */
public class Net {
    private static Net ourInstance = new Net();
    public static Net getInstance() {
        return ourInstance;
    }
    private Net() {
    }
    ////////////////////////////////////////////////////////////////////////
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ec2-52-79-161-180.ap-northeast-2.compute.amazonaws.com:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Retrofit getRetrofit() {
        return retrofit;
    }
    ////////////////////////////////////////////////////////////////////////
    MemberImpFactory memberImpFactory;

    public MemberImpFactory getMemberImpFactory() {
        if( memberImpFactory == null ){
            memberImpFactory = retrofit.create(MemberImpFactory.class);
        }
        return memberImpFactory;
    }
    ////////////////////////////////////////////////////////////////////////
}

















