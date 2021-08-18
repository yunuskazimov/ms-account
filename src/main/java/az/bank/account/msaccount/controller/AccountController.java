package az.bank.account.msaccount.controller;

import az.bank.account.msaccount.model.AccountDto;
import az.bank.account.msaccount.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount (@RequestBody AccountDto dto){
        logger.info("Log Controller : DTO -> "+dto.toString());
        return new ResponseEntity<>(accountService.createAccount(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public AccountDto editAccount(@RequestBody AccountDto dto,
                                  @PathVariable Long id){
        dto.setId(id);
        return accountService.editAccount(dto);
    }


    @GetMapping("/{id}")
    public AccountDto getAccount (@PathVariable Long id){
        return accountService.getAccount(id);
    }

    @GetMapping
    public List<AccountDto> getAccounts (){
        return accountService.getAccounts();
    }
}
