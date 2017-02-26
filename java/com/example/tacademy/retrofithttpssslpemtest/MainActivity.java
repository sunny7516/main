package com.example.tacademy.retrofithttpssslpemtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 누르면 회원가입
                //onJoin();
            }
        });
    }
    // 회원가입
    public void onJoin(View view)
    {
        Call<ResAll> res = NetSSL.getInstance().getMemberImpFactory().join(
                new ReqAll("kokokoko_ID","kokoko_NAME","pop1@naver.com","11111111"));
        res.enqueue(new Callback<ResAll>() {
            @Override
            public void onResponse(Call<ResAll> call, Response<ResAll> response) {
                if( response.body().getResult() != null ){
                    Log.i("RF","가입성공:"+response.body().getResult().getMessage());
                }else{
                    Log.i("RF","가입실패:"+response.body().getError().getMessage());
                }
            }
            @Override
            public void onFailure(Call<ResAll> call, Throwable t) {
                Log.i("RF","통신오류"+t.getMessage());
            }
        });
    }
    // 로그인 세션 초기화
    public void onLogin(View view)
    {
        Call<ResAll> res = NetSSL.getInstance().getMemberImpFactory().login(
                new ReqAll("kokokoko_ID","11111111"));
        res.enqueue(new Callback<ResAll>() {
            @Override
            public void onResponse(Call<ResAll> call, Response<ResAll> response) {
                if( response.isSuccessful() ){
                    if( response.body()!=null && response.body().getResult() != null ){
                        Log.i("RF","로그인성공:"+response.body().getResult().getMessage());
                    }else{
                        Log.i("RF","로그인실패:"+response.message());
                    }
                }else{
                    Log.i("RF","로그인실패:"+response.message());
                }
            }
            @Override
            public void onFailure(Call<ResAll> call, Throwable t) {
                Log.i("RF","통신오류"+t.getMessage());
            }
        });
    }
    // 로그아웃 세션 종료
    public void onLogout(View view)
    {
        Call<ResAll> res = NetSSL.getInstance().getMemberImpFactory().logout();
        res.enqueue(new Callback<ResAll>() {
            @Override
            public void onResponse(Call<ResAll> call, Response<ResAll> response) {
                if( response.isSuccessful() ) {
                    if( response.body()!=null && response.body().getResult() != null ){
                        Log.i("RF", "로그아웃성공:" + response.body().getResult().getMessage());
                    } else {
                        Log.i("RF", "로그아웃실패:" + response.message());
                    }
                }else{
                    Log.i("RF","로그인실패:"+response.message());
                }
            }
            @Override
            public void onFailure(Call<ResAll> call, Throwable t) {
                Log.i("RF","통신오류"+t.getMessage());
            }
        });
    }
    // REST API GET 테스트
    public void onGet(View view)
    {
        Call<ResAll> res = NetSSL.getInstance().getMemberImpFactory().showMe("kokokoko_ID");
        res.enqueue(new Callback<ResAll>() {
            @Override
            public void onResponse(Call<ResAll> call, Response<ResAll> response) {
                if( response.isSuccessful() ) {
                    if( response.body()!=null && response.body().getResult() != null ){
                        UserData ud = response.body().getResult().getUserData();
                        Log.i("RF","정보보기성공:"+ud.toString());
                    } else {
                        Log.i("RF", "정보보기실패:" + response.message());
                    }
                }else{
                    Log.i("RF","정보보기실패:"+response.message());
                }
            }
            @Override
            public void onFailure(Call<ResAll> call, Throwable t) {
                Log.i("RF","통신오류"+t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}













