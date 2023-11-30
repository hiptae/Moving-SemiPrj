package kr.co.mpago.domain;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cast {
	@SerializedName("id")
	private Long castno;	// 배우 번호
	
	@SerializedName("name")
	private String name;	// 배우 이름
	
	@SerializedName("profile_path")
	private String profileImage;	// 배우 프로필사진 이미지
	
	@SerializedName("")
	private String birthDate;	// 배우 생년월일정보
}
