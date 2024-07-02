package com.sh.admin.item.model.dao;

import com.sh.admin.item.model.dto.Artist;
import com.sh.admin.item.model.dto.Category;
import com.sh.admin.item.model.dto.ItemDto;
import com.sh.admin.item.model.dto.SaleStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sh.admin.item.model.dto.SaleStatus.판매중;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Disabled
class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;


    @Test
    @DisplayName("전체조회")
    void findAll() {
        // given // 조회라서 줘야되는게 없음
        // when
        List<ItemDto> items = itemMapper.findAll();
        System.out.println(items);

        //then
        assertThat(items)
                .isNotNull()
                .isNotEmpty()
                .allMatch((item) -> item != null); // 모든 요소가 다 true

    }
  
    @Test
    void findAllMatch() {
        // given
        Category categoryName = Category.valueOf("CD");
        Artist artistName = Artist.valueOf("샤이니");

        // when
        List<ItemDto> items = itemMapper.findAllMatch(categoryName,artistName,13000,null);
        System.out.println(items);
        // then
        assertThat(items)
                .isNotNull()
                .isNotEmpty()
                .allMatch((item) -> item != null); // 모든 요소가 다 true
    }

//    나경작업시작
    @Test
    @DisplayName("상품아이디로 한건조회")
    void findById() {
        //given
        long itemId = 1;
        //when
        ItemDto itemDto = itemMapper.findById(itemId);

        //then
        assertThat(itemDto)
                .isNotNull()
                .satisfies(
                        (_itemDto) -> assertThat(_itemDto.getItemId()).isEqualTo(itemId),
                        (_itemDto) -> assertThat(_itemDto.getItemName()).isNotNull(),
                        (_itemDto) -> assertThat(_itemDto.getImgUrl()).isNotNull(),
                        (_itemDto) -> assertThat(_itemDto.getSeller()).isEqualTo("SSG"),
                        (_itemDto) -> assertThat(_itemDto.getQuantity()).isPositive(),
                        (_itemDto) -> assertThat(_itemDto.getSalePrice()).isPositive(),
                        (_itemDto) -> assertThat(_itemDto.getSaleStatus()).satisfiesAnyOf(
                                (saleStatus) -> assertThat(saleStatus).isEqualTo(판매중),
                                (saleStatus) -> assertThat(saleStatus).isEqualTo(saleStatus.품절),
                                (saleStatus) -> assertThat(saleStatus).isEqualTo(saleStatus.판매중지)
                        ),
                        (_itemDto) -> assertThat(_itemDto.getCategoryName()).satisfiesAnyOf(
                                (categoryName) -> assertThat(categoryName).isEqualTo(categoryName.CD),
                                (categoryName) -> assertThat(categoryName).isEqualTo(categoryName.응원봉),
                                (categoryName) -> assertThat(categoryName).isEqualTo(categoryName.의류),
                                (categoryName) -> assertThat(categoryName).isEqualTo(categoryName.잡화)
                        ),
                        (_itemDto) -> assertThat(_itemDto.getArtistName()).satisfiesAnyOf(
                                (artist) -> assertThat(artist).isEqualTo(artist.에스파),
                                (artist) -> assertThat(artist).isEqualTo(artist.샤이니)
                        )



                );

    }
    @Test
    @DisplayName("품절상태인걸 판매중지로 바꿔지는가?")
    void updateSaleStatus() {
        // given
        Long itemId = 30L; // 품절상태


        // when
        int updatedRows = itemMapper.updateSaleStatus(itemId);

        // then
        assertThat(updatedRows).isEqualTo(1); // 업데이트된 행의 수가 0보다 큰지 확인합니다.

    }

