package com.springboot.menu.service;

import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.menu.entity.Menu;
import com.springboot.menu.repository.MenuRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {
    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu createMenu(Menu menu) {
        // 메뉴 검증
        verifyMenuName(menu);

        return menuRepository.save(menu);
    }

    public Menu updateMenu(Menu menu) {
        // 메뉴 검증
        Menu findMenu = verifyMenuId(menu.getMenuId());
        Optional.ofNullable(menu.getMenuName()).ifPresent(name -> findMenu.setMenuName(name));

        return menuRepository.save(findMenu);
    }

    public Menu findMenu(long menuId) {
        // 메뉴 검증
        return verifyMenuId(menuId);
    }

    public Page<Menu> findMenus(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("menuId").descending());
        return menuRepository.findAll(pageable);
    }

    public void deleteMenu(long menuId) {
        // 메뉴 검증
        Menu findMenu = verifyMenuId(menuId);
        menuRepository.delete(findMenu);
    }

    private void verifyMenuName(Menu menu) {
        // 메뉴 검증 로직
        Optional<Menu> optionalMenu = menuRepository.findByMenuName(menu.getMenuName());
        if (optionalMenu.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.DUPLICATE_MENU);
        }
    }

    private Menu verifyMenuId(long menuId) {
        Optional<Menu> optionalMenu = menuRepository.findById(menuId);
        if (optionalMenu.isEmpty()) {
            throw new BusinessLogicException(ExceptionCode.MENU_NOT_FOUND);
        }

        return optionalMenu.get();
    }
}