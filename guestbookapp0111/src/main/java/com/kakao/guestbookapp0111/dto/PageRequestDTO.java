package com.kakao.guestbookapp0111.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    // 현재 페이지 번호
    private int page;
    // 페이지 당 데이터 개수
    private int size;

    public PageRequestDTO() {
        // 기본값 설정 - NoArgsConstructor Annotation은 필요가 없어짐.
        this.page = 1;
        this.size = 1;
    }

    // Repository에게 전달할 Pageable 객체를 만들어주는 메서드
    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}
