package com.dobrev.bookshop.controller;

import com.dobrev.bookshop.entity.BookEntity;
import com.dobrev.bookshop.entity.OrderEntity;
import com.dobrev.bookshop.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    EntityManager em;
    @GetMapping("/admin")
    public String bookEdit( Model model){

        model.addAttribute("books",bookRepo.findAll());
        return "admin";
    }
    @GetMapping("/adminSearch")
    public String searchAdmin(@RequestParam(name="search",required = true,defaultValue = "genre")String radioBn,
                         @RequestParam(name="param")String param,Model model){
        List<BookEntity> books=null;
        if("genre".equals(radioBn)){
            books = bookRepo.getBooksbygenre(param);
        }
        if("author".equals(radioBn)){
            books = bookRepo.getBooksbyauth(param);

        }
        if(books.size()==0)
            model.addAttribute("books",bookRepo.findAll());
        else
            model.addAttribute("books",books);

        return "admin";
    }

    @PostMapping("/edit")
    public String editing(BookEntity bookEntity,  Model model){
        BookEntity entity= bookRepo.findById(bookEntity.getId()).get();

        entity.setAuthors(bookEntity.getAuthors());
        entity.setDescription(bookEntity.getDescription());
        entity.setGenres(bookEntity.getGenres());
        entity.setPrice(bookEntity.getPrice());
        entity.setTitle(bookEntity.getTitle());
        bookRepo.save(entity);
        model.addAttribute("books",bookRepo.findAll());
        return "admin";
    }
    @GetMapping("/bookEdit")
    public String bookEdit(@RequestParam(name="id",required = true,defaultValue = "1")Integer idBook,Model model){
        BookEntity bookEntity= bookRepo.findById(idBook).get();
        model.addAttribute("books",bookEntity);
        return "bookEdit";
    }
    @GetMapping("/addBook")
    public String bookAdd(Model model){
        return "addBook";
    }
    @PostMapping("/add")
    public String adding(BookEntity bookEntity,  Model model){
        bookRepo.save(bookEntity);
        model.addAttribute("books",bookRepo.findAll());
        return "admin";
    }
}
