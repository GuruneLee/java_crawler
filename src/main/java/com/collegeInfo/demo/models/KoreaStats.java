package com.collegeInfo.demo.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class KoreaStats {
    private String country; // 시도명
    private int diffFromPrevDay_sum; // 전일대비확진환자증감
    private int total; // 확진환자수
    private int death; //사망자수
    private double incidence; // 발병률
}
