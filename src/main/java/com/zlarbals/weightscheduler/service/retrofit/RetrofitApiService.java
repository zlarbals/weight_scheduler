package com.zlarbals.weightscheduler.service.retrofit;

import com.zlarbals.weightscheduler.dto.MemberSyncResponseDto;
import com.zlarbals.weightscheduler.dto.ResponseResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface RetrofitApiService {

    @GET("/sync/member")
    Call<ResponseResult<List<MemberSyncResponseDto>>> syncIacMember(@Header("AuthKey") String authKey);

}
