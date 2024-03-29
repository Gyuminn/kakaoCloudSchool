package com.kakao.guestbookapp0112.persistence;

import com.kakao.guestbookapp0112.domain.Board;
import com.kakao.guestbookapp0112.domain.QBoard;
import com.kakao.guestbookapp0112.domain.QMember;
import com.kakao.guestbookapp0112.domain.QReply;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {

    // QuerydslRepositorySupport 클래스에 Default Contructor가 없기 때문에
    // Contructor를 직접 생성해서 필요한 Contructor를 호출해줘야 한다. 그렇지 않으면 에러
    // 검색에 사용할 Entity 클래스를 대입해주어야 한다.
    public SearchBoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Board search1() {
        // JPQL을 동적으로 생성해서 실행
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;
        QMember member = QMember.member;

        // 쿼리 작성
        JPQLQuery<Board> jpqlQuery = from(board);
        // 외래키가 writer이기 때문.
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        // reply와 join
        // 외래키는 reply의 board
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board));

        /*
        // 게시글 번호 별로 묶어서 board와 member의 email, 그리고 reply의 개수를 가져오기
        jpqlQuery.select(board, member.email, reply.count()).groupBy(board);
        // jpql을 실행시킨 결과 가져오기
        // 실행 자체는 fetch가 한다.
        List<Board> result = jpqlQuery.fetch();
         */
        JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member.email, reply.count());
        tuple.groupBy(board);
        List<Tuple> result = tuple.fetch();

        System.out.println(result);
        return null;
    }

    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        QMember member = QMember.member;
        QReply reply = QReply.reply;

        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.leftJoin(member).on(board.writer.eq(member));
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board));

        JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member, reply.count());
        // 조건 생성
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression expression = board.bno.gt(0L); // bno가 0보다 큰
        booleanBuilder.and(expression);

        // 타입에 따른 조건 생성
        if (type != null) {
            // 글자 단위로 쪼개기
            String[] typeArr = type.split("");
            BooleanBuilder conditionBuilder = new BooleanBuilder();
            for (String t : typeArr) {
                switch (t) {
                    case "t":
                        conditionBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        conditionBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        conditionBuilder.or(member.email.contains(keyword));
                        break;
                }
            }
            booleanBuilder.and(conditionBuilder);
        }
        // 조건을 tuple에 적용
        tuple.where(booleanBuilder);

        // 정렬 방법 설정
        tuple.orderBy(board.bno.desc());

        // 그룹화
        tuple.groupBy(board);

        // page 처리
        tuple.offset(pageable.getOffset());
        tuple.limit(pageable.getPageSize());

        // 데이터 가져오기
        List<Tuple> result = tuple.fetch();

        // return
        return new PageImpl<Object[]>(result
                .stream()
                .map(t -> t.toArray())
                .collect(Collectors.toList()), pageable, tuple.fetchCount());
    }
}
