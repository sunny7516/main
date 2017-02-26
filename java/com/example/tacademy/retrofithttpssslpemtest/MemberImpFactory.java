package com.example.tacademy.retrofithttpssslpemtest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 회원관련 모든 API 구현
 1. 카카오톡 로그인 및 최초 회원등록_
 2. 로컬 회원 최초 가입_
 3. 로컬 회원 로그인_
 4. 로컬 회원 정보 변경_
 5. 회원 탈퇴하기_
 6. 회원 로그아웃_
 7. 회원 상세 정보 보기_
 8. 회원 본인 모든 기록 보기_
 9. 회원 본인 점수 등록_
 10. 회원 본인 점수 수정_
 11. 회원 본인 점수 삭제_
 */

public interface MemberImpFactory
{
    // 로컬 회원 최초 가입 --------------------------------------------------------------------------
    @POST("users")
    Call<ResAll> join(@Body ReqAll reqAll);
    // 세션 사용 -----------------------------------------------------------------------------------
    @POST("/auth/local/login")
    Call<ResAll> login(@Body ReqAll reqAll);
    // 세션 아웃 -----------------------------------------------------------------------------------
    @GET("/auth/logout")
    Call<ResAll> logout();
    // 회원 정보 요청 --------------------------------------------------------------------------------
    // /users/:uid
    @GET("/test/{uid}")
    Call<ResAll> showMe(@Path("uid") String uid);
    // GET 요청  -----------------------------------------------------------------------------------
    // /scores/me/ranklist?condition_id=&center_id=&circle_id=&current_page=
    @GET("/scores/me/ranklist")
    Call<ResAll> ranklist(@QueryMap Map<String, String> options);
    // GET 요청2  -----------------------------------------------------------------------------------
    @GET("/scores/me/ranklist")
    Call<ResAll> ranklist2(@Query("condition_id") String condition_id,
                           @Query("center_id") String center_id,
                           @Query("circle_id") String circle_id,
                           @Query("current_page") String current_page);
    // ---------------------------------------------------------------------------------------------
}


















