package edu.citadel.api;

import edu.citadel.api.request.AccountRequestBody;
import edu.citadel.dal.AccountRepository;
import edu.citadel.dal.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountEndpoints {

  private final AccountRepository accountRepository;

  @Autowired
  public AccountEndpoints(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Account> createAccount(@RequestBody AccountRequestBody accountRequestBody) {

    Account account = new Account();
    account.setEmail(accountRequestBody.getEmail());
    account.setPassword(accountRequestBody.getPassword());
    account.setUsername(accountRequestBody.getUsername());

    Account rtnAccount = accountRepository.save(account);

    return new ResponseEntity<>(rtnAccount, HttpStatus.CREATED);
  }

  @GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Account> getByUsername(@PathVariable String username) {
    Account rtnAccount = accountRepository.findAccountByUsername(username);
    if (rtnAccount != null) {
      return new ResponseEntity<>(rtnAccount, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Account> getById(@PathVariable Long id) {
    Account rtnAccount = accountRepository.findById(id).orElse(null);
    if (rtnAccount != null) {
      return new ResponseEntity<>(rtnAccount, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
    }

}
