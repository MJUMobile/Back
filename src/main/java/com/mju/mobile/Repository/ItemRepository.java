package com.mju.mobile.Repository;

import com.mju.mobile.Model.Auth.Auth;
import com.mju.mobile.Model.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<Item, String> {
}
