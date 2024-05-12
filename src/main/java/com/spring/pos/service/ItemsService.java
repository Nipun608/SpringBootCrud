package com.spring.pos.service;

import com.spring.pos.dto.request.ItemSaveRequestDTO;



public interface ItemsService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
