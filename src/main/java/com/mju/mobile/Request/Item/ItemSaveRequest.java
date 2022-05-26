package com.mju.mobile.Request.Item;

import com.mju.mobile.Model.Item.Item;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ItemSaveRequest {
    private int id;
    private String ownerId;

    public Item toEntity() {
        Item item = new Item();
        item.setId(this.id);
        item.setOwnerId(this.ownerId);
        return item;
    }
}
