package com.docteory07.mweireiteng.review;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto {

    @Size(max=50, message = "제목은 50글자 이하로 작성해주세요.")
    @NotEmpty(message = "제목을 입력해주세요.")
    private String title;

    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;

    private int hot;

    private int mala;

    private int rating;

    private int restaurantId;
}