//    나경작업시작
    @Test
    @DisplayName("상품수정이되는가?")
    void updateItem() {
        //given
        //수정하려고하는 값
        Long itemId = 29L;
        String itemName = "샤이니 데뷔링";
        Category categoryName = Category.응원봉;
        Artist artistName = Artist.에스파;
        String imgUrl = "img/img30.png";
        String details = "클로즈링타입";
        int quantity = 10;
        int salePrice = 18000;
        SaleStatus saleStatus = SaleStatus.품절;

         // 기존 정보 불러오기
        // 이건 위에 메서드 확인 했으니 테스트생략 findById(itemId) 사용
        // 업데이트 할 객체 생성
        ItemDto updatedItem = new ItemDto();
        updatedItem.setItemId(itemId);
        updatedItem.setItemName(itemName);
        updatedItem.setCategoryName(categoryName);
        updatedItem.setArtistName(artistName);
        updatedItem.setImgUrl(imgUrl);
        updatedItem.setDetails(details);
        updatedItem.setQuantity(quantity);
        updatedItem.setSalePrice(salePrice);
        updatedItem.setSaleStatus(saleStatus);

        // when
        int updatedRows = itemMapper.updateItem(updatedItem);

        // then
        assertThat(updatedRows).isEqualTo(1); // 업데이트된 행의 수가 1인지 확인합니다.

        // 업데이트된 아이템을 다시 조회
        ItemDto retrievedItem = itemMapper.findById(itemId);

        // 업데이트된 값들이 올바르게 반영되었는지 확인합니다.
        assertThat(retrievedItem.getItemName()).isEqualTo(itemName);
        assertThat(retrievedItem.getImgUrl()).isEqualTo(imgUrl);
        assertThat(retrievedItem.getDetails()).isEqualTo(details);
        assertThat(retrievedItem.getQuantity()).isEqualTo(quantity);
        assertThat(retrievedItem.getSalePrice()).isEqualTo(salePrice);
        assertThat(retrievedItem).satisfies(
                (_itemDto) -> assertThat(_itemDto.getItemId()).isEqualTo(itemId),
                (_itemDto) -> assertThat(_itemDto.getItemName()).isNotNull(),
                (_itemDto) -> assertThat(_itemDto.getImgUrl()).isNotNull(),
                (_itemDto) -> assertThat(_itemDto.getSeller()).isEqualTo("SSG"),
                (_itemDto) -> assertThat(_itemDto.getQuantity()).isPositive(),
                (_itemDto) -> assertThat(_itemDto.getSalePrice()).isPositive(),
                (_itemDto) -> assertThat(_itemDto.getSaleStatus()).satisfiesAnyOf(
                        (saleStatus2) -> assertThat(saleStatus2).isEqualTo(saleStatus.품절)
                ),
                (_itemDto) -> assertThat(_itemDto.getCategoryName()).satisfiesAnyOf(
                        (categoryName2) -> assertThat(categoryName2).isEqualTo(categoryName.응원봉)

                ),
                (_itemDto) -> assertThat(_itemDto.getArtistName()).satisfiesAnyOf(
                        (artist) -> assertThat(artist).isEqualTo(artist.에스파),
                        (artist) -> assertThat(artist).isEqualTo(artist.샤이니)
                )



        );
    }

//    나경작업끝

    @Test
    @DisplayName("상품 등록")
    void insertItem() {
        // given
        String itemName = "양희윤의 뇌";
        Category categoryName = Category.valueOf("잡화");
        Artist artistName = Artist.valueOf("샤이니");
        String imgUrl = "img/img31.png";
        String details = "감자주의하세요";
        int quantity = 1;
        int salePrice = 100;
        SaleStatus saleStatus = SaleStatus.valueOf("판매중");

        ItemDto itemDto = new ItemDto(null, itemName,categoryName,artistName,imgUrl,null, details,quantity,salePrice,saleStatus);
        // when
        int result = itemMapper.insertItem(itemDto);
        System.out.println();
        // then
        assertThat(result).isEqualTo(1); // 등록 성공하면 숫자 1반환하므로
        assertThat(itemDto.getItemId()).isNotZero();
    }

}