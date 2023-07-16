package com.zlarbals.weightscheduler.service.retrofit;

import com.zlarbals.weightscheduler.domain.Member;
import com.zlarbals.weightscheduler.dto.MemberSyncResponseDto;
import com.zlarbals.weightscheduler.dto.ResponseResult;
import com.zlarbals.weightscheduler.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RetrofitService {

    private final MemberRepository memberRepository;

    public List<MemberSyncResponseDto> sendMemberSyncApi(){
        RetrofitApiService retrofitApiService = getRetrofitApiService("http://localhost:8061");
        Call<ResponseResult<List<MemberSyncResponseDto>>> call = retrofitApiService.syncIacMember("1234");

        List<MemberSyncResponseDto> memberSyncResponseDtoList = new ArrayList<>();
        try {
            Response<ResponseResult<List<MemberSyncResponseDto>>> response = call.execute();

            if(response.isSuccessful()){
                ResponseResult<List<MemberSyncResponseDto>> body = response.body();
                memberSyncResponseDtoList = body.getResponse();
            }else {
                log.error("API 요청 실패");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return memberSyncResponseDtoList;
    }

    private RetrofitApiService getRetrofitApiService(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitApiService.class);
    }

}
