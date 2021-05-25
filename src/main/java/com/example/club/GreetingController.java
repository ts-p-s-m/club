package com.example.club;

import com.example.club.domain.MartialArt;
import com.example.club.domain.Picture;
import com.example.club.domain.Request;
import com.example.club.domain.Trainer;
import com.example.club.repository.MartialArtRepo;
import com.example.club.repository.PictureRepo;
import com.example.club.repository.RequestRepo;
import com.example.club.repository.TrainerRepo;
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
    private TrainerRepo trainerRepo;

    @Autowired
    private MartialArtRepo martialArtRepo;

    @Autowired
    private PictureRepo pictureRepo;

    @GetMapping("/")
    public String getGreetingPage(
            Model model
    ) {
        List<MartialArt> martialArts = martialArtRepo.findAll();

        List<Trainer> trainers = getTrainers();

        model.addAttribute("trainers", trainers);

        model.addAttribute("martialArts", martialArts);

        model.addAttribute("detiPicture", getPictureById(1L));
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

    private Picture getPictureById(Long id) {
        return pictureRepo.getOne(id);
    }

    private List<Trainer> getTrainers() {
        return trainerRepo.findAll();
    }

    private List<MartialArt> getMartialArts() {
        return martialArtRepo.findAll();
    }
}