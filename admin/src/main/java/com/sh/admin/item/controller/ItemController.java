package com.sh.admin.item.controller;

import com.sh.admin.item.model.dto.*;
import com.sh.admin.item.model.service.FileUploadService;
import com.sh.admin.item.model.service.ItemCommandService;
import com.sh.admin.item.model.service.ItemQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {


    private final FileUploadService fileUploadService;
    private final ItemCommandService itemCommandService;
    private final ItemQueryService itemQueryService;
    private final FileUploadService fileUploadService;


    /* 희윤 시작 */
    @GetMapping("/list") // 다중검색 조건 설정값 넘겨받기
    public String getCondition(
                @RequestParam(required = false) Artist artistName,
                @RequestParam(required = false) Category categoryName,
                @RequestParam(required = false) SaleStatus saleStatus,
                @RequestParam(required = false, defaultValue = "0") Integer salePrice,
                Model model){
                log.info("GET /list");
                log.debug("artistName = {}", artistName);
                log.debug("categoryName = {}", categoryName);
                log.debug("saleStatus = {}", saleStatus);
                log.debug("salePrice = {}", salePrice);

                // enum을 select 옵션으로 불러오기
                model.addAttribute("category", Category.values());
                model.addAttribute("artist", Artist.values());
                model.addAttribute("saleStatus", SaleStatus.values());

                // 검색 결과 가져오기
                List<ItemDto> items = itemQueryService.findAllMatch(categoryName, artistName, salePrice, saleStatus);
                log.debug("items = {}", items);
                // 모델에 검색 결과 추가
                model.addAttribute("items", items);

                // 결과 반환
                return "item/list";
    }
    /* 희윤 끝 */
    // 희윤 등록 시작
    @PostMapping("/create") // 상품등록 페이지
    public String createItem(@ModelAttribute ItemRegistDto itemRegistDto, RedirectAttributes redirectAttributes) throws IOException {
        log.info("POST /item/create");

        // 1. 이미지 업로드 처리
        String fileName = "img/" + fileUploadService.uploadBase64EncodedImage(itemRegistDto.getImgUrl());
        log.debug("fileName = {}", fileName);


        // 2. 저장된 이미지의 이름을 이제 DB에 저장해야 된다.
        // ItemDto의 모든 값을 입력받지 않으므로 입력한 값만 저장하는 ItemRegistDto를 만들어줌.
        ItemDto itemDto = itemRegistDto.toItemDto();
        itemDto.setImgUrl(fileName);

        log.debug("itemDto = {}", itemDto);

//        int result = itemCommandService.insertItem(itemDto);
        redirectAttributes.addFlashAttribute("message", "상품등록 성공");

        return "redirect:/item/list";
    }


    // 희윤 등록 끝



    @GetMapping("/create") // 상품등록 페이지
    public String create(Model model) {
        model.addAttribute("category", Category.values()); // enum용
        model.addAttribute("artist", Artist.values()); // enum용
        model.addAttribute("saleStatus", SaleStatus.values()); // enum용

        return "item/create";
    }

    // 상품수정페이지 get 요청
    @GetMapping("/update/{itemId:\\d+}") // 상품수정 페이지는 itemId가 숫지일때만 맵핑
    public String update(@PathVariable Long itemId, Model model) {
        log.info("GET /update/{}", itemId);
        ItemDto itemDto = itemQueryService.findById(itemId);
        model.addAttribute("itemDto", itemDto);
        model.addAttribute("category", Category.values()); // enum용
        model.addAttribute("artist", Artist.values()); // enum용
        model.addAttribute("saleStatus", SaleStatus.values()); // enum용

    // 희윤 등록 시작
    @PostMapping("/create") // 상품등록 페이지
    public String createItem(@ModelAttribute ItemRegistDto itemRegistDto, RedirectAttributes redirectAttributes) throws IOException {
        log.info("POST /item/create");

        // 1. 이미지 업로드 처리
        String fileName = "img/" + fileUploadService.uploadBase64EncodedImage(itemRegistDto.getImgUrl());
        log.debug("fileName = {}", fileName);


        // 2. 저장된 이미지의 이름을 이제 DB에 저장해야 된다.
        // ItemDto의 모든 값을 입력받지 않으므로 입력한 값만 저장하는 ItemRegistDto를 만들어줌.
        ItemDto itemDto = itemRegistDto.toItemDto();
        itemDto.setImgUrl(fileName);

        log.debug("itemDto = {}", itemDto);

        int result = itemCommandService.insertItem(itemDto);
        redirectAttributes.addFlashAttribute("message", "상품등록 성공");

        return "redirect:/item/list";
    }


    // 희윤 등록 끝

    // 수정 업데이트 post요청
    @PostMapping("/update/{itemId:\\d+}")
    public String updateItem(@PathVariable Long itemId, @ModelAttribute ItemRegistDto itemRegistDto,RedirectAttributes redirectAttributes) throws IOException {
        log.info("POST /update/{}", itemId);

        // 1. 이미지 업로드 처리
        String fileName = "img/" + fileUploadService.uploadBase64EncodedImage(itemRegistDto.getImgUrl());
        log.debug("fileName = {}", fileName);
        // 2. 저장된 이미지의 이름을 이제 DB에 저장해야 된다.
        // ItemDto의 모든 값을 입력받지 않으므로 입력한 값만 저장하는 ItemRegistDto를 만들어줌.
        ItemDto updatedItem = itemRegistDto.toItemDto2(itemId);
        updatedItem.setImgUrl(fileName);

        log.debug("updateditemDto = {}", updatedItem);

        itemCommandService.updateItem(updatedItem); // 업데이트하는 코드
        redirectAttributes.addFlashAttribute("message", "상품수정 성공");
        return "redirect:/item/list";
    }


    //나경작업끝


    @PostMapping("/updateSaleStatus")
    @ResponseBody
    public boolean updateSaleStatus(@RequestParam("itemId") Long itemId) {
        boolean updated = itemCommandService.updateSaleStatus(itemId); // 서비스에서 itemId의 결과 (true 이면 품절상태)
        return updated;
    }


//    나경작업완료

}
