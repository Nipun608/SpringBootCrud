package com.spring.pos.controller;

import com.spring.pos.dto.request.ItemSaveRequestDTO;
import com.spring.pos.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemsController {

    @Autowired
    private ItemsService itemsService;



    @PostMapping(
            path = "/save"
    )
    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message = itemsService.saveItem(itemSaveRequestDTO);
        return "saved";
    }
}
