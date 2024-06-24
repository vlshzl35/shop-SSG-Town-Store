package com.sh.admin.item.controller;

import com.sh.admin.item.model.dto.ItemDto;
import com.sh.admin.item.model.service.ItemCommandService;
import com.sh.admin.item.model.service.ItemQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

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

    @GetMapping("/create") // 상품등록 페이지
    public String create() {
        return "item/create";
    }

    @GetMapping("/update") // 상품수정 페이지
    public String update(){
        return "item/update";
    }


}
