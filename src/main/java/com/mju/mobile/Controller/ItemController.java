package com.mju.mobile.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mju.mobile.Model.Response.CommonResponse;
import com.mju.mobile.Request.Item.ItemSaveRequest;
import com.mju.mobile.Service.Item.ItemService;
import com.mju.mobile.Service.Response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    private final ResponseService responseService;

    @PostMapping(path = "/save")
    public CommonResponse itemSave(@RequestParam(value = "item") String json,
                                   @RequestParam(value = "itemPhoto") List<MultipartFile> itemPhotoSaveRequest) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new SimpleModule());
        ItemSaveRequest itemSaveRequest = objectMapper.readValue(json, new TypeReference<ItemSaveRequest>() {});
        itemService.save(itemSaveRequest.toEntity(), itemPhotoSaveRequest);
        return responseService.getSuccessfulResult();
    }
}
