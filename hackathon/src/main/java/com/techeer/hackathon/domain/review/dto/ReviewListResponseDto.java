package com.techeer.hackathon.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewListResponseDto {
    private List<ReviewPreviewInfo> reviewPreviewInfoList = new ArrayList<>();
}
