package com.example.club;

import com.example.club.domain.Picture;
import com.example.club.domain.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GreetingController {
    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private PictureRepo pictureRepo;

    @GetMapping("/")
    public String getGreetingPage(
            Model model
    ) {
        List<Picture> pictures = pictureRepo.findAll();

        model.addAttribute("picture1", getPictureById(pictures, 1L).getName());
        model.addAttribute("picture2", getPictureById(pictures, 2L).getName());
        model.addAttribute("picture3", getPictureById(pictures, 3L).getName());
        model.addAttribute("picture4", getPictureById(pictures, 4L).getName());
        model.addAttribute("picture5", getPictureById(pictures, 5L).getName());
        model.addAttribute("picture6", getPictureById(pictures, 6L).getName());
        model.addAttribute("picture7", getPictureById(pictures, 7L).getName());
        model.addAttribute("picture8", getPictureById(pictures, 8L).getName());
        model.addAttribute("picture9", getPictureById(pictures, 9L).getName());
        model.addAttribute("picture10", getPictureById(pictures, 10L).getName());
        model.addAttribute("picture11", getPictureById(pictures, 11L).getName());
        return "main";
    }

    @PostMapping("/")
    public String getDataFromForm(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String phone,
            @RequestParam(required = false, defaultValue = "false") boolean pd
    ) {
        if (!pd)
            return "redirect:/";
        Request request = new Request(); //Создание объект заявки
        request.setName(name);
        request.setSurname(surname);
        request.setPhone(phone); //Наполнение данными с формы
        requestRepo.save(request); //Сохранение в базу данны insert into zayavky values (...)
        return "redirect:/"; //Вызываем get-запрос основной страницы по адресу "/"
    }

    private Picture getPictureById(List<Picture> pictures, Long id) {
        for (Picture pic: pictures) {
            if (pic.getId().equals(id))
                return pic;
        }
        return null;
    }
}