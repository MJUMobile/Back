package com.mju.mobile.Service.Item;

import com.mju.mobile.Model.Item.Item;
import com.mju.mobile.Request.Item.ItemSaveRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ItemService {
    public void save(Item itemSaveRequest, List<MultipartFile> itemPhotoSaveRequest) throws IOException;
}
