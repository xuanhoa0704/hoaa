package ntthanh.project.controller;

import ntthanh.project.dto.DtoAccount;
import ntthanh.project.dto.DtoCustomer;
import ntthanh.project.entity.Account;
import ntthanh.project.entity.Customers;
import ntthanh.project.service.AccountService;
import ntthanh.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
//    @Autowired
//    JavaMailSender emailSender;
    @Autowired
    MailSender mailSender;
    @GetMapping("/account")
    public ResponseEntity<List<Account>> listAccount() {
        List<Account> accounts = this.customerService.finAllAccount();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/getByAccount/{id}")
    public ResponseEntity<Account> accountCustomer(@PathVariable String id){
        Account account = this.accountService.findById(id);
        if (account == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
    @PutMapping("/changePassWord")
    public ResponseEntity<Account> changePass(@Valid  @RequestBody DtoAccount dtoAccount, BindingResult bindingResult){
       if (!bindingResult.hasFieldErrors()){
        this.accountService.changePassWord(dtoAccount);
        return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @GetMapping("/detailCustomerByAccount/{id}")
    public ResponseEntity<Customers> findCustomerByAccount(@PathVariable String id){
        Customers customers = customerService.findCustomerByAccount(id);
        if (customers == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<Page<Customers>> listCustomer(@PageableDefault(size = 5)Pageable pageable){
        System.out.println();
        Page<Customers> customersPage = customerService.finAll(pageable);
        if(customersPage == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customersPage, HttpStatus.OK);
    }
    @GetMapping("/getInformation/{id}")
    public ResponseEntity<Customers> getInforCustomer(@PathVariable String id){
        Customers customers = customerService.findById(id);
        if (customers == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/getInforByAdmin/{id}")
    public ResponseEntity<Account> getInforByAdmin(@PathVariable String id){
        Account account = customerService.getAccountByIdCustomer(id);
        if (account == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    public void sendEmail(String from,String to, String subject, String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);

        mailSender.send(mailMessage);
    }
    @PostMapping("/create")
    public ResponseEntity<Customers> createCustomer(@Valid @RequestBody DtoCustomer customers, BindingResult bindingResult)  {
        System.out.println();
        if (!bindingResult.hasFieldErrors()){
            customerService.saveCustomer(customers);
//            MimeMessage message = emailSender.createMimeMessage();
//
//            MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
            String htmlMsg = "Chào mừng Email: " + customers.getEmail() + "\n" + "Tài khoản đăng ký: " + customers.getAccount() +
                    "\n" + "Mật khẩu: "+ customers.getPasswork() + "\n" + "Vui lòng truy cập vào link: http://localhost:4200/login " +
                    "để đăng nhập" + "\n" + "Xin cám ơn!";
//            message.setContent(htmlMsg, "test/html");
//            helper.setTo(customers.getEmail());
//            helper.setSubject("Welcome, you have successfully registered an account ad TapHoa24h");
//            this.emailSender.send(message);
            String subject = "Welcome, you have successfully registered an account ad TapHoa24h";
            sendEmail("TapHoa24h",customers.getEmail(),subject,htmlMsg);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/edit")
    public ResponseEntity<Customers> editCustomer(@Valid @RequestBody DtoCustomer customers,BindingResult bindingResult){

        if (!bindingResult.hasFieldErrors()){
            this.customerService.updateCustomer(customers);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customers> deleteCustomer(@PathVariable String id){
        Customers customers = customerService.findById(id);
        if (customers == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(customers.getIdCustomer());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Customers>> searchCustomer(@RequestParam ("key")String name, @PageableDefault(size = 5) Pageable pageable){
        Page<Customers> customersPage = this.customerService.searchCustomer(name,pageable);
        if (customersPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customersPage,HttpStatus.OK);
    }
}
