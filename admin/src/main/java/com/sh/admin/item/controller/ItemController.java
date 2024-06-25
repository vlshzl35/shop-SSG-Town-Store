package com.sh.admin.item.controller;

import com.sh.admin.item.model.dto.Artist;
import com.sh.admin.item.model.dto.Category;
import com.sh.admin.item.model.dto.ItemDto;
import com.sh.admin.item.model.dto.SaleStatus;
import com.sh.admin.item.model.service.ItemCommandService;
import com.sh.admin.item.model.service.ItemQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.sh.admin.item.model.dto.Category.CD;

@Controller
@Slf4j
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemCommandService itemCommandService;
    private final ItemQueryService itemQueryService;


    @GetMapping("/list")
    public String list(Model model) {
        log.info("GET /item/list");
        List<ItemDto> items = itemQueryService.findAll();
        log.debug("items = {}", items);
        model.addAttribute("items", items);
        return "item/list";
    }

    /* 희윤 시작 */
    @PostMapping("/list") // 다중검색 조건 설정값 넘겨받기
    public String regist(
                @RequestParam(required = false) Category categoryName,
                @RequestParam(required = false) Artist artistName,
                @RequestParam(required = false) SaleStatus saleStatus,
                @RequestParam(required = false) int salePrice,
                Model model){
                log.info("POST /list");

                // 검색 결과 가져오기
                List<ItemDto> items = itemQueryService.findAllMatch(categoryName, artistName, salePrice, saleStatus);
                log.debug("items = {}", items);
                // 모델에 검색 결과 추가
                model.addAttribute("items", items);

                // 결과 반환
                return "item/list";
    }
    /* 희윤 끝 */

    @GetMapping("/create") // 상품등록 페이지
    public String create() {
        return "item/create";
    }

    @GetMapping("/update") // 상품수정 페이지
    public String update(){
        return "item/update";
    }


}
