package com.mju.mobile.Service.Item;

import com.mju.mobile.Model.Item.Item;
import com.mju.mobile.Model.Item.ItemPhoto;
import com.mju.mobile.Repository.ItemPhotoRepository;
import com.mju.mobile.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;
    private final ItemPhotoRepository itemPhotoRepository;
    private final ItemPhotoService itemPhotoService;

    @Override
    public void save(Item item, List<MultipartFile> itemPhotoSaveRequest) throws IOException {
        this.itemRepository.save(item);
        List<String> photoUrls = this.itemPhotoService.save(itemPhotoSaveRequest);
        for(String url: photoUrls) {
            ItemPhoto itemPhoto = new ItemPhoto();
            itemPhoto.setId(item.getId());
            itemPhoto.setUrl(url);
            this.itemPhotoRepository.save(itemPhoto);
        }
    }
}
