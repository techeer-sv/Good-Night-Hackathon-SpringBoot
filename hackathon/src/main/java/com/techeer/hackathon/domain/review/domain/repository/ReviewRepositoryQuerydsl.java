package com.techeer.hackathon.domain.review.domain.repository;

import com.techeer.hackathon.domain.review.dto.ReviewPreviewInfo;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface ReviewRepositoryQuerydsl {
    List<ReviewPreviewInfo> findReviewPreviewInfoListPage(Pageable pageable, boolean isTimeReserved);

    List<ReviewPreviewInfo> getReviewListSearchTitleOrContent(
            Pageable pageable, boolean isTimeReserved, String keyword
    );
}
