package com.example.demo.domain.review.dto.request;

import com.example.demo.global.enumpkg.SearchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ReviewSearchRequest {
    private SearchType searchType;

    private String searchKeyword;

}
