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
public class MovieImage {
	@SerializedName("poster_path")
	private String backdroppath; // 이미지 주소 (~~~~~~~~~~~~~~~.jpg)
	
	private String imagecate;	// 이미지 카테고리 (backdrop, logo, poster, profile, still-스틸컷)
	
	@SerializedName("id")
	private Long mno;	// 영화번호
	
}
