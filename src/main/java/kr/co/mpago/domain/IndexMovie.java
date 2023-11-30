package kr.co.mpago.domain;

import lombok.Data;

@Data
public class IndexMovie {
    private String gno;
    private String mno;
    private String backdroppath; // backdropPath 대신 path로 이름 변경
}