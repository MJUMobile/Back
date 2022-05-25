package com.mju.mobile.Controller;

import com.mju.mobile.Model.Response.CommonResponse;
import com.mju.mobile.Repository.ItemRepository;
import com.mju.mobile.Request.Item.ItemSaveRequest;
import com.mju.mobile.Service.Response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;
    private final ResponseService responseService;

    @PostMapping("save")
    public CommonResponse itemSave(@RequestBody ItemSaveRequest itemSaveRequest){
        String ow = itemSaveRequest.getOwnerId();
        itemRepository.save(itemSaveRequest.toEntity());
        return responseService.getSuccessfulResult();
    }
}
