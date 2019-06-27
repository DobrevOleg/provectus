package com.dobrev.bookshop.controller;
import com.dobrev.bookshop.entity.BookEntity;
import com.dobrev.bookshop.entity.OrderEntity;
import com.dobrev.bookshop.repo.BookRepo;
import com.dobrev.bookshop.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.security.Principal;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    OrderRepo orderRepo;
    @GetMapping
    public String index( Model model) {
        return "index";
    }
    @GetMapping("/index")
    public String index1( Model model) {
        return "index";
    }
   @GetMapping("/book")
    public String book( Model model){
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       boolean hasAdminRole = auth.getAuthorities().stream()
               .anyMatch(r -> r.getAuthority().equals("ADMIN"));
      if(hasAdminRole){
          model.addAttribute("userRole","ADMIN");
      }
      else
          model.addAttribute("userRole","USER");

        model.addAttribute("books",bookRepo.findAll());
        return "book";
    }
    @GetMapping("login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("user")
    public String search(@RequestParam(name="search",required = true,defaultValue = "genre")String radioBn,
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


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean hasAdminRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));
        if(hasAdminRole){
            model.addAttribute("userRole","ADMIN");
        }
        else
            model.addAttribute("userRole","USER");
        return "book";
    }

    @GetMapping("/bookInfo")
    public String bookInfo(@RequestParam(name="id",required = true,defaultValue = "1")Integer idBook,Model model){
        BookEntity bookEntity= bookRepo.findById(idBook).get();
        model.addAttribute("books",bookEntity);
        return "bookInfo";
    }

    @GetMapping("/buy")
    public String buy(@RequestParam(name="id",required = true)Integer idBook,Model model){
        BookEntity bookEntity= bookRepo.findById(idBook).get();
        model.addAttribute("books",bookEntity);
        return "buy";
    }
    @PostMapping("/buy")
    public String buying(OrderEntity orderEntity,@RequestParam(name = "idBook") Integer idBook,Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean hasAdminRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));
        if(hasAdminRole){
            model.addAttribute("userRole","ADMIN");
        }
        else
            model.addAttribute("userRole","USER");

       orderEntity.setLogin(auth.getName());
        orderEntity.setId_book(idBook);
        orderRepo.save(orderEntity);
        model.addAttribute("buy","buy");
        model.addAttribute("books",bookRepo.findAll());
        return "book";
    }
}
