package com.kakao.springbootjpa0110;

import com.kakao.springbootjpa0110.domain.Memo;
import com.kakao.springbootjpa0110.persistence.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    MemoRepository memoRepository;

    // 삽입 테스트
    @Test
    public void testInsert() {
        // 데이터 100개 삽입
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder()
                    .memoText("Sample..." + i)
                    .build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void testAll() {
        List<Memo> list = memoRepository.findAll();
        for(Memo memo: list) {
            System.out.println(memo);
        }
    }

    @Test
    public void getById() {
        // 기본키를 가지고 조회하면 없거나 1개의 데이터 리턴
        // 그럴 때는 Optional을 사용해야 한다.
        Optional<Memo> result = memoRepository.findById(1000L);

        if(result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }

    @Test
    public void updateTest() {
        // 기본 값이 존재하면 수정이지만 존재하지 않으면 삽입이다.
        Memo memo = Memo.builder()
                .mno(1000L)
                .memoText("데이터 수정")
                .build();
        memoRepository.save(memo);
    }

    @Test
    public void deleteTest() {
        // 기본키를 가지고 삭제
        memoRepository.deleteById(100L);
        // Entity를 이용해서 삭제
        memoRepository.delete(Memo.builder().mno(99L).build());

        // 없는 데이터를 삭제하고자 하면 에러
        // 삭제를 할 때는 존재 여부를 확인해야 한다.
        memoRepository.deleteById(1000L);
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Memo> result = memoRepository.findAll(pageable);
        // 전체 페이지 개수
        System.out.println(result.getTotalPages());

        // 조회된 데이터 순회
        for(Memo memo: result.getContent()) {
            System.out.println(memo);
        }
    }

    @Test
    public void testSort() {
        // mno의 내림차순
        Sort sort = Sort.by("mno").descending();
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Memo> result = memoRepository.findAll(pageable);
        for(Memo memo : result.getContent()){
            System.out.println(memo);
        }
    }

    @Test
    public void testSortConcate() {
        Sort sort1 = Sort.by("mno").descending();
        Sort sort2 = Sort.by("memoText").ascending();
        // 2개 결합 - sort1의 값이 같으면 sort2로 정렬
        Sort sortAll = sort1.and(sort2);

        Pageable pageable = PageRequest.of(0, 10, sortAll);
        Page<Memo> result = memoRepository.findAll(pageable);
        for(Memo memo: result.getContent()) {
            System.out.println(memo);
        }
    }

    @Test
    public void queryMethod1() {
        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(30L, 40L);

        for(Memo memo: list) {
            System.out.println(memo);
        }
    }
}