package az.bank.account.msaccount.scheduler;

import az.bank.account.msaccount.mapper.AccountCheckMapper;
import az.bank.account.msaccount.model.AccountCheckDto;
import az.bank.account.msaccount.model.AccountDto;
import az.bank.account.msaccount.model.MailDto;
import az.bank.account.msaccount.queue.AccountMailSender;
import az.bank.account.msaccount.service.AccountCheckService;
import az.bank.account.msaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class AccountSchedler {
    private final AccountService accountService;
    private final AccountCheckService accountCheckService;
    private final AccountMailSender accountMailSender;

    public AccountSchedler(AccountService accountService,
                           AccountCheckService accountCheckService,
                           AccountMailSender accountMailSender) {
        this.accountService = accountService;
        this.accountCheckService = accountCheckService;
        this.accountMailSender = accountMailSender;
    }

    @Scheduled(fixedDelay = 20_000)

   // @Scheduled(cron = "0 0/15 * * * ?")
    @SchedulerLock(name = "listAccounts",
            lockAtLeastForString = "PT5M")
    public void listAccounts() {
        String sequence = accountCheckService.getAccount().getSequenceNumber();
        log.info("Checking.......<");

        accountCheckService.getBySequenceNumber(sequence).forEach(checkDto -> {
            accountService.getAccounts()
                    .stream()
                    .filter(accDto -> checkDto.getAccountNo()
                            .equals(accDto.getAccountNo()))
                    .filter(accDto -> ((checkDto.getAmount() != accDto.getAmount())))
                    .forEachOrdered(accDto -> {
                        String text="Musterinin ID-si : " + accDto.getCustomerId()
                                + ", Hesabdaki Ferq : "
                                + (accDto.getAmount() - checkDto.getAmount());
                        System.out.println(text);
                        accountMailSender.sendMail(MailDto
                                .builder()
                                .text(text)
                                .build());
                    });
        });

        log.info("Checking.......>");

        log.info("Reporting.......<");

        String seqNumber = "SN"
                + LocalDateTime.now().getYear() + "|"
                + LocalDateTime.now().getMonth() + "|"
                + LocalDateTime.now().getDayOfMonth() + "|"
                + LocalDateTime.now().getHour() + "|"
                + LocalDateTime.now().getMinute() + "|"
                + LocalDateTime.now().getSecond();

        List<AccountDto> accountDtos = accountService.getAccounts();

        accountDtos.forEach(accountDto ->
                accountCheckService.createAccount(
                        AccountCheckMapper.accountToCheck(accountDto, seqNumber)));

        log.info("Reporting.......>");


    }
}
